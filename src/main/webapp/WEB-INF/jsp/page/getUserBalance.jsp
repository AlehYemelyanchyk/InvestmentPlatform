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
<%--<div id="header">--%>
<%--    <h4 align="center"><fmt:message key="label.balance"/></h4>--%>
<%--</div>--%>
<div class="panel-body">
    <div class="list-group">
        <p class="list-group-item">
            <c:set var="balance" value="${CURRENT_USER_BALANCE}"/>$
            <fmt:formatNumber type="number" minFractionDigits="2"
                              maxFractionDigits="2" value="${balance}"/>
        </p>

        <a href="${pageContext.request.contextPath}/deposit" class="list-group-item">
            <fmt:message key="label.deposit"/>
        </a>

        <c:choose>
        <c:when test="${CURRENT_USER_BALANCE <= 0}">
        <a hidden href="${pageContext.request.contextPath}/withdraw" class="list-group-item">
            </c:when>

            <c:otherwise>
            <a href="${pageContext.request.contextPath}/withdraw" class="list-group-item">
                <fmt:message key="label.withdraw"/>
            </a>
            </c:otherwise>
            </c:choose>

            <a href="${pageContext.request.contextPath}/loan" class="list-group-item">
                <fmt:message key="label.loan"/>
            </a>
    </div>
</div>
</body>
</html>
