<%--
  Created by IntelliJ IDEA.
  User: Aleh
  Date: 3/30/2020
  Time: 5:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/login.css">
<html>
<head>
    <title>Menu</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/logout">Log out</a>
<br/><br/>
<p align="center">
    <c:out value="Welcome, ${login}"/>
</p>
<p>
    <a href="${pageContext.request.contextPath}/getAllUserPortfolios">All Portfolios</a>
</p>
</body>
</html>
