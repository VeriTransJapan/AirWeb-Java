<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="java.text.NumberFormat"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="ja">
<head>
<%@ include file="include_head.jsp"%>
<title>Entry</title>
</heads>
<body>
    <%@ include file="../common/include_retrieve_info.jsp"%>
    <div class="contents">
        <h1>【ECサイト 入力画面】</h1>
        <br />
        <html:errors />
        <br />
        <html:form action="/cvsConfirmaction" onsubmit="document.getElementById('submitBtn').disabled=true;">
            <%@ include file="../common/include_cart_table.jsp"%>
            <br />
            <br />
            <h2>【お支払い情報】</h2>
            <br />
            <table class="settlement">
                <tr>
                    <th class="type">項目</th>
                    <th class="pal">内容</th>
                <tr>
                <tr>
                    <td class="type">決済方法</td>
                    <td class="pal">コンビニ決済</td>
                <tr>
                <tr>
                    <td class="type">決済方法サブタイプ</td>
                    <td class="pal">
                        <html:select property="settlementSubType" size="1">
                            <html:option value="">後で指定</html:option>
                            <html:option value="220">ローソン</html:option>
                            <html:option value="220">ファミリーマート</html:option>
                            <html:option value="210">セブンイレブン</html:option>
                            <html:option value="230">デイリーヤマザキ</html:option>
                            <html:option value="220">ミニストップ</html:option>
                            <html:option value="220">セイコーマート</html:option>
                            <html:option value="230">サークルK、サンクス</html:option>
                        </html:select>
                    </td>
                </tr>
            </table>
            <br />
            <br />
            <%@ include file="../common/include_customer_table.jsp"%>
            <br />
            <%@ include file="../common/include_input_hidden.jsp"%>
            <br />
            <input id="submitBtn" type="submit" value="　購入　" />
        </html:form>
    </div>
</BODY>
</HTML>
