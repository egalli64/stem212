<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda Telefonica</title>
</head>

<body>
	<h1>Agenda Telefonica</h1>
	<table>
		<tr>
			<th scope="col">ID</th>
			<th scope="col">Nome</th>
			<th scope="col">Cogome</th>
			<th scope="col">Numero</th>
		</tr>
		<c:forEach var="contact" items="${contacts}">
			<tr>
				<th>${contact.id}</th>
				<th>${contact.firstName}</th>
				<th>${contact.lastName}</th>
				<th>${contact.phone}</th>
			</tr>
		</c:forEach>
	</table>
	<form action="/alberto/phone/add">
			<input name="name" placeholder="nome"> 
			<input name="surname" placeholder="cognome"> 
			<input name="number" placeholder="numero">
		<button>Aggiungi contatto</button>
	</form>
	<form action="/alberto/phone/remove">
			<input name="name" placeholder="nome"> 
			<input name="surname" placeholder="cognome"> 
		<button>Rimuovi contatto</button>
	</form>
</body>

</html>