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
<div class="container-bordered">
    <div id="header">

        <c:url var="securityLink" value="getSecurity">
            <c:param name="SECURITY_SYMBOL" value="${SECURITY_SYMBOL}"/>
        </c:url>

        <h4 align="center"><a href="${securityLink}">${SECURITY_NAME}</a></h4>
    </div>

    <div id="container">
        <div id="content">

            <table>

                <tr>
                    <th><fmt:message key="label.type"/></th>
                    <th><fmt:message key="label.amount"/></th>
                    <th><fmt:message key="label.price"/></th>
                    <th><fmt:message key="label.date"/></th>
                    <th></th>
                    <th></th>
                </tr>

                <c:forEach var="transaction" items="${SECURITY_TRANSACTIONS}">

                    <tr>
                        <td>
                            <c:choose>
                                <c:when test="${transaction.transactionType == 1}"><fmt:message
                                        key="label.buy"/></c:when>
                                <c:when test="${transaction.transactionType == 2}"><fmt:message
                                        key="label.sell"/></c:when>
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

                        <td>
                            <form action="${pageContext.request.contextPath}/updateTransactionWindow" method="POST">
                                <input type="hidden" name="TRANSACTION_ID" value="${transaction.id}">
                                <input type="hidden" name="PORTFOLIO_NAME" value="${PORTFOLIO_NAME}">
                                <button class="btn btn-link" type="submit"
                                        data-tooltip title="<fmt:message key="label.edit"/>">
                                    <i class="icon-edit"></i>
                                </button>
                            </form>
                        </td>

                        <td>
                            <form id="formRemove${transaction.id}" action="${pageContext.request.contextPath}/removeTransaction" method="POST">
                                <input type="hidden" name="TRANSACTION_ID" value="${transaction.id}">
                                <input type="hidden" name="PORTFOLIO_NAME" value="${PORTFOLIO_NAME}">
                                <button class="btn btn-link" type="submit"
                                        data-tooltip title="<fmt:message key="label.delete"/>"
                                        onclick="deleteTransaction('${transaction.id}')">
                                    <i class="icon-trash"></i>
                                </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<script src="static/js/deleteTransaction.js"></script>
<script src="static/js/deleteSecurity.js"></script>
</body>
</html>
