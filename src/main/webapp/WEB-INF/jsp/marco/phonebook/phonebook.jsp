<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Phonebook</title>
</head>
<body>
	<h1>Phonebook</h1>
	<table> 
		<tr>
			<th>First name |</th>
			<th> Last name |</th>
			<th> Phone</th>
	</table>
	<table>
		<c:forEach var="contact" items="${contacts}">
			<tr>
				<td>${contact.firstName}</td>
				<td>${contact.lastName}</td>
				<td>${contact.phone}</td>
			</tr>
		</c:forEach>
	</table>
	<h3>Contact to add</h3>
	<c:if test="${not empty error}">
		<p id="error">${error}</p>
	</c:if>
	
	<form action="/marco/phonebook/insert">
		<input type="text" name="firstName" placeholder="First name"> 
		<input type="text" name="lastName" placeholder="Last name"> 
		<input type="text" name="phone" placeholder="Phone"> 
		<input type="submit" value="Insert"/>
	</form>
	<h3>Contact to remove</h3>
	<form method="post" action="remove">
		<input type="text" name="phone" placeholder="Phone"> 
		<input type="submit" value="Remove"/>
	</form>
</body>
</html>