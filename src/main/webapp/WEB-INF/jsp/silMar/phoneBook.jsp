<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/silMar/css/phoneSilMar.css">
<title>Phonebook</title>
</head>
<body>
	<h1 id="title">Phonebook</h1>
	<table>
		<tr>
			<th style="padding-left: 35px;">Id</th>
			<th style="padding-left: 35px;">First name</th>
			<th style="padding-left: 35px;">Last name</th>
			<th style="padding-left: 35px;">Phone</th>
		</tr>
		<c:forEach var="contact" items="${contacts}">
			<tr>
				<td style="padding-left: 35px;">${contact.id}</td>
				<td style="padding-left: 35px;">${contact.firstName}</td>
				<td style="padding-left: 35px;">${contact.lastName}</td>
				<td style="padding-left: 35px;">${contact.phone}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<form method="get" action="/silMar/phone/insert">
			<h4 id="insertcontact">Insert New Contact here:</h4>
			<p>
			Id:<input type="number" name="id">
			First name:<input type="text" name="firstName">
			Last name:<input type="text" name="lastName">
			Phone:<input type="text" name="phone">
			<input type="submit" value="Insert">
			</p>
	</form>
	<form method="get" action="/silMar/phone/remove">
			<h4 id="insertcontact">Remove Contact here:</h4>
			<p>
			Id:<input type="number" name="id">
			<input type="submit" value="Remove">
			</p>
	</form>
</body>
</html>