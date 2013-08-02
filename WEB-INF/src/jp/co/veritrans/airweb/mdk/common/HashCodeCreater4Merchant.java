package jp.co.veritrans.airweb.mdk.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import jp.co.veritrans.airweb.mdk.conf.MerchantConf;

import org.apache.log4j.Logger;

/**
 * ハッシュコード作成クラス
 */
public class HashCodeCreater4Merchant {

    /**
     * 16進数の基数をあらわす
     */
    static final int HEX = 16;

    /**
     * ログ出力用インスタンス
     */
    private static Logger log = Logger.getLogger(HashCodeCreater4Merchant.class);

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
    public String getHash(String merchantID, String settlementmethod, String orderID, String amount)
            throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("SHA-512");

        StringBuffer sb = new StringBuffer();

        if (MerchantConf.getInfo().getSeed() == null || MerchantConf.getInfo().getSeed().equals("")) {
            log.info("シードが指定されていないのでハッシュ値は作成しません");
            return null;
        }

        sb.append(MerchantConf.getInfo().getSeed());
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
    public String changeHash(byte[] digest) {

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
