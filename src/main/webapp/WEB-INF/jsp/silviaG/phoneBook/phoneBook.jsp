<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Rubrica telefonica</title>
	<!-- collegamento a css -->
	<link rel="stylesheet" type="text/css" href="/silviaG/phoneBook/css/phoneBook.css">
	<!-- Collegamento a bootstrap -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
         integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
         integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
         crossorigin="anonymous">
    </script>
	
</head>
<body>
	<h1>Rubrica telefonica</h1>
	
	<form action="/silviaG/phone/search">
		<c:if test="${not empty errorSearchMessage}">
			<span>${errorSearchMessage}</span>
		</c:if>
		<div>
			<div class="row mb-3">
				<div class="col-sm-4">
					<input class="form-control" name="string" placeholder="Cerca">
				</div>
				<div class="col-sm-5">
					<button class="btn btn-success" type="submit">Cerca</button>
				</div>
			</div>
		</div>
	</form>
	
	
	<div class="container-fluid"> 
       <table class="table table-striped table-hover table-light">
       <thead>
	         <tr id="first-row">
	              <td scope="row">Nome</td>
	              <td scope="row">Cognome</td>
	              <td scope="row">Numero di telefono</td>
	              <td scope="row"></td>
	         </tr>
        </thead>
        <c:forEach var="contact" items="${contacts}">
			<tr>
				<td>${contact.firstName}</td>
				<td>${contact.lastName}</td>
				<td>${contact.phone}</td>
				<td><a href="/silviaG/phone/delete?id=${contact.id}" type="submit" class="btn btn-success">Elimina</a></td>
			</tr>
		</c:forEach>  
       </table>
    </div>
	
	<form id="inserimento" action="/silviaG/phone/insert">
		<h4>Chi vuoi inserire?</h4>
		<div class="row g-3">
            <div class="col">
                <label class="form-label">Nome</label>
                <input class="form-control" placeholder="Inserisci nome" name="firstName" value="${badContact.firstName}" required>
            </div>
            <div class="col">
                <label class="form-label">Cognome</label>
                <input type="text" class="form-control" placeholder="Inserisci cognome" name="lastName" value="${badContact.lastName}" required>
            </div>
         </div>
         <div class="row g-3" style="padding-top: 25px">
            <div class="col">
                <label for="exampleFormControlInput1" class="form-label">Numero di telefono
                </label>
                <c:if test="${not empty badContact}">
                	<span>non accettabile</span>
                </c:if>
                <input type="text" class="form-control" placeholder="Inserisci numero" name="phone" value="${badContact.phone}" required>
            </div>
         </div>
         
         <div class="bottoni col-12">
             <button class="btn btn-success" type="submit">Invia risposte</button>
         </div>
	</form>
	
</body>
</html>