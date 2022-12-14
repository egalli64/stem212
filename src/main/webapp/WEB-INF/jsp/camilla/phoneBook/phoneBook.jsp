<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Phone book</title>
<link rel="stylesheet" type="text/css" href="/camilla/css/phoneBook.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid" class="wrapper">

		<nav class="navbar navbar-expand-sm">
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/">Index</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/camilla/index.html">Progetti</a></li>
				</ul>
			</div>
		</nav>

		<h1>Rubrica telefonica</h1>
		<br>
		<div class="row">
			<div class="col-8">
				<table class="table table-hover table-bordered">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Nome</th>
							<th scope="col">Cognome</th>
							<th scope="col">Numero</th>
							<th scope="col">Delete</th>
						</tr>
					</thead>
					<tbody class="table-group-divider">
						<c:forEach var="contact" items="${contacts}">
							<tr>
								<td scope="row">${contact.id}</td>
								<td scope="row">${contact.firstName}</td>
								<td scope="row">${contact.lastName}</td>
								<td scope="row">${contact.phone}</td>
								<td><a href="/camilla/phoneBook/remove?id=${contact.id}"><img src="/camilla/bin.png" alt="delete" height="20"></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		<br>
		<hr>
		<h3>Aggiungi contatto</h3>
		<c:if test="${not empty errorInsert}">
			<p id="error">${errorInsert}</p>
		</c:if>
		<form action="/camilla/phoneBook/insert">

			<div>
				<div class="row mb-3">
					<label for="inputName" class="col-sm-4 col-form-label">Nome</label>
					<div class="col-sm-5">
						<input class="form-control" id="inputName" name="firstName"
							placeholder="Nome">
					</div>
				</div>

				<div class="row mb-3">
					<label for="inputLast" class="col-sm-4 col-form-label">Cognome</label>
					<div class="col-sm-5">
						<input class="form-control" id="inputLast" name="lastName"
							placeholder="Cognome">
					</div>
				</div>

				<div class="row mb-3">
					<label for="inputPhone" class="col-sm-4 col-form-label">Numero</label>
					<div class="col-sm-5">
						<input class="form-control" id="inputPhone" name="phone"
							placeholder="Numero">
					</div>
				</div>
				<div class="row">
					<div class="col-4"></div>
					<div class="col-8">
						<button class="btn btn-outline-secondary">Aggiungi</button>
					</div>
				</div>
			</div>
		</form>

		<br>
		<h3>Elimina contatto</h3>
		<c:if test="${not empty errorDelete}">
			<p id="error">${errorDelete}</p>
		</c:if>
		<form action="/camilla/phoneBook/remove">
			<div>
				<div class="row mb-3">
					<label for="inputId" class="col-sm-4 col-form-label">Id</label>
					<div class="col-sm-5">
						<input class="form-control" id="inputName" name="id"
							placeholder="Id" type="number">
					</div>
				</div>
				<div class="row">
					<div class="col-4"></div>
					<div class="col-8">
						<button class="btn btn-outline-secondary">Elimina</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>