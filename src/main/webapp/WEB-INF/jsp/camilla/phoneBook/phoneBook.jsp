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
	<div class="container-fluid">

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

		<c:if test="${not empty errorSearch}">
			<p id="error">${errorSearch}</p>
		</c:if>
		<form action="/camilla/phoneBook/search">
			<div>
				<div class="row mb-3">
					<div class="col-sm-4">
						<input class="form-control" name="string" placeholder="Cerca"
							value="${string}">
					</div>
					<div class="col-sm-5">
						<button class="btn btn-outline-secondary">Cerca</button>
						<a href="/camilla/phoneBook" class="btn btn-outline-secondary">Reset</a>
					</div>
				</div>
			</div>
		</form>

		<div class="row">
			<div class="col-8">
				<table class="table table-hover table-bordered">
					<thead>
						<tr>
							<c:if test="${empty string}">
								<th scope="col"><a
									href="/camilla/phoneBook/orderByFirstName" class="linkBlack">Nome</a></th>
								<th scope="col"><a
									href="/camilla/phoneBook/orderByLastName" class="linkBlack">Cognome</a></th>
							</c:if>
							<c:if test="${not empty string}">
								<th scope="col"><a
									href="/camilla/phoneBook/searchAndOrderByFirstName?string=${string}"
									class="linkBlack">Nome</a></th>
								<th scope="col"><a
									href="/camilla/phoneBook/searchAndOrderByLastName?string=${string}"
									class="linkBlack">Cognome</a></th>
							</c:if>
							<th scope="col">Numero</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody class="table-group-divider">
						<c:forEach var="contact" items="${contacts}">
							<tr>
								<td scope="row">${contact.firstName}</td>
								<td scope="row">${contact.lastName}</td>
								<td scope="row">${contact.phone}</td>
								<td><a href="/camilla/phoneBook/remove?id=${contact.id}"><img
										src="/camilla/bin.png" alt="delete" height="20"></a></td>
								<td><a href="/camilla/phoneBook/preModify?id=${contact.id}"><img
										src="/camilla/modify.png" alt="modify" height="20"></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		<c:if test="${empty plus}">
			<a href="/camilla/phoneBook/preInsert"><img
				src="/camilla/insert.png" alt="insert" height="20"></a>
		</c:if>
		<br>
		<c:if test="${not empty insert}">
			<hr>
			<h3>Aggiungi contatto</h3>
			<c:if test="${not empty errorInsert}">
				<p id="error">${errorInsert}</p>
			</c:if>
			<form action="/camilla/phoneBook/insert">

				<div>
					<div class="row mb-3">
						<label class="col-sm-4 col-form-label">Nome</label>
						<div class="col-sm-5">
							<input class="form-control" name="firstName" placeholder="Nome"
								value="${badContact.firstName}" required>
						</div>
					</div>

					<div class="row mb-3">
						<label class="col-sm-4 col-form-label">Cognome</label>
						<div class="col-sm-5">
							<input class="form-control" name="lastName" placeholder="Cognome"
								value="${badContact.lastName}" required>
						</div>
					</div>

					<div class="row mb-3">
						<label class="col-sm-4 col-form-label">Numero</label>
						<div class="col-sm-5">
							<input class="form-control" name="phone" placeholder="Numero"
								value="${badContact.phone}" required>
						</div>
					</div>
					<div class="row mb-3">
						<div class="col-sm-4"></div>
						<div class="col-sm-5">
							<c:if test="${not empty errorNumber}">
								<p id="error">${errorNumber}</p>
							</c:if>
						</div>
					</div>
					<div class="row">
						<div class="col-4"></div>
						<div class="col-8">
							<button class="btn btn-outline-secondary">Aggiungi</button>
							<a href="/camilla/phoneBook" class="btn btn-outline-secondary">Annulla</a>
						</div>
					</div>
				</div>
			</form>
		</c:if>

		<c:if test="${not empty contactToBeModified}">
			<br>
			<hr>
			<h3>Modifica contatto</h3>
			<form action="/camilla/phoneBook/modify">

				<div>
					<input class="form-control" name="id" placeholder="Id"
						value="${contactToBeModified.id}" type="hidden">

					<div class="row mb-3">
						<label class="col-sm-4 col-form-label">Nome</label>
						<div class="col-sm-5">
							<input class="form-control" name="firstName" placeholder="Nome"
								value="${contactToBeModified.firstName}" required>
						</div>
					</div>

					<div class="row mb-3">
						<label class="col-sm-4 col-form-label">Cognome</label>
						<div class="col-sm-5">
							<input class="form-control" name="lastName" placeholder="Cognome"
								value="${contactToBeModified.lastName}" required>
						</div>
					</div>

					<div class="row mb-3">
						<label class="col-sm-4 col-form-label">Numero</label>
						<div class="col-sm-5">
							<input class="form-control" name="phone" placeholder="Numero"
								value="${contactToBeModified.phone}" required>
						</div>
					</div>
					<div class="row mb-3">
						<div class="col-sm-4"></div>
						<div class="col-sm-5">
							<c:if test="${not empty errorNumberModify}">
								<p id="error">${errorNumberModify}</p>
							</c:if>
						</div>
					</div>
					<div class="row">
						<div class="col-4"></div>
						<div class="col-8">
							<button class="btn btn-outline-secondary">Modifica</button>
							<a href="/camilla/phoneBook" class="btn btn-outline-secondary">Annulla</a>
						</div>
					</div>
				</div>
			</form>
		</c:if>

	</div>
</body>
</html>