<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div id="wrapper">
    <div id="header">
        <h2 align="center">Edit transaction</h2>
    </div>
</div>

<div id="container">
    <form action="${pageContext.request.contextPath}/updateTransaction" method="POST">
        <tr>
            <td><input type="hidden" name="TRANSACTION_ID" value="${TRANSACTION.id}"></td>
            <td><input type="hidden" name="PORTFOLIO_ID" value="${TRANSACTION.portfolioId}"></td>
            <td><input type="hidden" name="SECURITY_SYMBOL" value="${TRANSACTION.securitySymbol}"></td>
        </tr>
        <table>
            <tbody>
            <tr>
                <td><label>Type: </label></td>
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
                <td><label>Amount: </label></td>
                <td><input type="text" name="AMOUNT" value="${TRANSACTION.amount}"></td>
            </tr>

            <tr>
                <td><label>Price: </label></td>
                <td><input type="text" name="PRICE" value="${TRANSACTION.price}"></td>
            </tr>

            <tr>
                <td><label>Date: </label></td>
                <td><input type="text" name="DATE" value="${TRANSACTION.date}"></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>