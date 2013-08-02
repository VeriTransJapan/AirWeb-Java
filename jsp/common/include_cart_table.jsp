<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h2>【購入商品情報】</h2><br/>
<table class="cart">
	<tr>
		<th class="name">商品名</td>
		<th class="unitp">単価</td>
		<th class="num">個数</td>
		<th class="sum">小計</td>
	</tr>
	<tr>
		<td class="name"><%= name1 %></td>
		<td class="unitp"><%= unit1 %> 円</td>
		<td class="num"><%= num1 %> 個</td>
		<td class="sum"><%= amount1 %> 円</td>
	</tr>
	<tr>
		<td class="name"><%= name2 %></td>
		<td class="unitp"><%= unit2 %> 円</td>
		<td class="num"><%= num2 %> 個</td>
		<td class="sum"><%= amount2 %> 円</td>
	</tr>
	<tr>
		<td class="name"><%= name3 %></td>
		<td class="unitp"><%= unit3 %> 円</td>
		<td class="num"><%= num3 %> 個</td>
		<td class="sum"><%= amount3 %> 円</td>
	</tr>
	<tr>
		<td colspan="4" class="sum">送料合計：<%= nf.format(shippingAmountView) %> 円</td>
	</tr>
	<tr>
		<td colspan="4" class="sum">合計：<%= nf.format(totalAmount) %> 円</td>
	</tr>
</table>