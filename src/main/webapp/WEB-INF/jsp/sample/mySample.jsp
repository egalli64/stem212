<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A sample JSP</title>
<link rel="stylesheet" href="/sample/css/sample.css">
</head>
<body class="${empty warnLevel ? '' : warnLevel}">
    <h1>The generated response</h1>
</body>
</html>