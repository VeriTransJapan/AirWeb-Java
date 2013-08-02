<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // 内容: セッションを使用する
    session.setAttribute("commodityId1", "001");
    session.setAttribute("commodityId2", "002");
    session.setAttribute("commodityId3", "003");
    session.setAttribute("commodityJanCode1", "J01");
    session.setAttribute("commodityJanCode2", "J02");
    session.setAttribute("commodityJanCode3", "J03");
    session.setAttribute("commodityName1", "天然水");
    session.setAttribute("commodityName2", "イオン水");
    session.setAttribute("commodityName3", "電解水");
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
<title>購入画面</title>
</head>
<body>
    <br />
    <table class="cart">
        <tr>
            <th class="name">商品名
            </td>
            <th class="unitp">単価
            </td>
            <th class="num">個数
            </td>
            <th class="sum">小計
            </td>
        </tr>
        <tr>
            <td class="name">天然水</td>
            <td class="unitp">100 円</td>
            <td class="num">1 個</td>
            <td class="sum">100 円</td>
        </tr>
        <tr>
            <td class="name">イオン水</td>
            <td class="unitp">200 円</td>
            <td class="num">2 個</td>
            <td class="sum">400 円</td>
        </tr>
        <tr>
            <td class="name">電解水</td>
            <td class="unitp">300 円</td>
            <td class="num">3 個</td>
            <td class="sum">900 円</td>
        </tr>
        <tr>
            <td colspan="4" class="sum">送料合計：500 円</td>
        </tr>
        <tr>
            <td colspan="4" class="sum">合計：1,900 円</td>
        </tr>
    </table>
    <br />
    <table class="noline">
        <tr>
            <td>
                <a href="./entry.jsp">後で指定</a>&nbsp;
            </td>
            <td>
                <a href="./entry_card.jsp">カード</a>&nbsp;
            </td>
            <td>
                <a href="./entry_cvs.jsp">コンビニ</a>&nbsp;
            </td>
        </tr>
    </table>
</body>
</html>