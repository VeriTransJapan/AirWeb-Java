package jp.co.veritrans.airweb.sample.server;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.veritrans.airweb.mdk.bean.ResultDataBean;
import jp.co.veritrans.airweb.mdk.bean.ResultsList;
import jp.co.veritrans.airweb.mdk.common.Constants;
import jp.co.veritrans.airweb.mdk.common.ResultCheck;
import jp.co.veritrans.airweb.mdk.common.StringUtil;

import org.apache.log4j.Logger;

/**
 * AirWebからの決済結果を受け取るServlet
 */
public class ResultNoticeReceiver extends HttpServlet {

    /**
     * serial version UID.
     */
    private static final long serialVersionUID = 8664728883149660895L;

    /**
     * Content-Type
     */
    private static String CONTENT_TYPE = "text/html; charset=" + Constants.AW_ENCODE;

    /**
     * 個人情報項目
     */
    private static String[] PRIVATEINFO = { Constants.AWRES_USER_NAME, Constants.AWRES_USER_NAME_KANA,
            Constants.AWRES_MAIL_ADDRESS, Constants.AWRES_ADDRESS, Constants.AWRES_SEX, Constants.AWRES_TELEPHONE_NO,
            Constants.AWRES_ZIP_CODE, Constants.AWRES_BIRTHDAY };

    /**
     * ログ出力用インスタンス
     */
    private final Logger log = Logger.getLogger(ResultNoticeReceiver.class);

    /**
     * POSTされたリクエストを受け取る
     *
     * @param request リクエスト
     * @param response レスポンス
     * @throws IOException 入出力例外
     * @throws ServletException サーブレットの例外
     */
    @Override
    public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws IOException,
            ServletException {

        log.info("決済結果確認開始");
        request.setCharacterEncoding(Constants.AW_ENCODE);

        // リクエストの一覧をログ出力
        if (log.isInfoEnabled()) {
            Enumeration enu = request.getParameterNames();
            while (enu.hasMoreElements()) {
                String param = (String)enu.nextElement();
                String value = URLDecoder.decode(request.getParameter(param), Constants.AW_ENCODE);
                log.info(param + ":" + value);
            }
        }

        ResultsList resultsList = ResultsList.getInstance();
        String orderId = URLDecoder.decode(request.getParameter(Constants.AWRES_ORDER_ID), Constants.AW_ENCODE);
        Map<String, String> result = resultsList.getResult(orderId);

        if (result == null) {
            log.warn("該当する取引IDがない");
            response.setContentType(CONTENT_TYPE);
            ServletOutputStream out = response.getOutputStream();

            out.println("ERR");
            return;
        } else if (result.containsKey(Constants.AWRES_M_STATUS)) {
            StringBuffer sb = new StringBuffer();
            Iterator<String> ite = result.keySet().iterator();
            String entry = null;
            while (ite.hasNext()) {
                entry = ite.next();
                sb.append(entry);
                sb.append("=");
                sb.append(result.get(entry));
            }
            log.warn("該当取引ID	は受信済み。" + sb.toString());
            response.setContentType(CONTENT_TYPE);
            ServletOutputStream out = response.getOutputStream();

            out.println("ERR");
            return;
        }

        ResultDataBean databean = new ResultDataBean();

        // リクエストをマップに格納
        databean.setOrderId(orderId);
        databean.setmStatus(URLDecoder.decode(request.getParameter(Constants.AWRES_M_STATUS), Constants.AW_ENCODE));
        databean.setmErrMsg(URLDecoder.decode(request.getParameter(Constants.AWRES_M_ERR_MSG), Constants.AW_ENCODE));
        databean.setvResultCode(URLDecoder.decode(request.getParameter(Constants.AWRES_V_RESULT_CODE),
                Constants.AW_ENCODE));

        ResultCheck rcheck = new ResultCheck();
        boolean checkflag;

        // 内容を確認
        checkflag = rcheck.resultCheck(databean);

        // AWへ返信
        if (checkflag) {
            log.info("内容確認成功");
            result.put(Constants.AWRES_M_STATUS, databean.getmStatus());
            result.put(Constants.AWRES_M_ERR_MSG, databean.getmErrMsg());
            result.put(Constants.AWRES_V_RESULT_CODE, databean.getvResultCode());

            // 個人情報取得
            String value = null;
            for (int i = 0; i < PRIVATEINFO.length; i++) {
                value = request.getParameter(PRIVATEINFO[i]);
                if (!StringUtil.isNullStr(value)) {
                    result.put(PRIVATEINFO[i], value);
                }
            }

            resultsList.setResult(orderId, result);
            response.setContentType(CONTENT_TYPE);
            ServletOutputStream out = response.getOutputStream();

            out.println("OK");
        } else {
            log.info("内容確認失敗");
            response.setContentType(CONTENT_TYPE);
            ServletOutputStream out = response.getOutputStream();

            out.println("ERR");
        }
    }

    /**
     * GETされたリクエストを受け取る
     *
     * @param request リクエスト
     * @param response レスポンス
     * @throws IOException 入出力例外
     * @throws ServletException サーブレットの例外
     */
    @Override
    public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException,
            ServletException {
        doPost(request, response);
    }

}
