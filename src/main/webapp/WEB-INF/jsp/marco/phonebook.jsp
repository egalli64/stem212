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
			<th> Number</th>
	</table>
	<table>
		<c:forEach var="person" items="${result}">
			<tr>
				<td>${person.firstName}</td>
				<td>${person.lastName}</td>
				<td>${person.number}</td>
			</tr>
		</c:forEach>
	</table>
	<h3>Contact to add</h3>
	<form method="post" action="insert">
		<input type="text" name="firstName" placeholder="First name"> 
		<input type="text" name="lastName" placeholder="Last name"> 
		<input type="text" name="number" placeholder="Number"> 
		<input type="submit" value="Insert"/>
	</form>
	<h3>Contact to remove</h3>
	<form method="post" action="remove">
		<input type="text" name="number" placeholder="Number"> 
		<input type="submit" value="Remove"/>
	</form>
</body>
</html>