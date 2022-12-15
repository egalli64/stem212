<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Phone</title>
</head>
<body>
	<table>
		<tr>
			<td>id</td>
			<td>First name</td>
			<td>Last name</td>
			<td>Phone number</td>
		</tr>
		<c:forEach var="contact" items="${contacts}">
			<tr>
				<td>${contact.id}</td>
				<td>${contact.firstName}</td>
				<td>${contact.lastName}</td>
				<td>${contact.phone}</td>
			</tr>
		</c:forEach>
	</table>
	<form method="get" action="/Manuel/phone/insert">
		
		<p>
			Nome : <input type="text" name="firstName">
		</p>
		<p>
			Cognome : <input type="text" name="lastName">
		</p>
		<p>
			Numero : <input type="text" name="number">
		</p>
		<p>
			<input type="submit" value="Invio Dati">
		</p>
	</form>
	<form method="get" action="/Manuel/phone/delete">
		<p>
			id : <input type="number" name="id">
		</p>
		
		<p>
			<input type="submit" value="Elimina contatto">
		</p>
	</form>
</body>
</html>