<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="date" uri="/WEB-INF/tags.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="currentDate" class="java.util.Date" />
<html>
<head>
    <title>Add security to portfolio</title>
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h2 align="center">Add security</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <form action="${pageContext.request.contextPath}/addSecurityToPortfolio" method="post">
            <table>
                <tbody>

                <tr>
                    <td><input type="hidden" name="SECURITY_SYMBOL" value="${SECURITY_SYMBOL}"></td>
                    <td><input type="hidden" name="SECURITY_PRICE" value="${SECURITY_PRICE}"></td>
                </tr>

                <tr>
                    <td>Portfolio:</td>
                    <td>
                        <select name="PORTFOLIO_ID">
                            <c:forEach var="portfolio" items="${PORTFOLIOS_LIST}">
                                <option value="${portfolio.id}">${portfolio.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td>Type:</td>
                    <td>
                        <select name="TRANSACTION_TYPE">
                            <option value="1">Buy</option>
                            <option value="2">Sell</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td><label>Amount: </label></td>
                    <td><input type="text" name="AMOUNT" onkeypress="return isNumber(event)"></td>
                </tr>

                <tr>
                    <td><label>Price: </label></td>
                    <td><input type="text" name="PRICE"
                               value="${SECURITY_PRICE}"
                               onkeypress="return isDecimalNumber(event)"></td>
                </tr>

                <tr>
                    <td><label>Date: </label></td>
<%--                    <date:static var="currentDate">--%>
                    <td><input type="date" name="DATE"
<%--                               value="currentDate"--%>
                               min="1970-01-01" max="2099-12-31">
                    </td>
                </tr>

                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Add" class="save"></td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>
</div>
<script>
    function isNumber(event) {
        var keycode = event.keyCode;
        return keycode > 47 && keycode < 58;

    }

    function isDecimalNumber(event) {
        var keycode = event.keyCode;
        return keycode > 47 && keycode < 58 || keycode === 46;
    }
</script>
</body>
</html>