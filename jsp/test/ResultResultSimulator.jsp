<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jp.co.veritrans.airweb.mdk.bean.ResultsList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Map"%>
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
<title>ブラウザからの戻り値設定画面</title>
</head>
<body>
    <br />
    <%
        ResultsList resultsList = ResultsList.getInstance();
        Map<String, Map<String, String>> list = resultsList.getResultList();
        Iterator<String> ite = list.keySet().iterator();
    %>
    <form action="../../resultReceiver.do" method="POST">
        <table class="testTable">
            <tr>
                <td>取引ID</td>
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
                <td>ステータス</td>
                <td>
                    <select name="mStatus" size="1">
                        <option value="success">正常終了</option>
                        <option value="failure">異常終了</option>
                        <option value="pending">保留</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>結果コード</td>
                <td>
                    <input type="text" size="20" name="vResultCode" value="">
                </td>
            </tr>
            <tr>
                <td>Session Id</td>
                <td>
                    <input type="text" size="50" name="sessionId" value="">
                </td>
            </tr>
        </table>
        <p>
            <input type="submit" name="submit" value="送信">
        </p>
    </form>
</body>
</html>
