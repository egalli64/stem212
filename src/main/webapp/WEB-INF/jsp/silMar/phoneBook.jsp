<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/silMar/css/phoneSilMar.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
        integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<title>Phonebook</title>
</head>
<body  id="body">
	<div class="container-fluid">
	 <div class="row">
		<div class="offset-4 col-2" style="padding-top: 5px;">
			<figure>
            	<img src="/silMar/pic/icoContacts.png" title="Fixed size" width="150px" alt="a photo">
   			</figure>
   		</div>
<!--    		<div class="col-3" style="padding-top: 62px;"> -->
<!-- 			<h2 id="title" style="padding-left: 15px;">PHONEBOOK</h2> -->
<!-- 		</div> -->
	</div>
	<form action="/silMar/phone/search">
		<c:if test="${not empty errorSearchMessage}">
			<span>${errorSearchMessage}</span>
		</c:if>
		<div>
			<div class="row mb-3">
				<div class="col-sm-4">
					<input name="string">
					<input type="submit" value="Search">
				</div>
			</div>
		</div>
	</form>
	
	<table class="table table-striped table-hover table-light">
	<thead>
		<tr id="first-row" class="table">
			<td scope="row" style="padding-left: 20px;">Id</td>
			<td scope="row" style="padding-left: 20px;">First name</td>
			<td scope="row" style="padding-left: 20px;">Last name</td>
			<td scope="row" style="padding-left: 20px;">Phone number</td>
		</tr>
		</thead>
		<c:forEach var="contact" items="${contacts}">
			<tr>
				<td style="padding-left: 20px;">${contact.id}</td>
				<td style="padding-left: 20px;">${contact.firstName}</td>
				<td style="padding-left: 20px;">${contact.lastName}</td>
				<td style="padding-left: 20px;">${contact.phone}</td>
				<td><a href="/silMar/phone/remove?id=${contact.id}"><img src="/silMar/pic/basket.PNG" alt="remove" width="15"></a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<form method="get" action="/silMar/phone/insert">
			<h4>Insert New Contact here:</h4>
			<p>
			
			<input required type="text" name="firstName" placeholder="First name" value="${badContact.firstName}">
			<input required type="text" name="lastName" placeholder="Last name" value="${badContact.lastName}">
			<input required type="text" name="phone" placeholder="Phone number" value="${badContact.phone}">
			<input type="submit" value="Insert">
			<br>
			<p>
			<c:if test="${not empty badContact}">
				<h6><span id="error">Not acceptable</span></h6>
			</c:if>
			</p>
	</form>
<!-- 	<form method="get" action="/silMar/phone/remove"> -->
<!-- 			<h4>Remove Contact here:</h4> -->
<!-- 			<p> -->
<%-- 			Id:<input type="number" name="id" value="${badId}"> --%>
<!-- 			<input type="submit" value="Remove"> -->
<%-- 			<c:if test="${not empty badId}"> --%>
<!-- 				<h6><span id="error">Not acceptable</span></h6> -->
<%-- 			</c:if> --%>
<!-- 			</p> -->
<!-- 	</form> -->
</div>
</body>
</html>