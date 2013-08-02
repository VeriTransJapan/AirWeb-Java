package jp.co.veritrans.airweb.mdk.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * 日付系Utility
 */
public class DateUtil {

    /**
     * ログ出力用インスタンス
     */
    private static Logger log = Logger.getLogger(DateUtil.class);

    /**
     * 現在日付に指定した日数を足す。
     * 
     * @param paylimit 日数
     * @return 日数が加算された日付文字列(yyyyMMdd)
     */
    public static String getDateYYYYMMDD(int paylimit) {
        Calendar limit = Calendar.getInstance();
        if (paylimit > 0) {
            limit.add(Calendar.DAY_OF_YEAR, paylimit);
        }
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.format(limit.getTime());
    }

    /**
     * 現在日付に指定した日数を足す。
     * 
     * @param paylimit 日数
     * @return 日数が加算された日付文字列(yyyyMMddHHmmss)
     */
    public static String getDateYYYYMMDDhhmmss(int paylimit) {
        Calendar limit = Calendar.getInstance();
        if (paylimit > 0) {
            limit.add(Calendar.DAY_OF_YEAR, paylimit);
        }
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(limit.getTime());
    }

    /**
     * 指定した日付型の日付を文字列型に変換する。
     * 
     * @param date 日付（日付型）
     * @return 日付（文字列型）
     */
    public static String getDateYYYYMMDD(Date date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_PATTERN_YYYYMMDD);
            String retStr = sdf.format(date);
            return retStr;
        } catch (Throwable th) {
            log.warn("日付変換でエラーが発生しました。", th);
        }
        return "";
    }
}
