<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Application</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <div id="wrapper">
        <div id="header">
            <h1 align="center">Investment Platform</h1>
        </div>
        <div>
            <p align="right">
                <c:if test="${login != null}">
                    <c:out value="Welcome, ${login}! "/>
                    <a href="${pageContext.request.contextPath}/logout">Log out</a>
                </c:if>
            </p>
            <p align="center">
            <h3 align="center">
                <a href="signup">Sign Up</a> | <a href="login">Log In</a>
            </h3>
            </p>
        <br/><br/>
    </div>
</head>
</html>
