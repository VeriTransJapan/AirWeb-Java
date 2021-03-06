<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jp.co.veritrans.airweb.mdk.bean.ResultsList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Calendar"%>
<%
    Calendar objCal1 = Calendar.getInstance();
    Calendar objCal2 = Calendar.getInstance();
    objCal2.set(1970, 0, 1, 0, 0, 0);
    response.setDateHeader("Last-Modified", objCal1.getTime().getTime());
    response.setDateHeader("Expires", objCal2.getTime().getTime());
    response.setHeader("pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="format-detection" content="telephone=no" />
<meta name="viewport" content="width=device-width" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style_m.css" type="text/css"
    media="only screen and (max-width:480px)" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css"
    media="only screen and (min-width:481px)" />
<!--[if IE]>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css" media="all"/>
		<![endif]-->
<title>Test screen for posting values from AirWeb</title>
</head>
<body>
    <br />
    <%
        ResultsList resultsList = ResultsList.getInstance();
        Map<String, Map<String, String>> list = resultsList.getResultList();
        Iterator<String> ite = list.keySet().iterator();
    %>
    <form action="../../../noticeReceiver" method="POST">
        <table class="testTable">
            <tr>
                <td>Order ID</td>
                <td>
                    <select name="orderId" size="1">
                        <%
                            while (ite.hasNext()) {
                                String key = (String)ite.next();
                        %>
                        <option value="<%=key%>"><%=key%></option>
                        <%
                            }
                        %>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Status</td>
                <td>
                    <select name="mStatus" size="1">
                        <option value="success">Successful</option>
                        <option value="failure">Failed</option>
                        <option value="pending">Pending</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Error Message</td>
                <td>
                    <input type="text" size="20" name="mErrMsg" value="">
                </td>
            </tr>
            <tr>
                <td>Result Code</td>
                <td>
                    <input type="text" size="20" name="vResultCode" value="">
                </td>
            </tr>
            <tr>
                <td>Customer Name (Kanji)</td>
                <td>
                    <input type="text" size="40" name="userName" value="">
                </td>
            </tr>
            <tr>
                <td>Customer Name (Katakana)</td>
                <td>
                    <input type="text" size="40" name="userNameKana" value="">
                </td>
            </tr>
            <tr>
                <td>Email</td>
                <td>
                    <input type="text" size="30" name="mailAddress" value="">
                </td>
            </tr>
            <tr>
                <td>Address</td>
                <td>
                    <input type="text" size="50" name="address" value="">
                </td>
            </tr>
            <tr>
                <td>Gender</td>
                <td>
                    <input type="radio" name="sex" value="1">
                    Male
                    <input type="radio" name="sex" value="2">
                    Female
                </td>
            </tr>
            <tr>
                <td>Phone Number</td>
                <td>
                    <input type="text" size="20" name="telephoneno" value="">
                </td>
            </tr>
            <tr>
                <td>Zip Code</td>
                <td>
                    <input type="text" size="10" name="zipcode" value="">
                </td>
            </tr>
            <tr>
                <td>Birthday</td>
                <td>
                    <input type="text" size="20" name="birthday" value="">
                </td>
            </tr>
        </table>
        <p>
            <input type="submit" name="submit" value="Send">
        </p>
    </form>
</body>
</html>
