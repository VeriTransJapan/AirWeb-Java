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
        <html:form action="/cvsConfirm" onsubmit="document.getElementById('submitBtn').disabled=true;">
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
