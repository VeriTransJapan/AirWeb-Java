package jp.co.veritrans.airweb.sample.server.action;

import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.veritrans.airweb.mdk.bean.CommodityDetail;
import jp.co.veritrans.airweb.mdk.bean.EncryptionKey;
import jp.co.veritrans.airweb.mdk.bean.ResultsList;
import jp.co.veritrans.airweb.mdk.common.Constants;
import jp.co.veritrans.airweb.mdk.common.MDKUtils;
import jp.co.veritrans.airweb.mdk.common.StringUtil;
import jp.co.veritrans.airweb.mdk.conf.MerchantConf;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 * 全Actionクラスの基底クラス
 */
public abstract class BasicAction extends Action {

    /**
     * ログ出力用インスタンス
     */
    private static Logger log = Logger.getLogger(BasicAction.class);

    /**
     * 決済固有情報を設定
     *
     * @param form 情報を取得するアクションフォームクラス
     */
    protected abstract void addInfomation(PaymentForm form);

    /**
     * 商品リストからCommodityDetailクラスの配列を作成する
     *
     * @param commForm 情報を取得するフォームアクションクラス
     * @return CommodityDetailクラスの配列
     */
    protected CommodityDetail[] createCommodityDetails(final PaymentForm commForm) {
        String[] id = commForm.getCommodityId();
        String[] name = commForm.getCommodityName();
        String[] unit = commForm.getCommodityUnit();
        String[] num = commForm.getCommodityNum();
        String[] janCode = commForm.getCommodityJanCode();

        if (MDKUtils.isEmptyArray(name)) {
            return null;
        }

        int nameLen = name.length;
        CommodityDetail[] commodityDetail = new CommodityDetail[nameLen];

        for (int i = 0; i < name.length; i++) {
            commodityDetail[i] = new CommodityDetail(id[i], // 商品ID
                    janCode[i], // JANコード
                    name[i], // 商品名
                    new Integer(unit[i]), // 個数
                    new Integer(num[i])); // 単価
        }
        return commodityDetail;
    }

    /**
     * マーチャント暗号鍵とsessionIdの登録
     *
     * @param settlementKey1B マーチャント側の暗号鍵
     */
    protected void registKey(final String orderId, final String settlementKey1B, final String sessionId) {
        // settlementKey1Bを登録（暗号鍵保持クラスに登録）
        // DB使用を推奨
        ResultsList resultsList = ResultsList.getInstance();
        Map<String, String> keyMap = new HashMap<String, String>();
        keyMap.put(Constants.AWRES_SETTLEMENTKEY1B, settlementKey1B);
        keyMap.put(Constants.AWRES_SESSION_ID, sessionId);
        resultsList.setResult(orderId, keyMap);
    }

    /**
     * 暗号鍵リクエストメッセージを送信する
     *
     * @param mapping このインスタンスを選択するために使用するマッピング
     * @param form このリクエストのためのアクションフォーム
     * @param request 処理中のHTTPリクエスト
     * @param response 生成するHTTPレスポンス
     * @return 次のJSPのマッピング情報
     * @throws NoSuchAlgorithmException 使用可能でないアルゴリズムが指定された
     * @throws RemoteException ウェブサービスエラー
     * @throws ServiceException ウェブサービスエラー
     */
    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request,
            final HttpServletResponse response) {
        log.info("メッセージ送信処理開始");
        PaymentForm commForm = (PaymentForm)form;

        // 商品情報は未入力でも送信可能
        // if (commForm == null || commForm.getCommodityName() == null) {
        if (commForm == null || StringUtil.isNullStr(commForm.getAmount())) {
            log.info("Formがnullのためやり直し");
            ActionMessages errors = new ActionMessages();
            errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.formget"));
            saveErrors(request, errors);
            return mapping.findForward("retry");
        }

        HttpSession session = request.getSession(true);
        // 取引IDは処理日時をベースにダミーで作成。
        String orderId = MDKUtils.createDummyOrderId();
        String sessionId = session.getId();
        try {
            addInfomation(commForm);
            CommodityDetail[] commodityDetails = createCommodityDetails(commForm);

            EncryptionKey encryptionKey = null;
            // リクエストの送信とマーチャント暗号鍵の格納
            encryptionKey = send(sessionId, orderId, commForm, commodityDetails);

            if (encryptionKey == null) {
                log.info("鍵の取得に失敗");
                ActionMessages errors = new ActionMessages();
                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.webservice"));
                saveErrors(request, errors);
                return mapping.findForward("retry");
            } else {
                if (!StringUtil.isNullStr(encryptionKey.getErrorMessage())) {
                    log.info("エラーあり:" + encryptionKey.getErrorMessage());
                    ActionMessages errors = new ActionMessages();
                    ActionMessage aMessage = new ActionMessage("error.airweb", encryptionKey.getErrorMessage());
                    errors.add(ActionMessages.GLOBAL_MESSAGE, aMessage);
                    saveErrors(request, errors);
                    return mapping.findForward("retry");
                } else if (encryptionKey.getBrowserEncryptionKey() == null) {
                    // エラーメッセージが無く、ブラウザ暗号鍵も無い
                    log.info("鍵の取得に失敗");
                    ActionMessages errors = new ActionMessages();
                    errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.webservice"));
                    saveErrors(request, errors);
                    return mapping.findForward("retry");
                }
            }

            MerchantConf info = MerchantConf.getInfo();
            request.setAttribute("ORDER_ID", orderId);
            request.setAttribute("MERCHANT_ID", info.getMerchantId());
            request.setAttribute("SETTLEMENT_KEY1A", encryptionKey.getBrowserEncryptionKey());
        } catch (Throwable th) {
            log.error("例外をキャッチしました", th);
            return mapping.findForward("retry");
        }

        return mapping.findForward("confirm");
    }

    /**
     * 送信する。
     *
     * @param orderId 取引ID
     * @param commForm 入力フォーム
     * @param commodityDetails 購入情報
     * @return
     * @throws ServiceException
     * @throws RemoteException
     */
    protected abstract EncryptionKey send(String sessionId, String orderId, PaymentForm commForm,
            CommodityDetail[] commodityDetails) throws NoSuchAlgorithmException;
}
