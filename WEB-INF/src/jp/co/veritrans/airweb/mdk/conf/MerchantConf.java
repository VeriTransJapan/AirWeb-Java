package jp.co.veritrans.airweb.mdk.conf;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 * AIRWEBMDK.propertiesの値を保持するクラス
 */
public final class MerchantConf {

    /** 自インスタンス */
    private static MerchantConf info = null;

    /** ログ出力用インスタンス */
    private static Logger log = Logger.getLogger(MerchantConf.class);

    /** マーチャントID */
    private String merchantID = "";

    /** カード売上フラグ */
    private String cardCaptureFlag = "";

    /** シード */
    private String seed = "";

    /** 決済方法 */
    private String settlementType = "";

    /** AirWeb 暗号鍵取得URL */
    private String airWebRegistUrl = "";

    /** AirWeb 決済URL */
    private String airWebSettlementUrl = "";

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

    /** ダミー決済フラグ */
    private String dummyPaymentFlag = "";

    /** デフォルト支払期限 */
    private int defaultPayLimit = 0;

    /** デフォルト支払取消期限 */
    private int defaulCancelLimit = 0;

    /** コンビニ支払期限 */
    private int cvsPayLimit = 0;

    /** AirWebに送信するダミー商品ID */
    private String dummyCommodityId = "";

    /** AirWebに送信するダミーJAN_CODE */
    private String dummyCommodityJanCode = "";

    /**
     * コンストラクタ。外部からの生成を防止
     *
     */
    private MerchantConf() {
        ResourceBundle bdl = null;
        try {
            bdl = ResourceBundle.getBundle("AIRWEBMDK", Locale.JAPAN);
            merchantID = bdl.getString("MERCHANTID");
            seed = bdl.getString("SEED");
            settlementType = bdl.getString("SETTLEMENTTYPE");
            airWebRegistUrl = bdl.getString("AIRWEB_REGIST_URL");
            airWebSettlementUrl = bdl.getString("AIRWEB_SETTLEMENT_URL");
            finishPaymentReturnUrl = bdl.getString("FINISH_PAYMENT_RETURN_URL");
            unfinishPaymentReturnUrl = bdl.getString("UNFINISH_PAYMENT_RETURN_URL");
            errorPaymentReturnUrl = bdl.getString("ERROR_PAYMENT_RETURN_URL");
            finishPaymentAccessUrl = bdl.getString("FINISH_PAYMENT_ACCESS_URL");
            langEnableFlag = bdl.getString("LANG_ENABLE_FLAG");
            lang = bdl.getString("LANG");
            dummyPaymentFlag = bdl.getString("DUMMY_PAYMENT_FLAG");
            defaultPayLimit = getIntColumn(bdl, "DEFAULT_PAYLIMIT");
            defaulCancelLimit = getIntColumn(bdl, "DEFAULT_CANCELLIMIT");
            cardCaptureFlag = bdl.getString("CARD_CAPTURE_FLAG");
            cvsPayLimit = getIntColumn(bdl, "CVS_PAYLIMIT");
            dummyCommodityId = bdl.getString("DUMMY_COMMODITY_ID");
            dummyCommodityJanCode = bdl.getString("DUMMY_COMMODITY_JANCODE");
        } catch (MissingResourceException e) {
            log.fatal("AIRWEBMDK.propetiesが読み込めません", e);
            return;
        }
    }

    /**
     * インスタンスを取得
     *
     * @return MerchantConfクラス
     */
    public static MerchantConf getInfo() {
        if (info == null) {
            info = new MerchantConf();
        }
        return info;
    }

    /**
     * 対象項目を数値化する。
     *
     * @param bdl Resource Bundleインスタンス
     * @param palName 対象項目のパラメータ名
     * @return 数値化した項目
     */
    private int getIntColumn(final ResourceBundle bdl, final String palName) {
        int retVal = 0;
        String payLimitStr = bdl.getString(palName);
        try {
            retVal = Integer.parseInt(payLimitStr);
        } catch (Exception nfe) {
            log.warn("数字ではありません。" + palName + " = " + payLimitStr, nfe);
        }
        return retVal;
    }

