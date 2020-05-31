<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>

<html lang="${sessionScope.lang}">
<head>
    <title><fmt:message key="label.transactions"/></title>
</head>
<body>
<div id="wrapper">
    <div id="header">

        <c:url var="securityLink" value="getSecurity">
            <c:param name="SECURITY_SYMBOL" value="${SECURITY_SYMBOL}"/>
        </c:url>

        <h2 align="center"><a href="${securityLink}">${SECURITY_NAME}</a></h2>
    </div>
</div>

<div id="container">
    <div id="content">

        <table>

            <tr>
                <th><fmt:message key="label.type"/></th>
                <th><fmt:message key="label.amount"/></th>
                <th><fmt:message key="label.price"/></th>
                <th><fmt:message key="label.date"/></th>
            </tr>

            <c:forEach var="transaction" items="${SECURITY_TRANSACTIONS}">

                <tr>
                    <td>
                        <c:choose>
                            <c:when test="${transaction.transactionType == 1}"><fmt:message key="label.buy"/></c:when>
                            <c:when test="${transaction.transactionType == 2}"><fmt:message key="label.sell"/></c:when>
                        </c:choose>
                    </td>

                    <td>
                        <c:out value="${transaction.amount}"></c:out>
                    </td>

                    <td>
                        <c:out value="${transaction.price}"></c:out>
                    </td>

                    <td>
                        <c:out value="${transaction.date}"></c:out>
                    </td>

                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
