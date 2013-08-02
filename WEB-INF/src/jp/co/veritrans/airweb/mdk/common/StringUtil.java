package jp.co.veritrans.airweb.mdk.common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.log4j.Logger;

/**
 * 文字列系Utility
 */
public class StringUtil {

    /**
     * ログ出力用インスタンス
     */
    private static Logger log = Logger.getLogger(StringUtil.class);

    /**
     * デフォルト改行コード
     */
    private static final String CRLF = "\r\n";

    /**
     * 半角数字チェック
     * 
     * @param str 検証文字列
     * @return 半角数字であればtrue
     */
    public static boolean isSingleByteNumeric(String str) {
        if (!isNullStr(str)) {
            return str.matches("^[0-9]+$");
        }
        return false;
    }

    /**
     * 検証文字列がNULL又は空文字列であるか否かを判定する。
     * 
     * @param str 検証文字列
     * @return NULL又は空文字列であればtrue
     */
    public static boolean isNullStr(String str) {
        if (str == null || str.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 半角英数字チェック
     * 
     * @param str 検証文字列
     * @return 半角英数字であればtrue
     */
    public static boolean isAlNum(String str) {
        if (str.matches("[^a-zA-Z0-9]")) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 半角数字チェック
     * 
     * @param str 検証文字列
     * @return 半角数字であればtrue
     */
    public static boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    /**
     * 半角英数字記号チェック
     * 
     * @param str 検証文字列
     * @return 半角英数字記号であればtrue
     */
    public static boolean isAlnumSymbol(String str) {
        if (str.matches("^[\\p{Print}]+$")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 全角カナチェック
     * 
     * @param str 検証文字列
     * @return 全角カナであればtrue
     */
    public static boolean isMultiByteKana(String str) {
        if (str.matches("^[ァ-ヶー－　]+$")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 処理対象文字列がNULLであれば空文字列を返却する。
     * 
     * @param str 処理対象文字列
     * @return NULLであれば空文字列に変換した文字列
     */
    public static String emptyString(String str) {
        if (str == null) {
            return "";
        } else {
            return str;
        }
    }

    /**
     * 文字列が全角であるか否かを判定する。
     * 
     * @param str 判定対称文字列
     * @return 全角文字だけで構成されていればtrue
     */
    public static boolean isMultiByte(String str) {
        if (!isNullStr(str)) {
            return str.matches("^[^ -~｡-ﾟ]+$");
        }
        return false;
    }

    /**
     * 文字列が半角であるか否かを判定する。
     * 
     * @param str 判定対称文字列
     * @return 半角文字だけで構成されていればtrue
     */
    public static boolean isSingleByte(String str) {
        if (!isNullStr(str)) {
            return str.matches("^[ -~｡-ﾟ]+$");
        }
        return false;
    }

    /**
     * 環境変数の改行コードを返却する
     * 
     * @param cardNumber カード番号
     * @return 半角数字、半角ハイフン以外の文字を削除した文字列
     */
    public static String getCRLF() {
        String retStr = null;
        try {
            String lineSep = System.getProperty("line.separator");
            if (lineSep == null || lineSep.length() == 0) {
                retStr = CRLF;
            } else {
                retStr = lineSep;
            }
        } catch (Throwable th) {
            log.error("環境変数line.separatorの取得に失敗しました。", th);
            retStr = CRLF;
        }
        return retStr;
    }

    /**
     * カード番号で入力されない文字列を削除して返却する
     * 
     * @param cardNumber カード番号
     * @return 半角数字、半角ハイフン以外の文字を削除した文字列
     */
    public static String removeForbidChar4CardNumber(String cardNumber) {
        String retStr = "";
        if (!isNullStr(cardNumber)) {
            retStr = cardNumber.replaceAll("[^0-9\\-]", "");
        }
        return retStr;
    }

    /**
     * 半角数字以外を削除して返却する
     * 
     * @param str 処理対象文字列
     * @return 半角数字以外の文字を削除した文字列
     */
    public static String removeNonNumber(String str) {
        String retStr = "";
        if (!isNullStr(str)) {
            retStr = str.replaceAll("[^0-9]", "");
        }
        return retStr;
    }

    /**
     * 指定された文字列をUTF-8でURLエンコードを行った文字列を返却する
     * 
     * @param str 処理対象文字列
     * @return UTF-8でURLエンコードを行った文字列
     */
    public static String urlEncode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.fatal("文字コード判定エラーです", e);
        }
        return str;
    }
}
