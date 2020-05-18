<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Security transactions</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2 align="center">${SECURITY_NAME}</h2>
    </div>
</div>

<div id="container">
    <div id="content">

        <table>

            <tr>
                <th>Type</th>
                <th>Amount</th>
                <th>Price</th>
                <th>Date</th>
            </tr>

            <c:forEach var="transaction" items="${SECURITY_TRANSACTIONS}">

                <tr>
                    <td>
                        <c:choose>
                            <c:when test="${transaction.transactionType == 1}">Buy</c:when>
                            <c:when test="${transaction.transactionType == 2}">Sell</c:when>
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
