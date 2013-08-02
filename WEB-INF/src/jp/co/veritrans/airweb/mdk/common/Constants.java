package jp.co.veritrans.airweb.mdk.common;

/**
 * デフォルト値を保持するクラス
 */
public class Constants {

    /**
     * AirWebの文字コード
     */
    public static final String AW_ENCODE = "UTF-8";

    /**
     * 日付変換パターン。誕生日の形式変換時に使用
     */
    public static final String DATE_PATTERN_YYYYMMDD = "yyyyMMdd";

    /**
     * 決済種別：カード
     */
    public static final String SETTLEMENT_TYPE_CARD = "01";

    /**
     * 決済種別：コンビニ
     */
    public static final String SETTLEMENT_TYPE_CVS = "02";

    /**
     * デフォルト支払期限
     */
    public static final int DEFAULT_PAY_LIMIT_DAYS = 60;

    /**
     * デフォルト支払取消期限
     */
    public static final int DEFAULT_CANCEL_LIMIT_DAYS = 60;

    /*******************************************************/
    /*                                                     */
    /* CVS CONSTANTS */
    /*                                                     */
    /*******************************************************/
    /**
     * コンビニ決済オプション：ローソン
     */
    public static final String CVS_SUBTYPE_LAWSON = "220";
    /**
     * コンビニ決済オプション：ファミリーマート
     */
    public static final String CVS_SUBTYPE_FAMIMA = "220";
    /**
     * コンビニ決済オプション：セブンイレブン
     */
    public static final String CVS_SUBTYPE_711 = "210";
    /**
     * コンビニ決済オプション：デイリーヤマザキ
     */
    public static final String CVS_SUBTYPE_DAILY = "230";
    /**
     * コンビニ決済オプション：ミニストップ
     */
    public static final String CVS_SUBTYPE_MINISTOP = "220";
    /**
     * コンビニ決済オプション：セイコーマート
     */
    public static final String CVS_SUBTYPE_SEICO = "220";
    /**
     * コンビニ決済オプション：サークルK、サンクス
     */
    public static final String CVS_SUBTYPE_SUNKUS = "230";

    /**
     * コンビニ支払期限デフォルト
     */
    public static final int CVS_PAYLIMIT_DAYS = 60;

    /*******************************************************/
    /*                                                     */
    /* AirWeb Results */
    /*                                                     */
    /*******************************************************/

    /**
     * 取引IDの取得キー
     */
    public static final String AWRES_ORDER_ID = "orderId";

    /**
     * ステータスの取得キー
     */
    public static final String AWRES_M_STATUS = "mStatus";

    /**
     * エラーメッセージの取得キー
     */
    public static final String AWRES_M_ERR_MSG = "mErrMsg";

    /**
     * 結果コードの取得キー
     */
    public static final String AWRES_V_RESULT_CODE = "vResultCode";

    /**
     * 漢字氏名の取得キー
     */
    public static final String AWRES_USER_NAME = "userName";

    /**
     * カナ氏名の取得キー
     */
    public static final String AWRES_USER_NAME_KANA = "userNameKana";

    /**
     * メールアドレスの取得キー
     */
    public static final String AWRES_MAIL_ADDRESS = "mailAddress";

    /**
     * 住所の取得キー
     */
    public static final String AWRES_ADDRESS = "address";

    /**
     * 性別の取得キー
     */
    public static final String AWRES_SEX = "sex";

    /**
     * 電話番号の取得キー
     */
    public static final String AWRES_TELEPHONE_NO = "telephoneno";

    /**
     * 郵便番号の取得キー
     */
    public static final String AWRES_ZIP_CODE = "zipcode";

    /**
     * 誕生日の取得キー
     */
    public static final String AWRES_BIRTHDAY = "birthday";

    /**
     * sessionIdの取得キー
     */
    public static final String AWRES_SESSION_ID = "sessionId";

    /**
     * マーチャント暗号鍵の取得キー
     */
    public static final String AWRES_SETTLEMENTKEY1B = "SETTLEMENTKEY1B";
}
