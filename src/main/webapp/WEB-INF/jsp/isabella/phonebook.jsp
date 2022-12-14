    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda telefonica</title>
</head>
<body>
<h1>Agenda telefonica</h1>
<table>
			<tr>
				<th>Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Phone number</th>
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
    <hr>Inserisci contatto
    <form method="get" action="/isabella/phone/insert">
    	<p>Nome: <input type="text" name="firstName"><p/>
     	<p>Cognome: <input type="text" name="lastName"><p/>
     	<p>Numero: <input type="text" name="phone"><p/>
       <button>Inserisci</button> <hr>
     </form>
     Elimina contatto 
  	<form method="get" action="/isabella/phone/delete">
    <p>Id: <input type="number" name="id"><p/>
	<button>Elimina</button>
       <hr>   
    </form>
</body>
</html>