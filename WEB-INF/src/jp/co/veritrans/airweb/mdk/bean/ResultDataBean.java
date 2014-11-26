package jp.co.veritrans.airweb.mdk.bean;

/**
 * 決済結果を保持するBean
 */
public class ResultDataBean {

    /**
     * 取引ID
     */
    private String orderId;

    /**
     * 決済結果のステータス
     */
    private String mStatus;

    /**
     * エラーメッセージ
     */
    private String mErrMsg;

    /**
     * 結果コード
     */
    private String vResultCode;

    /**
     * セッションID
     */
    private String sessionId;

    /**
     * コンストラクタ
     */
    public ResultDataBean() {

    }

    /**
     * orderIdの取得
     *
     * @return the orderId of String
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * orderIdの設定
     *
     * @param orderId the orderId to set
     */
    public void setOrderId(final String orderId) {
        this.orderId = orderId;
    }

    /**
     * mStatusの取得
     *
     * @return the mStatus of String
     */
    public String getmStatus() {
        return mStatus;
    }

    /**
     * mStatusの設定
     *
     * @param mStatus the mStatus to set
     */
    public void setmStatus(final String mStatus) {
        this.mStatus = mStatus;
    }

    /**
     * mErrMsgの取得
     *
     * @return the mErrMsg of String
     */
    public String getmErrMsg() {
        return mErrMsg;
    }

    /**
     * mErrMsgの設定
     *
     * @param mErrMsg the mErrMsg to set
     */
    public void setmErrMsg(final String mErrMsg) {
        this.mErrMsg = mErrMsg;
    }

    /**
     * vResultCodeの取得
     *
     * @return the vResultCode of String
     */
    public String getvResultCode() {
        return vResultCode;
    }

    /**
     * vResultCodeの設定
     *
     * @param vResultCode the vResultCode to set
     */
    public void setvResultCode(final String vResultCode) {
        this.vResultCode = vResultCode;
    }

    /**
     * sessionIdの取得
     *
     * @return the sessionId of String
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * sessionIdの設定
     *
     * @param sessionId the sessionId to set
     */
    public void setSessionId(final String sessionId) {
        this.sessionId = sessionId;
    }
}
