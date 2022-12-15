<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda Telefonica</title>
<!-- collegamento a css -->
<link rel="stylesheet" type="text/css" href="/alberto/css/mioT.css">
<!-- collegamento a bootstrap -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
	crossorigin="anonymous">
	
</script>
</head>

<body>
	<h1 style="margin-bottom: 20px">Agenda Telefonica</h1>
	<div class="container-fluid">
		<table class="table table-striped table-bordered" id="agenda">
			<thead>
				<tr>
					<th scope="row"><h2>ID</h2></th>
					<th scope="row"><h2>Nome</h2></th>
					<th scope="row"><h2>Cogome</h2></th>
					<th scope="row"><h2>Numero</h2></th>
				</tr>
			</thead>
			<c:forEach var="contact" items="${contacts}">
				<tr>
					<th>${contact.id}</th>
					<th>${contact.firstName}</th>
					<th>${contact.lastName}</th>
					<th>${contact.phone}</th>
				</tr>
			</c:forEach>
		</table>
	</div>

	<form action="/alberto/phone/add">
		<h3>Aggiungi Contatto</h3>
		<c:if test="${not empty badContact}">
			<span class="error">Contatto non accettabile</span>
		</c:if>
		<div class="row">
			<div class="col">
				<label class="form-label">Nome</label>
				<input name="firstName" placeholder="Inserisci nome" value="${badContact.firstName}" required>
			</div>
			<div class="col">
				<label class="form-label">Cognome</label>
				<input name="lastName" placeholder="Inserisci cognome" value="${badContact.lastName}" required>
			</div>
			<div class="col">
				<label class="form-label">Numero</label>
				<input name="phone" placeholder="Inserisci numero" value="${badContact.phone}" required>
			</div>
		</div>
		<button style="margin-top: 10px">Aggiungi contatto</button>
	</form>

	<c:if test="${empty modContact}">
		<form action="/alberto/phone/preModify">
			<h3 style="padding-top: 25px">Modifica Contatto</h3>
			<c:if test="${not empty modBadId}">
				<span class="error">Id non presente</span>
			</c:if>
			<div class="row">
				<div class="col">
					<label class="form-label">ID</label>
					<input name="id" type="number" placeholder="ID da modificare" value="${modBadId}">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<button style="margin-top: 10px">Modifica contatto</button>
				</div>
			</div>
		</form>
	</c:if>

	<c:if test="${not empty modContact}">
		<form action="/alberto/phone/modify">
			<h3 style="padding-top: 25px">Modifica Contatto</h3>
			<div class="row" style="padding-bottom: 15px">
				<div class="col">
					<label class="form-label">ID</label>
					<input name="id" type="number" value="${modContact.id}" readonly>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label">Nome</label>
					<input name="firstName" placeholder="Inserisci nome" value="${modContact.firstName}" required>
				</div>
				<div class="col">
					<label class="form-label">Cognome</label>
					<input name="lastName" placeholder="Inserisci cognome" value="${modContact.lastName}" required>
				</div>
				<div class="col">
					<label class="form-label">Numero</label>
					<input name="phone" placeholder="Inserisci numero" value="${modContact.phone}" required>
				</div>
			</div>
			<button>Modifica contatto</button>
		</form>
	</c:if>

	<form action="/alberto/phone/remove">
		<h3 style="padding-top: 25px">Rimuovi contatto</h3>
		<c:if test="${not empty badId}">
			<span class="error">Id non presente</span>
		</c:if>
		<div class="row">
			<div class="col">
				<label class="form-label">Numero</label>
				<input name="id" type="number" placeholder="ID da rimuovere" value="${badId}">
			</div>
		</div>
		<button style="margin-top: 10px">Rimuovi contatto</button>
	</form>
</body>

</html>