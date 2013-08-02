package jp.co.veritrans.airweb.sample.server.action;

import org.apache.struts.action.ActionForm;

/**
 * ブラウザからの決済結果を受け取り、比較する処理のActionFormクラス
 */
public class DoPostForm extends ActionForm {

    /**
     * serial version UID.
     */
    private static final long serialVersionUID = 8664728883149660895L;

    /**
     * 取引ID
     */
    private String orderId;

    /**
     * 決済結果のステータス
     */
    private String mStatus;

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
    public DoPostForm() {
        super();
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
    public void setOrderId(String orderId) {
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
    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
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
    public void setvResultCode(String vResultCode) {
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
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
