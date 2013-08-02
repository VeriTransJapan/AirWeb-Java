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
     * 受付番号
     */
    private String receiptNo;

    /**
     * 漢字氏名
     */
    private String userName;

    /**
     * カナ氏名
     */
    private String userNameKana;

    /**
     * メールアドレス
     */
    private String mailAddress;

    /**
     * 住所
     */
    private String address;

    /**
     * 性別
     */
    private String sex;

    /**
     * 電話番号
     */
    private String telephoneno;

    /**
     * 郵便番号
     */
    private String zipcode;

    /**
     * 誕生日
     */
    private String birthday;

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
    public void setmErrMsg(String mErrMsg) {
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

    /**
     * receiptNoの取得
     * 
     * @return the receiptNo of String
     */
    public String getReceiptNo() {
        return receiptNo;
    }

    /**
     * receiptNoの設定
     * 
     * @param receiptNo the receiptNo to set
     */
    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    /**
     * userNameの取得
     * 
     * @return the userName of String
     */
    public String getUserName() {
        return userName;
    }

    /**
     * userNameの設定
     * 
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * userNameKanaの取得
     * 
     * @return the userNameKana of String
     */
    public String getUserNameKana() {
        return userNameKana;
    }

    /**
     * userNameKanaの設定
     * 
     * @param userNameKana the userNameKana to set
     */
    public void setUserNameKana(String userNameKana) {
        this.userNameKana = userNameKana;
    }

    /**
     * mailAddressの取得
     * 
     * @return the mailAddress of String
     */
    public String getMailAddress() {
        return mailAddress;
    }

    /**
     * mailAddressの設定
     * 
     * @param mailAddress the mailAddress to set
     */
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    /**
     * addressの取得
     * 
     * @return the address of String
     */
    public String getAddress() {
        return address;
    }

    /**
     * addressの設定
     * 
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * sexの取得
     * 
     * @return the sex of String
     */
    public String getSex() {
        return sex;
    }

    /**
     * sexの設定
     * 
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * telephonenoの取得
     * 
     * @return the telephoneno of String
     */
    public String getTelephoneno() {
        return telephoneno;
    }

    /**
     * telephonenoの設定
     * 
     * @param telephoneno the telephoneno to set
     */
    public void setTelephoneno(String telephoneno) {
        this.telephoneno = telephoneno;
    }

    /**
     * zipcodeの取得
     * 
     * @return the zipcode of String
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * zipcodeの設定
     * 
     * @param zipcode the zipcode to set
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * birthdayの取得
     * 
     * @return the birthday of String
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * birthdayの設定
     * 
     * @param birthday the birthday to set
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

}
