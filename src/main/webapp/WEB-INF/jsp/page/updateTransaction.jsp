<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="project-tag" uri="/WEB-INF/tags.tld" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>

<html lang="${sessionScope.lang}">
<head>
    <title>Update transaction</title>
</head>
<body>
<div id="container">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form id="form" class="needs-validation form-container" novalidate
                  action="${pageContext.request.contextPath}/updateTransaction" method="POST">

                <project-tag:getCurrentDate/>

                <div>
                    <input type="hidden" name="TRANSACTION_ID" value="${TRANSACTION.id}">
                    <div class="valid-feedback"></div>
                    <div class="invalid-feedback"></div>
                </div>
                <div>
                    <input type="hidden" name="SECURITY_SYMBOL" value="${TRANSACTION.securitySymbol}">
                    <div class="valid-feedback"></div>
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
                    <label for="type"><fmt:message key="label.type"/>: </label>
                    <select name="TRANSACTION_TYPE" class="form-control" id="type">
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
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>

                <div class="form-group">
                    <label for="amount"><fmt:message key="label.amount"/>: </label>
                    <input type="number" name="AMOUNT" class="form-control" id="amount"
                           value="${TRANSACTION.amount}"
                           required
                           min="1"
                           data-value-missing="Please, enter amount"
                           onkeypress="return isNumber(event)">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>

                <div class="form-group">
                    <label for="price"><fmt:message key="label.price"/>: </label>
                    <input type="text" name="PRICE" class="form-control" id="price"
                           value="<fmt:formatNumber type="number" minFractionDigits="0"
                                           maxFractionDigits="2" value="${TRANSACTION.price}"/>"
                           required
                           data-value-missing="Please, enter price"
                           onkeypress="return isDecimalNumber(event)">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>

                <div class="form-group">
                    <label for="date"><fmt:message key="label.date"/>: </label>
                    <input type="date" name="DATE" class="form-control" id="date"
                           value="${TRANSACTION.date}"
                           min="1970-01-01" max="${DATE}"
                           required
                           data-value-missing="Please, enter date">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>

                <button onclick="XSSPrevent()" type="submit" class="btn btn-primary btn-block"><fmt:message
                        key="label.submit"/>
                </button>
            </form>
        </div>
    </div>
</div>
</body>
</html>