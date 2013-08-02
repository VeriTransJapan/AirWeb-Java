<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String id1 = (String)session.getAttribute("commodityId1");
    String janCode1 = (String)session.getAttribute("commodityJanCode1");
    String name1 = (String)session.getAttribute("commodityName1");
    String num1 = (String)session.getAttribute("commodityNum1");
    String unit1 = (String)session.getAttribute("commodityUnit1");
    String id2 = (String)session.getAttribute("commodityId2");
    String janCode2 = (String)session.getAttribute("commodityJanCode2");
    String name2 = (String)session.getAttribute("commodityName2");
    String num2 = (String)session.getAttribute("commodityNum2");
    String unit2 = (String)session.getAttribute("commodityUnit2");
    String id3 = (String)session.getAttribute("commodityId3");
    String janCode3 = (String)session.getAttribute("commodityJanCode3");
    String name3 = (String)session.getAttribute("commodityName3");
    String num3 = (String)session.getAttribute("commodityNum3");
    String unit3 = (String)session.getAttribute("commodityUnit3");
    String shippingAmount = (String)session.getAttribute("shippingAmount");

    if (name1 == null) {
%>
<jsp:forward page="./purchase.jsp" />
<%
    }

    int a = Integer.parseInt(num1);
    int b = Integer.parseInt(unit1);
    long amount1 = a * b;

    a = Integer.parseInt(num2);
    b = Integer.parseInt(unit2);
    long amount2 = a * b;

    a = Integer.parseInt(num3);
    b = Integer.parseInt(unit3);
    long amount3 = a * b;

    long shippingAmountView = Integer.parseInt(shippingAmount);

    long totalAmount = amount1 + amount2 + amount3 + shippingAmountView;
    NumberFormat nf = DecimalFormat.getInstance();
    String amount = String.valueOf(amount1 + amount2 + amount3);
%>