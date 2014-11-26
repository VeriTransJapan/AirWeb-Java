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
			<html:text size="11" property="telephoneNo"/>
		</td>
	</tr>
	<tr>
		<td class="name">Zip code</td>
		<td class="value">
			<html:text size="8" property="zipCode" maxlength="8"/>
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
		<td class="name">Birthday(YYYYMMDD)</td>
		<td class="value">
			<html:text size="8" property="birthday" maxlength="8"/>
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