package jp.co.veritrans.airweb.sample.server.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.veritrans.airweb.mdk.bean.EncryptKeyBox;
import jp.co.veritrans.airweb.mdk.bean.ResultDataBean;
import jp.co.veritrans.airweb.mdk.common.ResultCheck;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * ブラウザからの決済結果を受け取り、比較する処理のActionクラス
 */
public class DoPostActionBrowser extends Action {

    /**
     * ログ出力用インスタンス
     */
    private Logger log = Logger.getLogger(DoPostActionBrowser.class);

    /**
     * リクエストを処理してレスポンスを返すメソッド
     * 
     * @param mapping このインスタンスを選択するために使用するマッピング
     * @param form このリクエストのためのアクションフォーム
     * @param request 処理中のHTTPリクエスト
     * @param response 生成するHTTPレスポンス
     * @return 次のJSPのマッピング情報
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) {
        log.info("決済結果整合性確認開始");

        ResultCheck rcheck = new ResultCheck();
        EncryptKeyBox keyBox = EncryptKeyBox.getInstance();
        boolean complete = false;

        ResultDataBean databean = new ResultDataBean();

        DoPostForm commForm = (DoPostForm)form;

        if (log.isInfoEnabled()) {
            log.info("orderId=" + commForm.getOrderId());
            log.info("mStatus=" + commForm.getmStatus());
            log.info("vResultCode=" + commForm.getvResultCode());
            log.info("sessionId=" + commForm.getSessionId());
        }

        databean.setOrderId(commForm.getOrderId());
        databean.setmStatus(commForm.getmStatus());
        databean.setvResultCode(commForm.getvResultCode());
        databean.setSessionId(commForm.getSessionId());

        Map box = keyBox.getBox(commForm.getOrderId());
        if (box != null) {
            complete = rcheck.resultCrossCheck(box, databean);
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
