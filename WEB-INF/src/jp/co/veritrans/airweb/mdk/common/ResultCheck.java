package jp.co.veritrans.airweb.mdk.common;

import java.util.Map;

import jp.co.veritrans.airweb.mdk.bean.ResultDataBean;

import org.apache.log4j.Logger;

/**
 * 決済結果のチェックを行うクラス
 */
public class ResultCheck {

    /**
     * ログ出力用インスタンス
     */
    private final Logger log = Logger.getLogger(ResultCheck.class);

    /**
     * AWからのRequestの内容確認
     *
     * @param databean AWからの情報
     * @return 正しい場合true 正しくない場合false
     */
    public boolean resultCheck(final ResultDataBean databean) {
        boolean checkflag;

        // どれか一つでもnullがあったらエラー
        if (databean.getOrderId() == null || databean.getOrderId().equals("null")) {
            checkflag = false;
        } else if (databean.getmStatus() == null || databean.getmStatus().equals("null")) {
            checkflag = false;
        } else if (databean.getmErrMsg() == null || databean.getmErrMsg().equals("null")) {
            checkflag = false;
        } else if (databean.getvResultCode() == null || databean.getvResultCode().equals("null")) {
            checkflag = false;
        } else {
            checkflag = true;
            log.info("リクエストにnullはなし");
        }

        return checkflag;
    }

    /**
     * AirWEB側とブラウザ側の整合性チェック
     *
     * @param result AirWEBのRequestの内容が格納されたMap
     * @param resultDataBean ブラウザのリクエストの内容が格納されたBean
     * @return 整合性の成否
     */
    public boolean resultCrossCheck(final Map<String, String> result, final ResultDataBean resultDataBean) {
        boolean complete;

        String mStatus = StringUtil.emptyString(result.get(Constants.AWRES_M_STATUS));
        String vResultCode = StringUtil.emptyString(result.get(Constants.AWRES_V_RESULT_CODE));
        String sessionId = StringUtil.emptyString(result.get(Constants.AWRES_SESSION_ID));

        if (log.isInfoEnabled()) {
            log.info("stored mStatus=" + mStatus);
            log.info("stored vResultCode=" + vResultCode);
            log.info("stored sessionId=" + sessionId);
        }

        complete = mStatus.equals(resultDataBean.getmStatus());
        complete &= vResultCode.equals(resultDataBean.getvResultCode());
        complete &= sessionId.equals(resultDataBean.getSessionId());
        return complete;
    }
}
