package jp.co.veritrans.airweb.sample.server.action.cvs;

import jp.co.veritrans.airweb.mdk.common.Constants;
import jp.co.veritrans.airweb.mdk.common.DateUtil;
import jp.co.veritrans.airweb.mdk.conf.MerchantConf;
import jp.co.veritrans.airweb.sample.server.action.CommodityForm;
import jp.co.veritrans.airweb.sample.server.action.ConfirmAction;

/**
 * コンビニ決済のActionクラス
 */
public class CvsAction extends ConfirmAction {
    protected void addInfomation(CommodityForm form) {
        MerchantConf info = MerchantConf.getInfo();
        // コンビニ決済固有項目のセット
        // 支払期限
        int payLimit = info.getCvsPayLimit();
        if (payLimit <= 0) {
            payLimit = Constants.CVS_PAYLIMIT_DAYS;
        }
        form.setTimelimitOfPayment(DateUtil.getDateYYYYMMDD(payLimit));
    }
}
