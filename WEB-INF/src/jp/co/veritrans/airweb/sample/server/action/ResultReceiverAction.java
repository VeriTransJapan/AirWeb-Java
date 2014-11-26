package jp.co.veritrans.airweb.sample.server.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.veritrans.airweb.mdk.bean.ResultDataBean;
import jp.co.veritrans.airweb.mdk.bean.ResultsList;
import jp.co.veritrans.airweb.mdk.common.ResultCheck;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * ブラウザからの決済結果を受け取り、比較する処理のActionクラス
 */
public class ResultReceiverAction extends Action {

    /**
     * ログ出力用インスタンス
     */
    private final Logger log = Logger.getLogger(ResultReceiverAction.class);

    /**
     * リクエストを処理してレスポンスを返すメソッド
     *
     * @param mapping このインスタンスを選択するために使用するマッピング
     * @param form このリクエストのためのアクションフォーム
     * @param request 処理中のHTTPリクエスト
     * @param response 生成するHTTPレスポンス
     * @return 次のJSPのマッピング情報
     */
    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request,
            final HttpServletResponse response) {
        log.info("決済結果整合性確認開始");

        ResultCheck rcheck = new ResultCheck();
        ResultsList resultsList = ResultsList.getInstance();
        boolean complete = false;

        ResultDataBean resultDataBean = new ResultDataBean();

        ResultForm commForm = (ResultForm)form;

        if (log.isInfoEnabled()) {
            log.info("orderId=" + commForm.getOrderId());
            log.info("mStatus=" + commForm.getmStatus());
            log.info("vResultCode=" + commForm.getvResultCode());
            log.info("sessionId=" + commForm.getSessionId());
        }

        resultDataBean.setOrderId(commForm.getOrderId());
        resultDataBean.setmStatus(commForm.getmStatus());
        resultDataBean.setvResultCode(commForm.getvResultCode());
        resultDataBean.setSessionId(commForm.getSessionId());

        Map<String, String> result = resultsList.getResult(commForm.getOrderId());
        if (result != null) {
            complete = rcheck.resultCrossCheck(result, resultDataBean);
        } else {
            log.info("取引IDに該当する結果が有りません" + commForm.getOrderId());
        }

        // 一致すれば決済完了ページへ
        // 一致しなければエラーページへ
        if (complete) {
            return mapping.findForward("fin");
        } else {
            return mapping.findForward("err");
        }

    }
}
