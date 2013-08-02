<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // 内容: セッションを使用する
    session.setAttribute("commodityId1", "001");
    session.setAttribute("commodityId2", "002");
    session.setAttribute("commodityId3", "003");
    session.setAttribute("commodityJanCode1", "J01");
    session.setAttribute("commodityJanCode2", "J02");
    session.setAttribute("commodityJanCode3", "J03");
    session.setAttribute("commodityName1", "Mineral water");
    session.setAttribute("commodityName2", "Ionized water");
    session.setAttribute("commodityName3", "Electrolyzed water");
    session.setAttribute("commodityNum1", "1");
    session.setAttribute("commodityNum2", "2");
    session.setAttribute("commodityNum3", "3");
    session.setAttribute("commodityUnit1", "100");
    session.setAttribute("commodityUnit2", "200");
    session.setAttribute("commodityUnit3", "300");
    session.setAttribute("shippingAmount", "500");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="ja">
<head>
<%@ include file="include_head.jsp"%>
<title>Purchase Screen</title>
</head>
<body>
	<br />
	<table class="cart">
		<tr>
			<th class="name">Name</th>
			<th class="unitp">Price</th>
			<th class="num">Quantity</th>
			<th class="sum">Subtotal</th>
		</tr>
		<tr>
			<td class="name">Mineral water</td>
			<td class="unitp">100 JPY</td>
			<td class="num">1</td>
			<td class="sum">100 JPY</td>
		</tr>
		<tr>
			<td class="name">Ionized water</td>
			<td class="unitp">200 JPY</td>
			<td class="num">2</td>
			<td class="sum">400 JPY</td>
		</tr>
		<tr>
			<td class="name">Electrolyzed water</td>
			<td class="unitp">300 JPY</td>
			<td class="num">3</td>
			<td class="sum">900 JPY</td>
		</tr>
		<tr>
			<td colspan="4" class="sum">Shipping free: 500 JPY</td>
		</tr>
		<tr>
			<td colspan="4" class="sum">Total: 1,900 JPY</td>
		</tr>
	</table>
	<br />
	<table class="noline">
		<tr>
			<td>
				<a href="./entry.jsp">Not specified</a>&nbsp;
			</td>
			<td>
				<a href="./entry_card.jsp">Credit Card</a>&nbsp;
			</td>
			<td>
				<a href="./entry_cvs.jsp">Convenience Stores</a>&nbsp;
			</td>
		</tr>
	</table>
</body>
</html>