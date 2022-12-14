<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>rubrica</title>
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
        integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
   <link rel="stylesheet" type="text/css" href="/martin/css/rubrica.css"> 
</head>
<body>
<div class="container-fluid">
<h1> Rubrica</h1>
<hr>
	
    <table class="table table-striped">
       <tr>
       		<td scope="col"><b>id</b></td>
            <td scope="col"><b>firstName</b></td>
            <td scope="col"><b>lastName</b></td>
            <td scope="col"><b>number</b></td>
            <td scope="col"><b>delete</b></td>
       </tr>
       <c:forEach var="contact" items="${contacts}">
            <tr>
            	<td>${contact.id}</td>
                <td>${contact.firstName}</td>
                <td>${contact.lastName}</td>
                <td>${contact.phone}</td>
                <td><a href="/martin/phone/delete?id=${contact.id}"><button style="border-radius:10px">delete</button></a></td>
            </tr>
        </c:forEach>
    </table>
   
   <hr> 
    <h2> Insert new contact</h2>
   		 <c:if test="${not empty errorInsert}">
			<p class="color">${errorInsert}</p>
		 </c:if>
		 <c:if test="${not empty numExist}">
			<p class="color">${numExist}</p>
		  </c:if>
    <form action="/martin/phone/insert">
		<label><input name="firstName" placeholder="firstName" autofocus></label>
		<label><input name="lastName" placeholder="firstName" autofocus></label>
		<label><input name="phone" placeholder="phone" autofocus></label>
		<button style="border-radius:10px">insert</button>
	</form>
			
	<hr>
	<h2> Delete contact by id</h2>
		<c:if test="${not empty errorDelete}">
			<p class="color">${errorDelete}</p>
		</c:if>
	<form action="/martin/phone/delete" >
		<label><input name="id" placeholder="id" autofocus></label>
		<button style="border-radius:10px">delete</button>
	</form>
	 <hr> 
	 </div>
</body>
</html>