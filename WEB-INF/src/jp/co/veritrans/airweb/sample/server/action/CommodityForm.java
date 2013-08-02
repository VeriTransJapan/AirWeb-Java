package jp.co.veritrans.airweb.sample.server.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import jp.co.veritrans.airweb.mdk.common.MDKUtils;
import jp.co.veritrans.airweb.mdk.common.StringUtil;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 * 決済情報のActionFormクラス
 */
public class CommodityForm extends ActionForm {

    /**
     * serial version UID.
     */
    private static final long serialVersionUID = -7381901876252825928L;

    /**
     * ログ出力用インスタンス
     */
    private static Logger log = Logger.getLogger(CommodityForm.class);

    /** マーチャントID */
    private String merchantId = "";

    /** マーチャント生成ハッシュ値 */
    private String merchanthash = "";

    /** 決済方法 */
    private String settlementType = "";

    /** 決済方法サブタイプ */
    private String settlementSubType = "";

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

    /** 言語選択可否フラグ */
    private String langEnableFlag = "";

    /** 使用言語 */
    private String lang = "";

    /** 暗号鍵有効期限 */
    private String encKeyLifeTime = "";

    /** ダミー決済フラグ */
    private String dummyPaymentFlag = "";

    /** カード支払区分 */
    private String cardInstallmentJpo = "";

    /** カード分割回数 */
    private String cardInstallmentJpoCnt = "";

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

    /** 電話番号(市外局番) */
    private String telephoneNo1 = "";

    /** 電話番号(市内局番) */
    private String telephoneNo2 = "";

    /** 電話番号(加入者番号) */
    private String telephoneNo3 = "";

    /** メールアドレス */
    private String mailAddress = "";

    /** 郵便番号(先頭3桁) */
    private String zipCode1 = "";

    /** 郵便番号(末尾4桁) */
    private String zipCode2 = "";

    /** 住所１ */
    private String address1 = "";

    /** 住所２ */
    private String address2 = "";

    /** 住所３ */
    private String address3 = "";

    /** 生年月日(年) */
    private String birthdayYYYY = "";

    /** 生年月日(月) */
    private String birthdayMM = "";

    /** 生年月日(日) */
    private String birthdayDD = "";

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
     * settlementSubTypeの取得
     *
     * @return the settlementSubType of String
     */
    public String getSettlementSubType() {
        return settlementSubType;
    }

