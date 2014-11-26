package jp.co.veritrans.airweb.mdk.conf;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 * air-config.propertiesの値を保持するクラス
 */
public final class MerchantConf {

    /** 自インスタンス */
    private static MerchantConf info = null;

    /** ログ出力用インスタンス */
    private static Logger log = Logger.getLogger(MerchantConf.class);

    /** マーチャントID */
    private String merchantId = "";

    /** パスワード */
    private String merchantHash = "";

    /** ダミー決済フラグ */
    private String dummyPaymentFlag = "";

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

    /** カード売上フラグ */
    private String cardCaptureFlag = "";

    /** コンビニ支払期限 */
    private int cvsPayLimit = 0;

    /**
     * コンストラクタ。外部からの生成を防止
     *
     */
    private MerchantConf() {
        ResourceBundle bdl = null;
        try {
            bdl = ResourceBundle.getBundle("air-config", Locale.getDefault());
            merchantId = bdl.getString("MERCHANT_ID");
            merchantHash = bdl.getString("MERCHANT_HASH");
            dummyPaymentFlag = bdl.getString("DUMMY_PAYMENT_FLAG");
            airWebRegistUrl = bdl.getString("AIRWEB_REGIST_URL");
            airWebSettlementUrl = bdl.getString("AIRWEB_SETTLEMENT_URL");
            finishPaymentReturnUrl = bdl.getString("FINISH_PAYMENT_RETURN_URL");
            unfinishPaymentReturnUrl = bdl.getString("UNFINISH_PAYMENT_RETURN_URL");
            errorPaymentReturnUrl = bdl.getString("ERROR_PAYMENT_RETURN_URL");
            finishPaymentAccessUrl = bdl.getString("FINISH_PAYMENT_ACCESS_URL");
            cardCaptureFlag = bdl.getString("CARD_CAPTURE_FLAG");
            cvsPayLimit = getIntColumn(bdl, "CVS_PAYLIMIT");
        } catch (MissingResourceException e) {
            log.fatal("air-config.propertiesが読み込めません", e);
            return;
        }
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
     * merchantHashの取得
     *
     * @return the merchantHash of String
     */
    public String getMerchantHash() {
        return merchantHash;
    }

    /**
     * merchantHashの設定
     *
     * @param merchantHash the merchantHash to set
     */
    public void setMerchantHash(final String merchantHash) {
        this.merchantHash = merchantHash;
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
     * @return the cvsPayLimit
     */
    public int getCvsPayLimit() {
        return cvsPayLimit;
    }

    /**
     * @param cvsPayLimit the cvsPayLimit to set
     */
    public void setCvsPayLimit(final int cvsPayLimit) {
        this.cvsPayLimit = cvsPayLimit;
    }

}
