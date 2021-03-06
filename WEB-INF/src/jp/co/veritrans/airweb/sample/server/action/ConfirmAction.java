package jp.co.veritrans.airweb.sample.server.action;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

import jp.co.veritrans.airweb.mdk.bean.CommodityDetail;
import jp.co.veritrans.airweb.mdk.bean.EncryptionKey;
import jp.co.veritrans.airweb.mdk.common.Constants;
import jp.co.veritrans.airweb.mdk.common.MDKUtils;
import jp.co.veritrans.airweb.mdk.common.StringUtil;
import jp.co.veritrans.airweb.mdk.conf.MerchantConf;

import org.apache.log4j.Logger;

/**
 * 暗号鍵取得を行うActionクラス
 */
public class ConfirmAction extends BasicAction {

    /**
     * ログ出力用インスタンス
     */
    private static Logger log = Logger.getLogger(ConfirmAction.class);

    /**
     * POSTで送信
     *
     * @param form 情報を取得するアクションフォームクラス
     * @param commodityDetail 商品情報の配列
     * @return ブラウザ側の暗号鍵
     * @throws NoSuchAlgorithmException
     */
    @Override
    protected EncryptionKey send(final String sessionId, final String orderId, final PaymentForm form,
            final CommodityDetail[] commodityDetail) throws NoSuchAlgorithmException {
        log.info("POST送信開始");
        try {
            // AIRWEBはクライアント証明書を配布しない
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(final String host, final SSLSession ses) {
                    return true;
                }
            });

            // URLクラスのインスタンスを生成
            MerchantConf info = MerchantConf.getInfo();
            URL accessURL = new URL(info.getAirWebRegistUrl());

