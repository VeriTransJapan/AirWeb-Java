package jp.co.veritrans.airweb.sample.server.action.cvs;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import jp.co.veritrans.airweb.mdk.common.Constants;
import jp.co.veritrans.airweb.mdk.common.StringUtil;
import jp.co.veritrans.airweb.sample.server.action.CommodityForm;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

/**
 * コンビニ決済のActionFormクラス
 */
public class CvsForm extends CommodityForm {

    /**
     * serial version UID.
     */
    private static final long serialVersionUID = -2880416838093898748L;

    /**
     * ログ出力用インスタンス
     */
    private static Logger log = Logger.getLogger(CvsForm.class);

    /**
     * 有効な決済方法サブタイプを保持するArrayList
     */
    private static ArrayList subtype = new ArrayList();
    static {
        subtype.add(Constants.CVS_SUBTYPE_LAWSON);
        subtype.add(Constants.CVS_SUBTYPE_FAMIMA);
        subtype.add(Constants.CVS_SUBTYPE_711);
        subtype.add(Constants.CVS_SUBTYPE_DAILY);
        subtype.add(Constants.CVS_SUBTYPE_MINISTOP);
        subtype.add(Constants.CVS_SUBTYPE_SEICO);
        subtype.add(Constants.CVS_SUBTYPE_SUNKUS);
    }

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

        // 決済方法サブタイプ
        if (!StringUtil.isNullStr(getSettlementSubType()) && !subtype.contains(getSettlementSubType())) {
            addError(errors, "error.cvs.subtype.invalid");
        }

        super.validate(mapping, request, errors);
        return errors;
    }
}
