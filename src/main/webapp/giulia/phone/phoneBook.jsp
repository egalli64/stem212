<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PhoneBook</title>
</head>
<body>
	<table>
		<tr>
			<th>First name</th>
			<th>Last name</th>
			<th>Phone number</th>
		</tr>
		<c:forEach var="contact" items="${contacts}">
			<tr>
				<td>${contact.firstName}</td>
				<td>${contact.lastName}</td>
				<td>${contact.number}</td>
			</tr>
		</c:forEach>
	</table>
	<form action="/phone/insert">
		<label>Name:<input name="name" placeholder="Enter new name"></label>
		<label>Surname:<input name="lastName" placeholder="Enter new last name"></label>
		<label>Number:<input name="number"
			placeholder="Enter new number"></label>
		<button>Go</button>
	</form>
</body>
</html>