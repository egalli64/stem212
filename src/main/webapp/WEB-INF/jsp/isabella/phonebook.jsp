    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/isabella/css/isabella.css">
<title>Agenda telefonica</title>
</head>
<body>
<div class="container-fluid">
<h1 class="mx-auto text-center">AGENDA TELEFONICA</h1>
<table class="table table-dark table-striped table-bordered table-sm">
			<tr>
				<th>Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Phone number</th>
                <th>Delete</th>
            </tr>
        <c:forEach var="contact" items="${contacts}">
            <tr>
            	<td>${contact.id}</td>
                <td>${contact.firstName}</td>
                <td>${contact.lastName}</td>
                <td>${contact.phone}</td>
                <td><a href="/isabella/phone/delete?id=${contact.id}"><button class="btn btn-primary">Elimina</button></a></td>
            </tr>
        </c:forEach>
    </table>
    <hr>
    <h4 class="fw-bold">Inserisci contatto</h4>
    <form method="get" action="/isabella/phone/insert">
    <div class="form-group"> 
          <label for="exampleFormControlInput1" class="form-label">Nome:</label>
          <input type="text" class="bg-primary text-white p-1.8 w-20"name="firstName" value="${badContact.firstName}"> 
          <label for="exampleFormControlInput1" class="form-label">Cognome:</label>
          <input type="text" class="bg-primary text-white p-1.8 w-20" name="lastName" value="${badContact.lastName}">
          <label for="exampleFormControlInput1" class="form-label">Numero di telefono:</label>
          <input type="text" class="bg-primary text-white p-1.8 w-20" name="phone" value="${badContact.phone}">
          <p><c:if test="${not empty badContact}"> <span class="p-3 mb-2 text-danger">Contatto non accettabile!</span></c:if></p>
            </div>
       <button class="btn btn-primary">Inserisci</button> <hr>
     </form>
    </div>
</body>
</html>