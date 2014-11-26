<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jp.co.veritrans.airweb.mdk.conf.MerchantConf"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="ja">
<head>
<%@ include file="include_head.jsp"%>
<title>お支払手続きへ - Continue with payment process</title>
<%
    MerchantConf info = MerchantConf.getInfo();
			String sessionID = session.getId();
			String key1a = (String) request.getAttribute("SETTLEMENT_KEY1A");
			String merchantId = (String) request.getAttribute("MERCHANT_ID");
			String orderId = (String) request.getAttribute("ORDER_ID");
%>
<script type="text/javascript">
<!--
	function onSubmit() {
		document.getElementById('merchant').style.display = 'none';
		document.getElementById('aw').style.display = 'block';
	}
// -->
</script>
</head>
<body>
    <div class="header"></div>
    <div class="if_contents">
        <div id="aw" style="display: none;">
            <iframe src="" name="airweb_frame" class="frame">
                この部分は iframe 対応のブラウザで見てください。<br /> Please view this in Iframe supports Browsers.
            </iframe>
        </div>
        <div id="merchant">
            <h1 align="center">
                お支払手続きへ <br /> Continue with payment process
            </h1>
            <div align="center">
                <table border="1" cellpadding="10" bgcolor="#FFFFCC">
                    <tr>
                        <td>
                            本画面はマーチャントサイトからAirWebに誘導する画面のイメージです。<br> 下記ボタンを押すと決済情報入力画面に遷移します。<br>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            This is Introduction screen to AirWeb from merchant's site.<br> Click below button to
                            redirect to payment information input screen.<br>
                        </td>
                    </tr>
                </table>
                <br /> <br />
                <form action="<%=info.getAirWebSettlementUrl()%>" method="post"
                    onsubmit="document.getElementById('submitBtn').disabled=true;onSubmit();" target="airweb_frame">
                    <input type="hidden" name="MERCHANT_ID" value="<%=merchantId%>" />
                    <input type="hidden" name="ORDER_ID" value="<%=orderId%>" />
                    <input type="hidden" name="BROWSER_ENCRYPTION_KEY" value="<%=key1a%>" />
                    <input id="submitBtn" type="submit" value="　入力画面へ-Go to payment screen　" />
                </form>
            </div>
        </div>
    </div>
    <div class="footer"></div>
</body>
</html>
