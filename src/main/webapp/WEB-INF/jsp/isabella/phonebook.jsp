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
                <th>First Name</th>
                <th>Last Name</th>
                <th>Phone number</th>
            </tr>
        <c:forEach var="contact" items="${contacts}">
            <tr>
                <td>${contact.firstName}</td>
                <td>${contact.lastName}</td>
                 <td>${contact.number}</td>
            </tr>
        </c:forEach>
    </table>
    <hr>
    <form method="post" action="/PhoneCtr">
    <p>Nome: <input type="text" name="name"><p/>
     <p>Cognome: <input type="text" name="last name"><p/>
      <p>Numero: <input type="text" name="number"><p/>
      <hr>
       <button>Invia</button>
    </form>
</body>
</html>