    /**
     * settlementSubTypeの設定
     *
     * @param settlementSubType the settlementSubType to set
     */
    public void setSettlementSubType(final String settlementSubType) {
        this.settlementSubType = settlementSubType;
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
     * langEnableFlagの取得
     *
     * @return the langEnableFlag of String
     */
    public String getLangEnableFlag() {
        return langEnableFlag;
    }

    /**
     * langEnableFlagの設定
     *
     * @param langEnableFlag the langEnableFlag to set
     */
    public void setLangEnableFlag(final String langEnableFlag) {
        this.langEnableFlag = langEnableFlag;
    }

    /**
     * langの取得
     *
     * @return the lang of String
     */
    public String getLang() {
        return lang;
    }

    /**
     * langの設定
     *
     * @param lang the lang to set
     */
    public void setLang(final String lang) {
        this.lang = lang;
    }

    /**
     * 暗号鍵有効期限の取得
     *
     * @return the encKeyLifeTime
     */
    public String getEncKeyLifeTime() {
        return encKeyLifeTime;
    }

    /**
     * 暗号鍵有効期限の設定
     *
     * @param encKeyLifeTime the encKeyLifeTime to set
     */
    public void setEncKeyLifeTime(final String encKeyLifeTime) {
        this.encKeyLifeTime = encKeyLifeTime;
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
     * cardInstallmentJpoの取得
     *
     * @return the cardInstallmentJpo of String
     */
    public String getCardInstallmentJpo() {
        return cardInstallmentJpo;
    }

    /**
     * cardInstallmentJpoの設定
     *
     * @param cardInstallmentJpo the cardInstallmentJpo to
     *            set
     */
    public void setCardInstallmentJpo(final String cardInstallmentJpo) {
        this.cardInstallmentJpo = cardInstallmentJpo;
    }

    /**
     * cardInstallmentJpoCntの取得
     *
     * @return the cardInstallmentJpoCnt of String
     */
    public String getCardInstallmentJpoCnt() {
        return cardInstallmentJpoCnt;
    }

    /**
     * cardInstallmentJpoCntの設定
     *
     * @param cardInstallmentJpoCnt the
     *            cardInstallmentJpoCnt to set
     */
    public void setCardInstallmentJpoCnt(final String cardInstallmentJpoCnt) {
        this.cardInstallmentJpoCnt = cardInstallmentJpoCnt;
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
     * 電話番号の取得
     *
     * @return 電話番号
     */
    public String getTelephoneNo() {
        String tmp = StringUtil.emptyString(telephoneNo1) + StringUtil.emptyString(telephoneNo2)
                + StringUtil.emptyString(telephoneNo3);
        return tmp;
    }

    /**
     * @return the telephoneNo1
     */
    public String getTelephoneNo1() {
        return telephoneNo1;
    }

    /**
     * telephoneNo1の設定
     *
     * @param telephoneNo1 the telephoneNo1 to set
     */
    public void setTelephoneNo1(final String telephoneNo1) {
        this.telephoneNo1 = telephoneNo1;
    }

    /**
     * @return the telephoneNo2
     */
    public String getTelephoneNo2() {
        return telephoneNo2;
    }

    /**
     * telephoneNo2の設定
     *
     * @param telephoneNo2 the telephoneNo2 to set
     */
    public void setTelephoneNo2(final String telephoneNo2) {
        this.telephoneNo2 = telephoneNo2;
    }

    /**
     * @return the telephoneNo3
     */
    public String getTelephoneNo3() {
        return telephoneNo3;
    }

    /**
     * telephoneNo3の設定
     *
     * @param telephoneNo3 the telephoneNo3 to set
     */
    public void setTelephoneNo3(final String telephoneNo3) {
        this.telephoneNo3 = telephoneNo3;
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
     * 郵便番号の取得
     *
     * @return 郵便番号
     */
    public String getZipCode() {
        return StringUtil.emptyString(zipCode1) + StringUtil.emptyString(zipCode2);
    }

    /**
     * @return the zipCode1
     */
    public String getZipCode1() {
        return zipCode1;
    }

    /**
     * zipCode1の設定
     *
     * @param zipCode1 the zipCode1 to set
     */
    public void setZipCode1(final String zipCode1) {
        this.zipCode1 = zipCode1;
    }

    /**
     * @return the zipCode2
     */
    public String getZipCode2() {
        return zipCode2;
    }

    /**
     * zipCode2の設定
     *
     * @param zipCode2 the zipCode2 to set
     */
    public void setZipCode2(final String zipCode2) {
        this.zipCode2 = zipCode2;
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
     * 誕生日の取得
     *
     * @return 誕生日
     */
    public Date getBirthday() {
        Calendar birth = Calendar.getInstance();
        if (StringUtil.isNullStr(birthdayYYYY) || StringUtil.isNullStr(birthdayMM) || StringUtil.isNullStr(birthdayDD)) {
            return null;
        }
        try {
            birth.set(Integer.parseInt(birthdayYYYY), Integer.parseInt(birthdayMM) - 1, Integer.parseInt(birthdayDD));
            return birth.getTime();
        } catch (NumberFormatException e) {
            log.warn("日付情報(YYYYMMDD)に数値以外が入力されています。年=" + birthdayYYYY + ", 月=" + birthdayMM + ", 日=" + birthdayDD);
            return null;
        }
    }

    /**
     * @return the birthdayYYYY
     */
    public String getBirthdayYYYY() {
        return birthdayYYYY;
    }

    /**
     * birthdayYYYYの設定
     *
     * @param birthdayYYYY the birthdayYYYY to set
     */
    public void setBirthdayYYYY(final String birthdayYYYY) {
        this.birthdayYYYY = birthdayYYYY;
    }

    /**
     * @return the birthdayMM
     */
    public String getBirthdayMM() {
        return birthdayMM;
    }

    /**
     * birthdayMMの設定
     *
     * @param birthdayMM the birthdayMM to set
     */
    public void setBirthdayMM(final String birthdayMM) {
        if (StringUtil.emptyString(birthdayMM).length() == 1) {
            this.birthdayMM = "0" + birthdayMM;
        } else {
            this.birthdayMM = birthdayMM;
        }
    }

    /**
     * @return the birthdayDD
     */
    public String getBirthdayDD() {
        return birthdayDD;
    }

    /**
     * birthdayDDの設定
     *
     * @param birthdayDD the birthdayDD to set
     */
    public void setBirthdayDD(final String birthdayDD) {
        if (StringUtil.emptyString(birthdayDD).length() == 1) {
            this.birthdayDD = "0" + birthdayDD;
        } else {
            this.birthdayDD = birthdayDD;
        }
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
        if (!birthdaycheck(getBirthdayYYYY(), getBirthdayMM(), getBirthdayDD())) {
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
     * @param year 誕生日（年）
     * @param month 誕生日（月）
     * @param day 誕生日（日）
     * @return 日付が正しいかどうかの判定
     */
    private boolean birthdaycheck(final String year, final String month, final String day) {
        if (StringUtil.isNullStr(year) && StringUtil.isNullStr(month) && StringUtil.isNullStr(day)) {
            // すべて未記入はチェックしない
            return true;
        }
        if (StringUtil.isNullStr(year) || StringUtil.isNullStr(month) || StringUtil.isNullStr(day)) {
            // 中途半端に入力がある場合はエラー
            return false;
        }
        try {
            if (year.length() != 4) {
                log.info("年が４桁でない, year = " + year);
                return false;
            }

            SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
            df.setLenient(false);
            df.parse(year + month + day);
            return true;
        } catch (Exception e) {
            log.info("日付フォーマット不正 yyyyMMdd = " + year + month + day);
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
        errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(errorMsgId));
    }

}