            SSLContext sc = SSLContext.getInstance("TLSv1.2");
            sc.init(null, null, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // 接続します
            URLConnection con = accessURL.openConnection();
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=" + Constants.AW_ENCODE);
            con.setRequestProperty("Accept-Language", "ja");
            con.setRequestProperty("Connection", "close");
            con.setDoOutput(true);

            // 出力ストリームを取得
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream(), Constants.AW_ENCODE));
            Map<String, Object> map = createParameterMap(sessionId, orderId, form, commodityDetail);
            String postData = getPostData(map);
            log.info("送信データ:" + postData);

            bw.write(postData);
            bw.flush();
            bw.close();

            // 入力ストリームを取得
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), Constants.AW_ENCODE));

            // 一行ずつ読み込みます
            EncryptionKey ret = new EncryptionKey();
            String line;
            try {
                while ((line = in.readLine()) != null) {
                    // 表示します
                    log.info("返信内容：" + line);
                    if (line.startsWith("MERCHANT_ENCRYPTION_KEY")) {
                        String tmp = line.substring(24);
                        registKey(orderId, tmp, sessionId);
                        ret.setMerchantEncryptionKey(tmp);
                    } else if (line.startsWith("BROWSER_ENCRYPTION_KEY")) {
                        String tmp = line.substring(23);
                        ret.setBrowserEncryptionKey(tmp);
                    } else if (line.startsWith("ERROR_MESSAGE")) {
                        String tmp = URLDecoder.decode(line.substring(14), Constants.AW_ENCODE);
                        ret.setErrorMessage(tmp);
                    }
                }
            } catch (Throwable th) {
                log.error("受信結果解析エラーです", th);
                return null;
            }
            // 入力ストリームを閉じます
            in.close();

            log.info("POST通信完了");

            return ret;

        } catch (MalformedURLException e) {
            log.error("接続エラーです。", e);
            return null;
        } catch (IOException e) {
            log.error("接続エラーです。", e);
            return null;
        } catch (NoSuchAlgorithmException e) {
            log.error("接続エラーです。", e);
            return null;
        } catch (KeyManagementException e) {
            log.error("接続エラーです。", e);
            return null;
        }
    }

    /**
     * POST用の商品情報を取得する
     *
     * @param commodity 商品情報の配列
     * @return POST用の商品情報
     */
    private String[][] getCommodityDetail(final CommodityDetail[] commodity) {
        String[][] info = new String[6][commodity.length];
        for (int i = 0; i < commodity.length; i++) {
            info[0][i] = commodity[i].getCommodityId();
            info[2][i] = commodity[i].getJanCode();
            info[3][i] = commodity[i].getCommodityName();
            info[4][i] = commodity[i].getCommodityUnit().toString();
            info[5][i] = commodity[i].getCommodityNum().toString();
        }
        return info;
    }

    /**
     * POST用に整形したデータを返却する。
     *
     * @param map 情報が登録されたマップ
     * @return POST用データ
     * @throws UnsupportedEncodingException
     */
    private String getPostData(final Map<String, Object> map) throws UnsupportedEncodingException {

        StringBuffer buff = new StringBuffer();

        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String keyName = it.next();
            Object obj = map.get(keyName);
            if (obj != null) {
                String appendStr = null;
                if (obj instanceof Calendar) {
                    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
                    appendStr = dateFormat.format(((Calendar)obj).getTime());
                    buff.append(keyName + "=" + URLEncoder.encode(appendStr, Constants.AW_ENCODE));
                } else if (obj instanceof String[]) {
                    String[] strs = (String[])obj;
                    for (int i = 0; i < strs.length; i++) {
                        buff.append(keyName + "=" + URLEncoder.encode(strs[i], Constants.AW_ENCODE));
                        if (i < strs.length - 1) {
                            buff.append("&");
                        }
                    }
                } else {
                    appendStr = obj.toString();
                    buff.append(keyName + "=" + URLEncoder.encode(appendStr, Constants.AW_ENCODE));
                }
            }
            if (it.hasNext()) {
                buff.append("&");
            }
        }

        log.info("送信内容：" + buff.toString());
        return buff.toString();
    }

    /**
     * パラメータを決定しマップへ登録
     *
     * @param form 情報を取得するアクションフォームクラス
     * @param commodityDetail 商品情報の配列
     * @return 情報が登録されたマップ
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    private Map<String, Object> createParameterMap(final String sessionId, final String orderId,
            final PaymentForm form, final CommodityDetail[] commodityDetail) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {
        Map<String, Object> settlementInfo = new LinkedHashMap<String, Object>();
        MerchantConf merchantInfo = MerchantConf.getInfo();
        // マーチャントID
        settlementInfo.put("MERCHANT_ID", merchantInfo.getMerchantId());
        String type = null;
        if (StringUtil.isNullStr(form.getSettlementType())) {
            type = Constants.SETTLEMENT_TYPE_DEFAULT;
            form.setSettlementType(type);
        } else {
            type = form.getSettlementType();
        }

        int amount = Integer.parseInt(form.getAmount());
        int shippingAmount = 0;
        int totalAmount = 0;
        if (form.getShippingAmount() != null) {
            shippingAmount = Integer.parseInt(form.getShippingAmount());
        }
        totalAmount = amount + shippingAmount;

        // マーチャント生成ハッシュ値
        String hashCode = MDKUtils.getHash(merchantInfo.getMerchantId(), type, orderId, String.valueOf(totalAmount));
        settlementInfo.put("MERCHANTHASH", hashCode);
        // SessionID
        settlementInfo.put("SESSION_ID", sessionId);
        // 決済方法
        settlementInfo.put("SETTLEMENT_TYPE", type);
        // 取引ID
        settlementInfo.put("ORDER_ID", orderId);
        // 購入金額
        settlementInfo.put("AMOUNT", totalAmount);
        // 送料合計
        settlementInfo.put("SHIPPING_AMOUNT", shippingAmount);
        // 支払期限
        settlementInfo.put("TIMELIMIT_OF_PAYMENT", form.getTimelimitOfPayment());
        // 決済完了後戻りURL
        settlementInfo.put("FINISH_PAYMENT_RETURN_URL", merchantInfo.getFinishPaymentReturnUrl());
        // 未決済時戻りURL
        settlementInfo.put("UNFINISH_PAYMENT_RETURN_URL", merchantInfo.getUnfinishPaymentReturnUrl());
        // 決済エラー時戻りURL
        settlementInfo.put("ERROR_PAYMENT_RETURN_URL", merchantInfo.getErrorPaymentReturnUrl());
        // 決済結果通知先URL
        settlementInfo.put("FINISH_PAYMENT_ACCESS_URL", merchantInfo.getFinishPaymentAccessUrl());
        // ダミー決済フラグ
        settlementInfo.put("DUMMY_PAYMENT_FLAG", merchantInfo.getDummyPaymentFlag());
        // カード売上フラグ
        settlementInfo.put("CARD_CAPTURE_FLAG", form.getCardCaptureFlag());
        // 名前１
        settlementInfo.put("NAME1", form.getName1());
        // 名前２
        settlementInfo.put("NAME2", form.getName2());
        // カナ１
        settlementInfo.put("KANA1", form.getKana1());
        // カナ２
        settlementInfo.put("KANA2", form.getKana2());
        // 住所１
        settlementInfo.put("ADDRESS1", form.getAddress1());
        // 住所２
        settlementInfo.put("ADDRESS2", form.getAddress2());
        // 住所３
        settlementInfo.put("ADDRESS3", form.getAddress3());
        // 電話番号
        settlementInfo.put("TELEPHONE_NO", form.getTelephoneNo());
        // メールアドレス
        settlementInfo.put("MAILADDRESS", form.getMailAddress());
        // 郵便番号
        settlementInfo.put("ZIP_CODE", form.getZipCode());
        // 生年月日
        settlementInfo.put("BIRTHDAY", form.getBirthday());
        // 性別
        settlementInfo.put("SEX", form.getSex());

        // 商品情報
        if (commodityDetail != null) {
            String[][] info = getCommodityDetail(commodityDetail);
            // 商品ID
            settlementInfo.put("COMMODITY_ID", info[0]);
            // 単価
            settlementInfo.put("COMMODITY_UNIT", info[4]);
            // 個数
            settlementInfo.put("COMMODITY_NUM", info[5]);
            // 商品名
            settlementInfo.put("COMMODITY_NAME", info[3]);
            // JANコード
            settlementInfo.put("JAN_CODE", info[2]);
        }

        return settlementInfo;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * jp.co.veritrans.sample.server.action.MerchantSampleAction#addInfomation
     * (jp.co.veritrans.sample.server.action.SampleAction)
     */
    @Override
    protected void addInfomation(final PaymentForm form) {
        String type = form.getSettlementType();
        if (StringUtil.isNullStr(type) || "00".equals(type)) {
            MerchantConf info = MerchantConf.getInfo();
            // 売り上げフラグ
            if ("1".equals(info.getCardCaptureFlag())) {
                form.setCardCaptureFlag("1");
            } else {
                form.setCardCaptureFlag("0");
            }

        }
    }
}
