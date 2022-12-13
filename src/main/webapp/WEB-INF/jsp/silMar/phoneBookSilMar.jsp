<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/phone.css">
<title>Phonebook</title>
</head>
<body>
	<table>
		<tr>
			<th style="padding-left: 35px;">First name</th>
			<th style="padding-left: 35px;">Last name</th>
			<th style="padding-left: 35px;">Number</th>
		</tr>
		<c:forEach var="contact" items="${contacts}">
			<tr>
				<td style="padding-left: 35px;">${contact.firstName}</td>
				<td style="padding-left: 35px;">${contact.lastName}</td>
				<td style="padding-left: 35px;">${contact.number}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<form method="get" action="/phone/insert">
			<h4 id="insertcontact">Insert New Contact here:</h4>
			<p>
			First name:<input type="text" name="firstname">
			Last name:<input type="text" name="lastname">
			Number:<input type="text" name="number">
			<input type="submit" value="Insert">
			</p>
	</form>
</body>
</html>