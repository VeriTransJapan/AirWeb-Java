package jp.co.veritrans.airweb.sample.server.action;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import jp.co.veritrans.airweb.mdk.common.MDKUtils;
import jp.co.veritrans.airweb.mdk.common.StringUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 * 決済情報のActionFormクラス
 */
public class PaymentForm extends ActionForm {

    /**
     * serial version UID.
     */
    private static final long serialVersionUID = -7381901876252825928L;

    /**
     * ログ出力用インスタンス
     */
    private static Logger log = Logger.getLogger(PaymentForm.class);

    /** マーチャントID */
    private String merchantId = "";

    /** マーチャント生成ハッシュ値 */
    private String merchanthash = "";

    /** 決済方法 */
    private String settlementType = "";

    /** 取引ID */
    private String orderId = "";

    /** 購入金額 */
    private String amount = "";

    /** 送料合計 */
    private String shippingAmount = "";

    /** SessionID */
    private String sessionId = "";

    /** 支払期限 */
    private String timelimitOfPayment = "";

    /** 決済完了後戻りURL */
    private String finishPaymentReturnUrl = "";

    /** 未決済時戻りURL */
    private String unfinishPaymentReturnUrl = "";

    /** 決済エラー時戻りURL */
    private String errorPaymentReturnUrl = "";

    /** 決済結果通知先URL */
    private String finishPaymentAccessUrl = "";

    /** ダミー決済フラグ */
    private String dummyPaymentFlag = "";

    /** カード売上フラグ */
    private String cardCaptureFlag = "";

    /** 名前１ */
    private String name1 = "";

    /** 名前２ */
    private String name2 = "";

    /** カナ１ */
    private String kana1 = "";

    /** カナ２ */
    private String kana2 = "";

    /** 電話番号 */
    private String telephoneNo = "";

    /** メールアドレス */
    private String mailAddress = "";

    /** 郵便番号 */
    private String zipCode = "";

    /** 住所１ */
    private String address1 = "";

    /** 住所２ */
    private String address2 = "";

    /** 住所３ */
    private String address3 = "";

    /** 生年月日 */
    private String birthday = "";

    /** 性別 */
    private String sex = "";

    /** 商品ID */
    private String[] commodityId;

    /** 単価 */
    private String[] commodityUnit;

    /** 個数 */
    private String[] commodityNum;

    /** 商品名 */
    private String[] commodityName;

    /** JANコード */
    private String[] commodityJanCode;

