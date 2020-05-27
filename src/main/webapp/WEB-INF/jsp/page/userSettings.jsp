<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>

<html lang="${sessionScope.lang}">
<head>
    <title>Settings</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2 align="center"><fmt:message key="label.settings"/></h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <p>
            <a href="${pageContext.request.contextPath}/updateUser"><fmt:message key="label.editPersonalDetails"/></a>
        </p>
        <p>
            <a href="${pageContext.request.contextPath}/getBalance"><fmt:message key="label.balance"/></a>
        </p>
        <p>
            <a href="${pageContext.request.contextPath}/logout"><fmt:message key="label.logOut"/></a>
        </p>
    </div>
</div>
</body>
</html>
