<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>

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
    </div>
    <br/><br/>
</div>