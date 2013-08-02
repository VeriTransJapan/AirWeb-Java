<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h2>[Customer Information]</h2><br/>
<table class="customer">
	<tr>
		<th class="name">
			Items
		</th>
		<th class="value">
			Contents
		</th>
	<tr>
	<tr>
		<td class="name">Fullname(Kanji)</td>
		<td class="value">
			(Lastname)<html:text size="20" property="name1"/><br/>
			(Firstname)<html:text size="20" property="name2"/>
		  </td>
	</tr>
	<tr>
		<td class="name">Fullname(Katakana)</td>
		<td class="value">
			(Lastname)<html:text size="20" property="kana1"/><br/>
			(Firstname)<html:text size="20" property="kana2"/>
		</td>
	</tr>
	<tr>
		<td class="name">Phone number</td>
		<td class="value">
			<html:text size="5" property="telephoneNo1"/>-
			<html:text size="5" property="telephoneNo2"/>-
			<html:text size="5" property="telephoneNo3"/>
		</td>
	</tr>
	<tr>
		<td class="name">Zip code</td>
		<td class="value">
			<html:text size="3" property="zipCode1" maxlength="3"/>-
			<html:text size="4" property="zipCode2" maxlength="4"/>
		</td>
	</tr>
	<tr>
		<td class="name">Address 1</td>
		<td class="value"><html:text size="30" property="address1"/></td>
	</tr>
	<tr>
		<td class="name">Address 2</td>
		<td class="value"><html:text size="30" property="address2"/></td>
	</tr>
	<tr>
		<td class="name">Address 3</td>
		<td class="value"><html:text size="30" property="address3"/></td>
	</tr>
	<tr>
		<td class="name">Email</td>
		<td class="value"><html:text size="30" property="mailAddress"/></td>
	</tr>
	<tr>
		<td class="name">Birthday</td>
		<td class="value">
			<html:text size="4" property="birthdayYYYY" maxlength="4"/>Year
			<html:text size="2" property="birthdayMM" maxlength="2"/>Month
			<html:text size="2" property="birthdayDD" maxlength="2"/>Day
		</td>
	</tr>
	<tr>
		<td class="name">Gender</td>
		<td class="value">
			<html:radio property="sex" value="1"/>Male
			<html:radio property="sex" value="2"/>Female
		</td>
	</tr>
</table>