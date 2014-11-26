package jp.co.veritrans.airweb.mdk.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jp.co.veritrans.airweb.mdk.conf.MerchantConf;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * Utilityクラス
 */
public class MDKUtils {

    /**
     * 16進数の基数をあらわす
     */
    static final int HEX = 16;

    /**
     * ログ出力用インスタンス
     */
    private static Logger log = Logger.getLogger(MDKUtils.class);

    /**
     * ダミーの取引IDを作成する
     *
     * @return 取引ID
     */
    public static String createDummyOrderId() {
        // 取引IDを作成(現在時刻をミリ秒まで)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String orderId = "AirWeb_Dummy_" + sdf.format(new Date()) + RandomStringUtils.randomAlphanumeric(10);
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

    /**
     * 文字列からハッシュ値を生成する
     *
     * @param merchantID マーチャントID
     * @param settlementmethod 決済方法
     * @param orderID オーダーID
     * @param amount 合計金額
     * @return ハッシュ値
     * @throws NoSuchAlgorithmException 使用可能でないアルゴリズムが指定された
     */
    public static String getHash(final String merchantID, final String settlementmethod, final String orderID,
            final String amount) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("SHA-512");

        StringBuffer sb = new StringBuffer();

        if (StringUtils.isEmpty(MerchantConf.getInfo().getMerchantHash())) {
            log.info("パスワードが指定されていないのでハッシュ値は作成しません");
            return null;
        }

        sb.append(MerchantConf.getInfo().getMerchantHash());
        sb.append("," + merchantID);
        sb.append("," + settlementmethod);
        sb.append("," + orderID);
        sb.append("," + amount);
        byte[] data = sb.toString().getBytes();

        md.update(data);
        return changeHash(md.digest());
    }

    /**
     * バイト型を16進数文字列に変換
     *
     * @param digest バイト配列のハッシュ値
     * @return 文字列変換されたハッシュ値
     */
    public static String changeHash(final byte[] digest) {

        StringBuffer strb = new StringBuffer();

        for (int i = 0; i < digest.length; i++) {
            int d = digest[i];

            // byte型では128から255が負値になっているので補正
            if (d < 0) {
                d &= Integer.parseInt("FF", HEX);
            }

            //16進数で1桁の場合0で埋める
            if (d < HEX) {
                strb.append("0");
            }
            strb.append(Integer.toString(d, HEX));
        }
        return strb.toString();
    }
}