    /**
     * merchantIdの取得
     *
     * @return the merchantId of String
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * merchantIdの設定
     *
     * @param merchantId the merchantId to set
     */
    public void setMerchantId(final String merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * merchanthashの取得
     *
     * @return the merchanthash of String
     */
    public String getMerchanthash() {
        return merchanthash;
    }

    /**
     * merchanthashの設定
     *
     * @param merchanthash the merchanthash to set
     */
    public void setMerchanthash(final String merchanthash) {
        this.merchanthash = merchanthash;
    }

    /**
     * settlementTypeの取得
     *
     * @return the settlementType of String
     */
    public String getSettlementType() {
        return settlementType;
    }

    /**
     * settlementTypeの設定
     *
     * @param settlementType the settlementType to set
     */
    public void setSettlementType(final String settlementType) {
        this.settlementType = settlementType;
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
     * amountの取得
     *
     * @return the amount of String
     */
    public String getAmount() {
        return amount;
    }

    /**
     * amountの設定
     *
     * @param amount the amount to set
     */
    public void setAmount(final String amount) {
        this.amount = amount;
    }

    /**
     * shippingAmountの取得
     *
     * @return the shippingAmount of String
     */
    public String getShippingAmount() {
        return shippingAmount;
    }

    /**
     * shippingAmountの設定
     *
     * @param shippingAmount the shippingAmount to set
     */
    public void setShippingAmount(final String shippingAmount) {
        this.shippingAmount = shippingAmount;
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

    /**
     * timelimitOfPaymentの取得
     *
     * @return the timelimitOfPayment of String
     */
    public String getTimelimitOfPayment() {
        return timelimitOfPayment;
    }

    /**
     * timelimitOfPaymentの設定
     *
     * @param timelimitOfPayment the timelimitOfPayment to
     *            set
     */
    public void setTimelimitOfPayment(final String timelimitOfPayment) {
        this.timelimitOfPayment = timelimitOfPayment;
    }

    /**
     * finishPaymentReturnUrlの取得
     *
     * @return the finishPaymentReturnUrl of String
     */
    public String getFinishPaymentReturnUrl() {
        return finishPaymentReturnUrl;
    }

    /**
     * finishPaymentReturnUrlの設定
     *
     * @param finishPaymentReturnUrl the
     *            finishPaymentReturnUrl to set
     */
    public void setFinishPaymentReturnUrl(final String finishPaymentReturnUrl) {
        this.finishPaymentReturnUrl = finishPaymentReturnUrl;
    }

    /**
     * unfinishPaymentReturnUrlの取得
     *
     * @return the unfinishPaymentReturnUrl of String
     */
    public String getUnfinishPaymentReturnUrl() {
        return unfinishPaymentReturnUrl;
    }

    /**
     * unfinishPaymentReturnUrlの設定
     *
     * @param unfinishPaymentReturnUrl the
     *            unfinishPaymentReturnUrl to set
     */
    public void setUnfinishPaymentReturnUrl(final String unfinishPaymentReturnUrl) {
        this.unfinishPaymentReturnUrl = unfinishPaymentReturnUrl;
    }

    /**
     * errorPaymentReturnUrlの取得
     *
     * @return the errorPaymentReturnUrl of String
     */
    public String getErrorPaymentReturnUrl() {
        return errorPaymentReturnUrl;
    }

    /**
     * errorPaymentReturnUrlの設定
     *
     * @param errorPaymentReturnUrl the
     *            errorPaymentReturnUrl to set
     */
    public void setErrorPaymentReturnUrl(final String errorPaymentReturnUrl) {
        this.errorPaymentReturnUrl = errorPaymentReturnUrl;
    }

    /**
     * finishPaymentAccessUrlの取得
     *
     * @return the finishPaymentAccessUrl of String
     */
    public String getFinishPaymentAccessUrl() {
        return finishPaymentAccessUrl;
    }

    /**
     * finishPaymentAccessUrlの設定
     *
     * @param finishPaymentAccessUrl the
     *            finishPaymentAccessUrl to set
     */
    public void setFinishPaymentAccessUrl(final String finishPaymentAccessUrl) {
        this.finishPaymentAccessUrl = finishPaymentAccessUrl;
    }

    /**
     * dummyPaymentFlagの取得
     *
     * @return the dummyPaymentFlag of String
     */
    public String getDummyPaymentFlag() {
        return dummyPaymentFlag;
    }

    /**
     * dummyPaymentFlagの設定
     *
     * @param dummyPaymentFlag the dummyPaymentFlag to set
     */
    public void setDummyPaymentFlag(final String dummyPaymentFlag) {
        this.dummyPaymentFlag = dummyPaymentFlag;
    }

    /**
     * cardCaptureFlagの取得
     *
     * @return the cardCaptureFlag of String
     */
    public String getCardCaptureFlag() {
        return cardCaptureFlag;
    }

    /**
     * cardCaptureFlagの設定
     *
     * @param cardCaptureFlag the cardCaptureFlag to set
     */
    public void setCardCaptureFlag(final String cardCaptureFlag) {
        this.cardCaptureFlag = cardCaptureFlag;
    }

    /**
     * name1の取得
     *
     * @return the name1 of String
     */
    public String getName1() {
        return name1;
    }

    /**
     * name1の設定
     *
     * @param name1 the name1 to set
     */
    public void setName1(final String name1) {
        this.name1 = name1;
    }

    /**
     * name2の取得
     *
     * @return the name2 of String
     */
    public String getName2() {
        return name2;
    }

    /**
     * name2の設定
     *
     * @param name2 the name2 to set
     */
    public void setName2(final String name2) {
        this.name2 = name2;
    }

    /**
     * kana1の取得
     *
     * @return the kana1 of String
     */
    public String getKana1() {
        return kana1;
    }

    /**
     * kana1の設定
     *
     * @param kana1 the kana1 to set
     */
    public void setKana1(final String kana1) {
        this.kana1 = kana1;
    }

    /**
     * kana2の取得
     *
     * @return the kana2 of String
     */
    public String getKana2() {
        return kana2;
    }

    /**
     * kana2の設定
     *
     * @param kana2 the kana2 to set
     */
    public void setKana2(final String kana2) {
        this.kana2 = kana2;
    }

    /**
     * telephoneNoの取得
     *
     * @return telephoneNo
     */
    public String getTelephoneNo() {
        return telephoneNo;
    }

    /**
     * telephoneNoの設定
     *
     * @param telephoneNo the telephoneNo to set
     */
    public void setTelephoneNo(final String telephoneNo) {
        this.telephoneNo = telephoneNo;
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
    public void setMailAddress(final String mailAddress) {
        this.mailAddress = mailAddress;
    }

    /**
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * zipCodeの設定
     *
     * @param zipCode the zipCode to set
     */
    public void setZipCode(final String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * address1の取得
     *
     * @return the address1 of String
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * address1の設定
     *
     * @param address1 the address1 to set
     */
    public void setAddress1(final String address1) {
        this.address1 = address1;
    }

    /**
     * address2の取得
     *
     * @return the address2 of String
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * address2の設定
     *
     * @param address2 the address2 to set
     */
    public void setAddress2(final String address2) {
        this.address2 = address2;
    }

    /**
     * address3の取得
     *
     * @return the address3 of String
     */
    public String getAddress3() {
        return address3;
    }

    /**
     * address3の設定
     *
     * @param address3 the address3 to set
     */
    public void setAddress3(final String address3) {
        this.address3 = address3;
    }

    /**
     * @return the birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * birthdayの設定
     *
     * @param birthday the birthday to set
     */
    public void setBirthday(final String birthday) {
        this.birthday = birthday;
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
    public void setSex(final String sex) {
        this.sex = sex;
    }

    /**
     * commodityIdの取得
     *
     * @return the commodityId of String[]
     */
    public String[] getCommodityId() {
        return commodityId;
    }

    /**
     * commodityIdの設定
     *
     * @param commodityId the commodityId to set
     */
    public void setCommodityId(final String[] commodityId) {
        this.commodityId = commodityId;
    }

    /**
     * commodityUnitの取得
     *
     * @return the commodityUnit of String[]
     */
    public String[] getCommodityUnit() {
        return commodityUnit;
    }

    /**
     * commodityUnitの設定
     *
     * @param commodityUnit the commodityUnit to set
     */
    public void setCommodityUnit(final String[] commodityUnit) {
        this.commodityUnit = commodityUnit;
    }

    /**
     * commodityNumの取得
     *
     * @return the commodityNum of String[]
     */
    public String[] getCommodityNum() {
        return commodityNum;
    }

    /**
     * commodityNumの設定
     *
     * @param commodityNum the commodityNum to set
     */
    public void setCommodityNum(final String[] commodityNum) {
        this.commodityNum = commodityNum;
    }

    /**
     * commodityNameの取得
     *
     * @return the commodityName of String[]
     */
    public String[] getCommodityName() {
        return commodityName;
    }

    /**
     * commodityNameの設定
     *
     * @param commodityName the commodityName to set
     */
    public void setCommodityName(final String[] commodityName) {
        this.commodityName = commodityName;
    }

    /**
     * commodityJanCodeの取得
     *
     * @return the commodityJanCode of String[]
     */
    public String[] getCommodityJanCode() {
        return commodityJanCode;
    }

    /**
     * commodityJanCodeの設定
     *
     * @param commodityJanCode the commodityJanCode to set
     */
    public void setCommodityJanCode(final String[] commodityJanCode) {
        this.commodityJanCode = commodityJanCode;
    }

    /**
     * エラーチェック
     *
     * @param mapping このインスタンスを選択するために使用するマッピング
     * @param request 処理中のHTTPリクエスト
     * @return エラーメッセージ
     */
    @Override
    public ActionErrors validate(final ActionMapping mapping, final HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        return validate(mapping, request, errors);
    }

    /**
     * エラーチェック
     *
     * @param mapping このインスタンスを選択するために使用するマッピング
     * @param request 処理中のHTTPリクエスト
     * @param errors エラー格納インスタンス
     * @return エラーメッセージ
     */
    public ActionErrors validate(final ActionMapping mapping, final HttpServletRequest request,
            final ActionErrors errors) {
        log.info("入力情報をチェックします");

        // 名前１
        if (!StringUtil.isNullStr(getName1()) && !StringUtil.isMultiByte(getName1())) {
            addError(errors, "error.name1.multibyte");
        }

        // 名前２
        if (!StringUtil.isNullStr(getName2()) && !StringUtil.isMultiByte(getName2())) {
            addError(errors, "error.name2.multibyte");
        }

        // カナ１
        if (!StringUtil.isNullStr(getKana1()) && !StringUtil.isMultiByteKana(getKana1())) {
            addError(errors, "error.kana1.multibyte");
        }

        // カナ２
        if (!StringUtil.isNullStr(getKana2()) && !StringUtil.isMultiByteKana(getKana2())) {
            addError(errors, "error.kana2.multibyte");
        }

        // 電話番号
        if (!StringUtil.isNullStr(getTelephoneNo()) && !StringUtil.isSingleByte(getTelephoneNo())) {
            addError(errors, "error.telephoneNo.singlebyte");
        }

        // メールアドレス
        if (!StringUtil.isNullStr(getMailAddress()) && !StringUtil.isSingleByte(getMailAddress())) {
            addError(errors, "error.mailAddress.singlebyte");
        }

        // 郵便番号
        if (!StringUtil.isNullStr(getZipCode()) && !getZipCode().equals(StringUtil.removeNonNumber(getZipCode()))) {
            addError(errors, "error.zipCode.forbiddenchar");
        }

        // 住所１
        if (!StringUtil.isNullStr(getAddress1()) && !StringUtil.isMultiByte(getAddress1())) {
            addError(errors, "error.address1.multibyte");
        }

        // 住所2
        if (!StringUtil.isNullStr(getAddress2()) && !StringUtil.isMultiByte(getAddress2())) {
            addError(errors, "error.address2.multibyte");
        }

        // 住所3
        if (!StringUtil.isNullStr(getAddress3()) && !StringUtil.isMultiByte(getAddress3())) {
            addError(errors, "error.address3.multibyte");
        }

        // 生年月日
        if (!birthdayCheck(getBirthday())) {
            addError(errors, "error.birthday.notdate");
        }

        // 送料合計
        if (!StringUtil.isNullStr(getShippingAmount())) {
            if (!StringUtil.isNumeric(getShippingAmount())) {
                addError(errors, "error.cardHolderName.invalid");
            }
        }

        // 商品情報
        if (MDKUtils.isEmptyArray(getCommodityName())) {
            if (!MDKUtils.isEmptyArray(getCommodityId()) || !MDKUtils.isEmptyArray(getCommodityJanCode())
                    || !MDKUtils.isEmptyArray(getCommodityNum()) || !MDKUtils.isEmptyArray(getCommodityUnit())) {
                // 商品名に入力がない場合は商品情報は入力不可
                logCommodityInfo();
                addError(errors, "error.commodityinfo.invalid");
            }
        } else {
            int commoditySize = getCommodityName().length;
            if (MDKUtils.isEmptyArray(getCommodityNum()) || getCommodityNum().length != commoditySize
                    || MDKUtils.isEmptyArray(getCommodityUnit()) || getCommodityUnit().length != commoditySize
                    || !MDKUtils.isEmptyArray(getCommodityId()) && getCommodityId().length != commoditySize
                    || !MDKUtils.isEmptyArray(getCommodityJanCode()) && getCommodityJanCode().length != commoditySize) {
                // 商品名の入力数と個数、単価の入力数は一致していければならない
                // 商品IDとJAN_CODEは入力必須ではないが、入力している場合は商品名の入力数と一致していなければならない
                logCommodityInfo();
                addError(errors, "error.commodityinfo.unnmatch");
            } else {
                for (int i = 0; i < commoditySize; i++) {
                    if (!StringUtil.isNumeric(getCommodityNum()[i]) || !StringUtil.isNumeric(getCommodityUnit()[i])) {
                        // 単価と個数は数値項目でなければならない
                        logCommodityInfo();
                        addError(errors, "error.commodityinfo.notnumeric");
                    }
                }
            }
        }
        return errors;
    }

    /**
     * 日付の整合性チェック
     *
     * @param birthday 誕生日（年）
     * @return 日付が正しいかどうかの判定
     */
    private boolean birthdayCheck(final String birthday) {
        if (StringUtils.isEmpty(birthday)) {
            // 未記入はチェックしない
            return true;
        }
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
            df.setLenient(false);
            df.parse(birthday);
            return true;
        } catch (Exception e) {
            log.info("日付フォーマット不正 yyyyMMdd = " + birthday);
            return false;
        }
    }

    /**
     * 商品情報をログ出力する。
     */
    protected void logCommodityInfo() {
        if (!MDKUtils.isEmptyArray(getCommodityId())) {
            for (int i = 0; i < getCommodityId().length; i++) {
                log.warn("COMMODITY_ID[" + i + "] = " + getCommodityId()[i]);
            }
        } else {
            log.warn("COMMODITY_ID is Empty");
        }

        if (!MDKUtils.isEmptyArray(getCommodityUnit())) {
            for (int i = 0; i < getCommodityUnit().length; i++) {
                log.warn("COMMODITY_UNIT[" + i + "] = " + getCommodityUnit()[i]);
            }
        } else {
            log.warn("COMMODITY_UNIT is Empty");
        }

        if (!MDKUtils.isEmptyArray(getCommodityNum())) {
            for (int i = 0; i < getCommodityNum().length; i++) {
                log.warn("COMMODITY_NUM[" + i + "] = " + getCommodityNum()[i]);
            }
        } else {
            log.warn("COMMODITY_NUM is Empty");
        }

        if (!MDKUtils.isEmptyArray(getCommodityName())) {
            for (int i = 0; i < getCommodityName().length; i++) {
                log.warn("COMMODITY_NAME[" + i + "] = " + getCommodityName()[i]);
            }
        } else {
            log.warn("COMMODITY_NAME is Empty");
        }

        if (!MDKUtils.isEmptyArray(getCommodityJanCode())) {
            for (int i = 0; i < getCommodityJanCode().length; i++) {
                log.warn("JAN_CODE[" + i + "] = " + getCommodityJanCode()[i]);
            }
        } else {
            log.warn("JAN_CODE is Empty");
        }
    }

    /**
     * エラーメッセージ登録メソッド
     *
     * @param errors ActionErrorsインスタンス
     * @param errorMsgId エラー文言ID
     */
    protected void addError(final ActionErrors errors, final String errorMsgId) {
        ActionMessage tmp = new ActionMessage(errorMsgId);
        errors.add(ActionMessages.GLOBAL_MESSAGE, tmp);
    }

}
