<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Phonebook</title>
</head>
<body>
	<table>
		<tr>
			<th>First name</th>
			<th>Last name</th>
			<th>Number</th>
		</tr>
		<c:forEach var="contact" items="${contacts}">
			<tr>
				<td>${contact.firstName}</td>
				<td>${contact.lastName}</td>
				<td>${contact.phone}</td>
			</tr>
		</c:forEach>
	</table>

	<h1>Add a new contact</h1>
	<form action="/phone/insert">
		<input type=text name="firstName"> <input type=text
			name="lastName"> <input type=text name="number">
		<button>OK</button>
	</form>

	<h1>Delete a contact</h1>
	<form action="/phone/delete">
		<input type=text name="firstName"> <input type=text
			name="lastName"> <input type=text name="number">
		<button>OK</button>
	</form>
</body>
</html>