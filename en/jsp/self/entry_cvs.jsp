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
        <h1>[EC Site]</h1>
        <br />
        <html:errors />
        <br />
        <html:form action="/cvsConfirmaction" onsubmit="document.getElementById('submitBtn').disabled=true;">
            <%@ include file="../common/include_cart_table.jsp"%>
            <br />
            <br />
            <h2>Payment Information</h2>
            <br />
            <table class="settlement">
                <tr>
                    <th class="type">Items</th>
                    <th class="pal">Contents</th>
                <tr>
                <tr>
                    <td class="type">Payment Method</td>
                    <td class="pal">Convenience Stores</td>
                <tr>
                <tr>
                    <td class="type">Choose convenience store to pay</td>
                    <td class="pal">
                        <html:select property="settlementSubType" size="1">
                            <html:option value="">Not Specified</html:option>
                            <html:option value="220">Lawson</html:option>
                            <html:option value="220">Family Mart</html:option>
                            <html:option value="210">Seven Eleven</html:option>
                            <html:option value="230">Daily Yamazaki</html:option>
                            <html:option value="220">Ministop</html:option>
                            <html:option value="220">Seiko Mart</html:option>
                            <html:option value="230">Circle K Sunkus</html:option>
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
            <input id="submitBtn" type="submit" value=" Purchase " />
        </html:form>
    </div>
</BODY>
</HTML>
