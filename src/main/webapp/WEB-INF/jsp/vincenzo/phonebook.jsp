<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
<title>Phonebook</title>
</head>
<body>
	<div class="container-fluid">
		<h1>Phonebook</h1>
		<table class="table table-sm table-success">
			<tr>
				<th>ID</th>
				<th>First name</th>
				<th>Last name</th>
				<th>Number</th>
			</tr>
			<c:forEach var="contact" items="${contacts}">
				<tr>
					<td>${contact.id}</td>
					<td>${contact.firstName}</td>
					<td>${contact.lastName}</td>
					<td>${contact.phone}</td>
				</tr>
			</c:forEach>
		</table>

		<h2>Call a contact</h2>
		<form action="/vincenzo/phone/call">
			<label>ID</label>
			<c:if test="${not empty badCallID}">
				<span>does not exist</span>
			</c:if>
			<input type=text name="id">
			<button>OK</button>
		</form>

		<h2>Add a new contact</h2>
		<form action="/vincenzo/phone/insert">
			<label>First name</label> <input type=text name="firstName"
				value="${badContact.firstName}"> <label>Last name</label> <input
				type=text name="lastName" value="${badContact.lastName}"> <label>Number</label>
			<c:if test="${not empty badContact.phone}">
				<span>is not valid</span>
			</c:if>
			<input type=text name="number" value="${badContact.phone}">
			<button>OK</button>
		</form>

		<h2>Delete a contact</h2>
		<form action="/vincenzo/phone/delete">
			<label>ID</label>
			<c:if test="${not empty badID}">
				<span>does not exist</span>
			</c:if>
			<input type=text name="ID">
			<button>OK</button>
		</form>

		<h2>Modify a contact</h2>
		<form action="/vincenzo/phone/modify">
			<label>ID</label>
			<c:if test="${false flag}">
				<span>does not exist</span>
			</c:if>
			<input type=text name="ID">
			<button>OK</button>
			<c:if test="${true flag}">
				<span>exist</span>
			</c:if>
		</form>
	</div>
</body>
</html>