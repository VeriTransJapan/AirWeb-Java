package jp.co.veritrans.airweb.sample.server.action.cvs;

import javax.servlet.http.HttpServletRequest;

import jp.co.veritrans.airweb.mdk.common.Constants;
import jp.co.veritrans.airweb.sample.server.action.PaymentForm;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

/**
 * コンビニ決済のActionFormクラス
 */
public class CvsForm extends PaymentForm {

    /**
     * serial version UID.
     */
    private static final long serialVersionUID = -2880416838093898748L;

    /**
     * ログ出力用インスタンス
     */
    private static Logger log = Logger.getLogger(CvsForm.class);

    /**
     * コンストラクタ
     */
    public CvsForm() {
        super();
        setSettlementType(Constants.SETTLEMENT_TYPE_CVS);
    }

    /**
     * エラーチェック。厳密なチェックはAirWebで行うため、ここでは形式的なチェックのみでも問題ありませんが、
     * レスポンスタイム等を考慮し、必要に応じてチェック内容をご検討下さい。
     *
     * @param mapping このインスタンスを選択するために使用するマッピング
     * @param request 処理中のHTTPリクエスト
     * @return エラーメッセージ
     */
    @Override
    public ActionErrors validate(final ActionMapping mapping, final HttpServletRequest request) {
        log.info("コンビニ決済の決済情報をチェックします");

        ActionErrors errors = new ActionErrors();
        super.validate(mapping, request, errors);
        return errors;
    }
}
