<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h2>【お支払をする方の情報】</h2><br/>
<table class="customer">
	<tr>
		<th class="name">
			項目
		</th>
		<th class="value">
			内容
		</th>
	<tr>
	<tr>
		<td class="name">お名前(漢字)</td>
		<td class="value">
			(姓)<html:text size="20" property="name1"/><br/>
			  (名)<html:text size="20" property="name2"/>
		  </td>
	</tr>
	<tr>
		<td class="name">お名前(カナ)</td>
		<td class="value">
			(姓)<html:text size="20" property="kana1"/><br/>
			(名)<html:text size="20" property="kana2"/>
		</td>
	</tr>
	<tr>
		<td class="name">電話番号</td>
		<td class="value">
			<html:text size="5" property="telephoneNo1"/>-
			<html:text size="5" property="telephoneNo2"/>-
			<html:text size="5" property="telephoneNo3"/>
		</td>
	</tr>
	<tr>
		<td class="name">郵便番号</td>
		<td class="value">
			<html:text size="3" property="zipCode1" maxlength="3"/>-
			<html:text size="4" property="zipCode2" maxlength="4"/>
		</td>
	</tr>
	<tr>
		<td class="name">住所１</td>
		<td class="value"><html:text size="30" property="address1"/></td>
	</tr>
	<tr>
		<td class="name">住所２</td>
		<td class="value"><html:text size="30" property="address2"/></td>
	</tr>
	<tr>
		<td class="name">住所３</td>
		<td class="value"><html:text size="30" property="address3"/></td>
	</tr>
	<tr>
		<td class="name">メールアドレス</td>
		<td class="value"><html:text size="30" property="mailAddress"/></td>
	</tr>
	<tr>
		<td class="name">生年月日</td>
		<td class="value">
			<html:text size="4" property="birthdayYYYY" maxlength="4"/>年
			<html:text size="2" property="birthdayMM" maxlength="2"/>月
			<html:text size="2" property="birthdayDD" maxlength="2"/>日
		</td>
	</tr>
	<tr>
		<td class="name">性別</td>
		<td class="value">
			<html:radio property="sex" value="1"/>男
			<html:radio property="sex" value="2"/>女
		</td>
	</tr>
</table>