package jp.co.veritrans.airweb.sample.server.action.cvs;

import jp.co.veritrans.airweb.mdk.common.DateUtil;
import jp.co.veritrans.airweb.mdk.conf.MerchantConf;
import jp.co.veritrans.airweb.sample.server.action.PaymentForm;
import jp.co.veritrans.airweb.sample.server.action.ConfirmAction;

/**
 * コンビニ決済のActionクラス
 */
public class CvsAction extends ConfirmAction {
    @Override
    protected void addInfomation(final PaymentForm form) {
        MerchantConf info = MerchantConf.getInfo();
        // 支払期限
        int payLimit = info.getCvsPayLimit();
        form.setTimelimitOfPayment(DateUtil.getDateYYYYMMDD(payLimit));
    }
}
