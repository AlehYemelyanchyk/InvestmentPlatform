<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>

<html lang="${sessionScope.lang}">
<head>
    <title>Update transaction</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2 align="center"><fmt:message key="label.editTransaction"/></h2>
    </div>
</div>

<div id="container">
    <form action="${pageContext.request.contextPath}/updateTransaction" method="POST">
        <tr>
            <td><input type="hidden" name="TRANSACTION_ID" value="${TRANSACTION.id}"></td>
            <td><input type="hidden" name="PORTFOLIO_ID" value="${TRANSACTION.portfolioId}"></td>
            <td><input type="hidden" name="PORTFOLIO_NAME" value="${PORTFOLIO_NAME}"></td>
            <td><input type="hidden" name="SECURITY_SYMBOL" value="${TRANSACTION.securitySymbol}"></td>
        </tr>
        <table>
            <tbody>
            <tr>
                <td><label><fmt:message key="label.type"/>: </label></td>
                <td>
                    <select name="TRANSACTION_TYPE">
                        <c:choose>
                            <c:when test="${TRANSACTION.transactionType == 1}">
                                <option value="1">Buy</option>
                                <option value="2">Sell</option>
                            </c:when>
                            <c:when test="${TRANSACTION.transactionType == 2}">
                                <option value="2">Sell</option>
                                <option value="1">Buy</option>
                            </c:when>
                        </c:choose>
                    </select>
                </td>
            </tr>

            <tr>
                <td><label><fmt:message key="label.amount"/>: </label></td>
                <td><input type="text" name="AMOUNT" value="${TRANSACTION.amount}"></td>
            </tr>

            <tr>
                <td><label><fmt:message key="label.price"/>: </label></td>
                <td><input type="text" name="PRICE" value="${TRANSACTION.price}"></td>
            </tr>

            <tr>
                <td><label><fmt:message key="label.date"/>: </label></td>
                <td><input type="text" name="DATE" value="${TRANSACTION.date}"></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value="<fmt:message key="label.save"/>"
                           class="save" onclick="XSSPrevent()"></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>