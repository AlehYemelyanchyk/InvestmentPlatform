<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>All securities</title>
    <link href="static/css/bootstrap.min.css" rel="stylesheet"/>
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h2 align="center">Balance</h2>
    </div>
</div>

<div class="container">
    <p>
        <c:set var="balance" value="${CURRENT_USER_BALANCE}"/>$
        <fmt:formatNumber type="number" minFractionDigits="2"
                          maxFractionDigits="2" value="${balance}"/>
    </p>
    <a href="${pageContext.request.contextPath}/deposite">
        Deposite
    </a>
    <a href="${pageContext.request.contextPath}/withdraw">
        Withdraw
    </a>
    <a href="${pageContext.request.contextPath}/loan">
        Loan
    </a>
</div>
</body>
</html>