    /**
     * merchantIDの取得
     *
     * @return the merchantID of String
     */
    public String getMerchantID() {
        return merchantID;
    }

    /**
     * merchantIDの設定
     *
     * @param merchantID the merchantID to set
     */
    public void setMerchantID(final String merchantID) {
        this.merchantID = merchantID;
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
     * seedの取得
     *
     * @return the seed of String
     */
    public String getSeed() {
        return seed;
    }

    /**
     * seedの設定
     *
     * @param seed the seed to set
     */
    public void setSeed(final String seed) {
        this.seed = seed;
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
     * airWebRegistUrlの取得
     *
     * @return the airWebRegistUrl of String
     */
    public String getAirWebRegistUrl() {
        return airWebRegistUrl;
    }

    /**
     * airWebRegistUrlの設定
     *
     * @param airWebRegistUrl the airWebRegistUrl to set
     */
    public void setAirWebRegistUrl(final String airWebRegistUrl) {
        this.airWebRegistUrl = airWebRegistUrl;
    }

    /**
     * airWebSettlementUrlの取得
     *
     * @return the airWebSettlementUrl of String
     */
    public String getAirWebSettlementUrl() {
        return airWebSettlementUrl;
    }

    /**
     * airWebSettlementUrlの設定
     *
     * @param airWebSettlementUrl the airWebSettlementUrl to
     *            set
     */
    public void setAirWebSettlementUrl(final String airWebSettlementUrl) {
        this.airWebSettlementUrl = airWebSettlementUrl;
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
     * defaultPayLimitの取得
     *
     * @return the defaultPayLimit of int
     */
    public int getDefaultPayLimit() {
        return defaultPayLimit;
    }

    /**
     * defaultPayLimitの設定
     *
     * @param defaultPayLimit the defaultPayLimit to set
     */
    public void setDefaultPayLimit(final int defaultPayLimit) {
        this.defaultPayLimit = defaultPayLimit;
    }

    /**
     * defaulCancelLimitの取得
     *
     * @return the defaulCancelLimit of int
     */
    public int getDefaulCancelLimit() {
        return defaulCancelLimit;
    }

    /**
     * defaulCancelLimitの設定
     *
     * @param defaulCancelLimit the defaulCancelLimit to set
     */
    public void setDefaulCancelLimit(final int defaulCancelLimit) {
        this.defaulCancelLimit = defaulCancelLimit;
    }

    /**
     * cvsPayLimitの取得
     *
     * @return the cvsPayLimit of int
     */
    public int getCvsPayLimit() {
        return cvsPayLimit;
    }

    /**
     * cvsPayLimitの設定
     *
     * @param cvsPayLimit the cvsPayLimit to set
     */
    public void setCvsPayLimit(final int cvsPayLimit) {
        this.cvsPayLimit = cvsPayLimit;
    }

    /**
     * dummyCommodityIdの取得
     *
     * @return the dummyCommodityId of String
     */
    public String getDummyCommodityId() {
        return dummyCommodityId;
    }

    /**
     * dummyCommodityIdの設定
     *
     * @param dummyCommodityId the dummyCommodityId to set
     */
    public void setDummyCommodityId(final String dummyCommodityId) {
        this.dummyCommodityId = dummyCommodityId;
    }

    /**
     * dummyCommodityJanCodeの取得
     *
     * @return the dummyCommodityJanCode of String
     */
    public String getDummyCommodityJanCode() {
        return dummyCommodityJanCode;
    }

    /**
     * dummyCommodityJanCodeの設定
     *
     * @param dummyCommodityJanCode the
     *            dummyCommodityJanCode to set
     */
    public void setDummyCommodityJanCode(final String dummyCommodityJanCode) {
        this.dummyCommodityJanCode = dummyCommodityJanCode;
    }
}
