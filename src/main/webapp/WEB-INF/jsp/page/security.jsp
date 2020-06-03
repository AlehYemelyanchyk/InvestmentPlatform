<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>

<html lang="${sessionScope.lang}">
<head>
    <title>Security</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2 align="center">${SECURITY.name}</h2>
    </div>
</div>
<div id="container">
    <form action="${pageContext.request.contextPath}/signup" method="post">
        <table style="with: 50%">
            <thead>
            <tr>
                <th><fmt:message key="label.symbol"/></th>
                <th><fmt:message key="label.name"/></th>
                <th><fmt:message key="label.exchange"/></th>
                <th><fmt:message key="label.currentPrice"/></th>
                <th><fmt:message key="label.yearChange"/>, %</th>
                <th><fmt:message key="label.dividends"/></th>
                <th><fmt:message key="label.type"/></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    <c:out value="${SECURITY.symbol}"></c:out>
                </td>

                <td>
                    <c:out value="${SECURITY.name}"></c:out>
                </td>

                <td>
                    <c:out value="${SECURITY.exchange}"></c:out>
                </td>

                <td>
                    <c:out value="${SECURITY.currentPrice}"></c:out>
                </td>

                <td>
                    <c:out value="${SECURITY.yearChangePercents}"></c:out>
                </td>

                <td>
                    <c:out value="${SECURITY.dividends}"></c:out>
                </td>

                <td>
                    <c:out value="${SECURITY.securityType}"></c:out>
                </td>
            </tr>
            </tbody>
        </table>
        <div align="center">
            <img src="${pageContext.request.contextPath}/media/chart01.jpg">
        </div>
    </form>
</div>
</body>

</html>