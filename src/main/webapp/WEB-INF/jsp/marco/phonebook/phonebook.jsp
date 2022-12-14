<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/marco/css/phonebookstyle.css">
<title>Phonebook</title>
</head>
<body>
	<h1>Phonebook</h1>
	<table> 
		<tr id="first-row">
			<th>ID</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Phone</th>
	</table>
	<table>
		<c:forEach var="contact" items="${contacts}">
			<tr>
				<td>${contact.id}</td>
				<td>${contact.firstName}</td>
				<td>${contact.lastName}</td>
				<td>${contact.phone}</td>
			</tr>
		</c:forEach>
	</table>
	<h3>Contact to add</h3>
	<c:if test="${not empty errorInsertBlank}">
			<p id="error">${errorInsertBlank}</p>
		</c:if>
	<c:if test="${not empty errorInsertNumb}">
			<p id="error">${errorInsertNumb}</p>
		</c:if>
	<form action="/marco/phone/insert">
		<input type="text" name="firstName" placeholder="First name"> 
		<input type="text" name="lastName" placeholder="Last name"> 
		<input type="text" name="phone" placeholder="Phone"> 
		<input type="submit" value="Insert"/>
	</form>
	<h3>Contact to remove</h3>
	<form action="/marco/phone/remove">
		<input type="text" name="id" placeholder="ID"> 
		<input type="submit" value="Remove"/>
	</form>
</body>
</html>