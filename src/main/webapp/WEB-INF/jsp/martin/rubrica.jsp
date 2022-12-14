<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>rubrica</title>
</head>
<body>
    <table>
       <tr>
       		<td>id</td>
            <td>firstName</td>
            <td>lastName</td>
            <td>number</td>
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
    <form action="/martin/phone/insert">
	<label><input name="firstName" placeholder="firstName" autofocus></label>
	<label><input name="lastName" placeholder="firstName" autofocus></label>
	<label><input name="phone" placeholder="phone" autofocus></label>
	<button>insert</button>
</form>

<form action="/martin/phone/delete" >
	<label><input name="id" placeholder="id" autofocus></label>

	<button>delete</button>
</form>
</body>
</html>