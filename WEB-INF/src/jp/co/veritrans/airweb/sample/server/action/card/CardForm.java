package jp.co.veritrans.airweb.sample.server.action.card;

import javax.servlet.http.HttpServletRequest;

import jp.co.veritrans.airweb.mdk.common.Constants;
import jp.co.veritrans.airweb.sample.server.action.PaymentForm;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

/**
 * カード決済のActionFormクラス
 */
public class CardForm extends PaymentForm {

    /**
     * serial version UID.
     */
    private static final long serialVersionUID = 518653045810835220L;

    /**
     * ログ出力用インスタンス
     */
    private static Logger log = Logger.getLogger(CardForm.class);

    /**
     * コンストラクタ
     */
    public CardForm() {
        super();
        setSettlementType(Constants.SETTLEMENT_TYPE_CARD);
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
        log.info("カード決済の決済情報をチェックします");

        ActionErrors errors = new ActionErrors();
        super.validate(mapping, request, errors);
        return errors;
    }

}
