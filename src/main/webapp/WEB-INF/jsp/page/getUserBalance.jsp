<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>

<html lang="${sessionScope.lang}">
<head>
    <title>All securities</title>
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h2 align="center"><fmt:message key="label.balance"/></h2>
    </div>
</div>

<div class="container">
    <p>
        <c:set var="balance" value="${CURRENT_USER_BALANCE}"/>$
        <fmt:formatNumber type="number" minFractionDigits="2"
                          maxFractionDigits="2" value="${balance}"/>
    </p>
    <a href="${pageContext.request.contextPath}/deposite">
        <fmt:message key="label.deposit"/>
    </a>
    <a href="${pageContext.request.contextPath}/withdraw">
        <fmt:message key="label.withdraw"/>
    </a>
    <a href="${pageContext.request.contextPath}/loan">
        <fmt:message key="label.loan"/>
    </a>
</div>
</body>
</html>
