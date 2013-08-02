<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h2>[Shopping Card]</h2><br/>
<table class="cart">
	<tr>
		<th class="name">Name</td>
		<th class="unitp">Price</td>
		<th class="num">Quantity</td>
		<th class="sum">Subtotal</td>
	</tr>
	<tr>
		<td class="name"><%= name1 %></td>
		<td class="unitp"><%= unit1 %> JPY</td>
		<td class="num"><%= num1 %> </td>
		<td class="sum"><%= amount1 %> JPY</td>
	</tr>
	<tr>
		<td class="name"><%= name2 %></td>
		<td class="unitp"><%= unit2 %> JPY</td>
		<td class="num"><%= num2 %> </td>
		<td class="sum"><%= amount2 %> JPY</td>
	</tr>
	<tr>
		<td class="name"><%= name3 %></td>
		<td class="unitp"><%= unit3 %> JPY</td>
		<td class="num"><%= num3 %> </td>
		<td class="sum"><%= amount3 %> JPY</td>
	</tr>
	<tr>
		<td colspan="4" class="sum">Shipping fee: <%= nf.format(shippingAmountView) %> JPY</td>
	</tr>
	<tr>
		<td colspan="4" class="sum">Total: <%= nf.format(totalAmount) %> JPY</td>
	</tr>
</table>