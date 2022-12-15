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
	<h1 style="margin-bottom: 20px">PhoneBook</h1>
	<div class="container-fluid">
		<table class="table table-striped table-bordered" id="agenda">
			<thead>
				<tr>
					<th scope="row"><h2>ID</h2></th>
					<th scope="row"><h2>Name</h2></th>
					<th scope="row"><h2>LastName</h2></th>
					<th scope="row"><h2>Phone</h2></th>
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

	<form action="/giulia/phone/add">
		<h3>Add contact</h3>
		<c:if test="${not empty badContact}">
			<span class="error">Not acceptable contact</span>
		</c:if>
		<div class="row">
			<div class="col">
				<label class="form-label">Name</label> <input name="firstName"
					placeholder="Inserisci nome" value="${badContact.firstName}"
					required>
			</div>
			<div class="col">
				<label class="form-label">LastName</label> <input name="lastName"
					placeholder="Inserisci cognome" value="${badContact.lastName}"
					required>
			</div>
			<div class="col">
				<label class="form-label">Number</label> <input name="phone"
					placeholder="Inserisci numero" value="${badContact.phone}" required>
			</div>
		</div>
		<button style="margin-top: 10px">Add contact</button>
	</form>

</body>
</html>