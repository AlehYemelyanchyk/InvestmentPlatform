<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="project-tag" uri="/WEB-INF/tags.tld" %>
<jsp:useBean id="currentDate" class="java.util.Date"/>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>

<html lang="${sessionScope.lang}">
<head>
    <title>Add security to portfolio</title>
</head>

<body>
<div id="container">
    <br/>

    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form id="form" class="needs-validation" novalidate
                  action="${pageContext.request.contextPath}/addSecurityToPortfolio" method="POST">

                <project-tag:getCurrentDate/>

                <div>
                    <input type="hidden" name="SECURITY_SYMBOL" value="${SECURITY_SYMBOL}">
                    <div class="valid-feedback"></div>
                    <div class="invalid-feedback"></div>
                </div>
                <div>
                    <input type="hidden" name="SECURITY_PRICE" value="${SECURITY_PRICE}">
                    <div class="valid-feedback"></div>
                    <div class="invalid-feedback"></div>
                </div>
                <div class="form-group">
                    <label for="symbol"><fmt:message key="label.symbol"/>: </label>
                    <input disabled type="text" name="SYMBOL" class="form-control" id="symbol"
                           value="${SECURITY_SYMBOL}"
                           required
                           data-value-missing="Please, enter symbol">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>
                <div class="form-group">
                    <label for="portfolioId"><fmt:message key="label.portfolio"/>:</label>
                    <select id="portfolioId" name="PORTFOLIO_ID" class="form-control">
                        <c:forEach var="portfolio" items="${PORTFOLIOS_LIST}">
                            <option value="${portfolio.id}">${portfolio.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="transactionType"><fmt:message key="label.type"/>:</label>
                    <select id="transactionType" name="TRANSACTION_TYPE" class="form-control">
                        <option value="1"><fmt:message key="label.buy"/></option>
                        <option value="2"><fmt:message key="label.sell"/></option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="amount"><fmt:message key="label.amount"/>: </label>
                    <input type="text" name="AMOUNT" class="form-control" id="amount"
                           required
                           data-value-missing="Please, enter amount"
                           onkeypress="return isNumber(event)">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>
                <div class="form-group">
                    <label for="price"><fmt:message key="label.price"/>: </label>
                    <input type="text" name="PRICE" class="form-control" id="price"
                           value="${SECURITY_PRICE}"
                           required
                           data-value-missing="Please, enter price"
                           onkeypress="return isDecimalNumber(event)">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>
                <div class="form-group">
                    <label for="date"><fmt:message key="label.date"/>: </label>
                    <input type="date" name="DATE" class="form-control" id="date"
                           value="${DATE}"
                           min="1970-01-01" max="2099-12-31"
                           required
                           data-value-missing="Please, enter date">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>
                <button onclick="XSSPrevent()" type="submit" class="btn btn-primary"><fmt:message
                        key="label.submit"/>
                </button>
            </form>
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