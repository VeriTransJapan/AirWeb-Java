package jp.co.veritrans.airweb.mdk.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;

/**
 * Utilityクラス
 */
public class MDKUtils {

    /**
     * ダミーの取引IDを作成する
     *
     * @return 取引ID
     */
    public static String createDummyOrderId() {
        // 取引IDを作成(現在時刻をミリ秒まで)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String orderId = sdf.format(new Date()) + RandomStringUtils.randomAlphanumeric(10);
        return orderId;
    }

    /**
     * 配列がNULL又は要素数ゼロであるか否かを判定する。
     *
     * @param arr
     * @return 配列がNULL又は要素数ゼロの場合は{@code true}を返す。
     */
    public static boolean isEmptyArray(final Object[] arr) {
        if (arr == null || arr.length == 0) {
            return true;
        } else {
            return false;
        }
    }
}
