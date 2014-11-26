package jp.co.veritrans.airweb.sample.server.action.card;

import jp.co.veritrans.airweb.mdk.conf.MerchantConf;
import jp.co.veritrans.airweb.sample.server.action.PaymentForm;
import jp.co.veritrans.airweb.sample.server.action.ConfirmAction;

/**
 * カード決済のActionクラス
 */
public class CardAction extends ConfirmAction {
    protected void addInfomation(PaymentForm form) {
        MerchantConf info = MerchantConf.getInfo();
        // カード決済固有項目のセット
        // 売り上げフラグ
        if ("1".equals(info.getCardCaptureFlag())) {
            form.setCardCaptureFlag("1");
        } else {
            form.setCardCaptureFlag("0");
        }
    }
}
