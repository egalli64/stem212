<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/martina/css/martina.css">
<title>Rubrica</title>
</head>
<body>
<h1>RUBRICA</h1>
	<table> 
		<caption> CONTACTS </caption>
			<tr>
				<th >First name </th>
				<th >Last name </th>
				<th >Phone </th>
			</tr>
	</table>
	<table>
		<c:forEach var="contact" items="${contacts}">
			<tr>
				<td >${contact.firstName}</td>
				<td>${contact.lastName}</td>
				<td>${contact.phone}</td>
			</tr>
		</c:forEach>
	</table>
	<h3>Contact to add</h3>
	<form method="post" action="/martina/phone/insert">
		<input type="text" name="firstName" placeholder="First name"> 
		<input type="text" name="lastName" placeholder="Last name"> 
		<input type="text" name="phone" placeholder="Phone"> 
		<input type="submit" value="insert"/>
	</form>
	<h3>Contact to remove</h3>
	<form method="post" action="remove">
		<input type="text" name="phone" placeholder="Phone"> 
		<input type="submit" value="remove"/>
	</form>
</body>
</html>