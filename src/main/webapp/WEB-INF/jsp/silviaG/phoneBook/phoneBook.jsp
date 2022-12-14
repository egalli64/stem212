<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/css/phone.css">
</head>
<body>
	<h1>Agenda telefonica</h1>
	
	<table>
		<tr id="first-row">
			<td>First name</td>
			<td>Last name</td>
			<td>Number</td>
		</tr>
		
		<c:forEach var="contact" items="${contacts}">
		<tr>
			<td>${contact.firstName}</td>
			<td>${contact.lastName}</td>
			<td>${contact.number}</td>
		</tr>
		</c:forEach>
	</table>
	
	<form action="/silviaG/phone/insert">
		<h3>Nome e numero da inserire</h3>
		<input type="text" class="form-control" placeholder="Inserisci nome" name="firstName">
		<input type="text" class="form-control" placeholder="Inserisci cognome" name="lastName">
		<input type="text" class="form-control" placeholder="Inserisci numero" name="number">
		<button type="submit">Invia risposte</button>
	</form>
	
	<form action="/phone/delete">
		<h3>Nome e numero da eliminare</h3>
		<input type="text" class="form-control" placeholder="Inserisci nome" name="deleteName">
		<input type="text" class="form-control" placeholder="Inserisci numero" name="deleteNumber">
	</form>
</body>
</html>