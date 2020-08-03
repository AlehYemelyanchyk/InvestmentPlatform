<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="content"/>

<html lang="${cookie['lang'].value}">
<head>
    <title>Update security</title>
</head>
<body>
<div id="container">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form id="form" class="needs-validation form-container" novalidate
                  action="${pageContext.request.contextPath}/updateSecurity" method="POST">

                <div class="form-group">
                    <label for="symbol"><fmt:message key="label.symbol"/>:</label>
                    <input type="text" name="SECURITY_SYMBOL" class="form-control" id="symbol"
                           value="${SECURITY.symbol}"
                           required
                           data-value-missing="Please, enter symbol">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>

                <div class="form-group">
                    <label for="name"><fmt:message key="label.name"/>:</label>
                    <input type="text" name="SECURITY_NAME" class="form-control" id="name"
                           value="${SECURITY.name}"
                           required
                           data-value-missing="Please, enter name">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>

                <div class="form-group">
                    <label for="exchange"><fmt:message key="label.exchange"/>:</label>
                    <select id="exchange" name="SECURITY_EXCHANGE" class="form-control">
                        <c:forEach var="exchange" items="${EXCHANGES_LIST}" varStatus="loop">
                            <option value="${exchange.key}">${exchange.value}</option>
                        </c:forEach>
                    </select>
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>

                <div class="form-group">
                    <label for="currentPrice"><fmt:message key="label.currentPrice"/>: </label>
                    <input type="number" name="CURRENT_PRICE" class="form-control" id="currentPrice"
                           value="<fmt:formatNumber type="number" minFractionDigits="0"
                                           maxFractionDigits="2" value="${SECURITY.currentPrice}"/>"
                           step="0.01"
                           required
                           data-value-missing="Please, enter a value"
                           onkeypress="return isNumber(event)">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>

                <div class="form-group">
                    <label for="yearChangePercents"><fmt:message key="label.yearChange"/>,%: </label>
                    <input type="number" name="YEAR_CHANGE" class="form-control" id="yearChangePercents"
                           value="<fmt:formatNumber type="number" minFractionDigits="0"
                                           maxFractionDigits="2" value="${SECURITY.yearChangePercents}"/>"
                           step="0.01"
                           required
                           data-value-missing="Please, enter a value"
                           onkeypress="return isNumber(event)">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>

                <div class="form-group">
                    <label for="dividends"><fmt:message key="label.dividends"/>: </label>
                    <input type="number" name="DIVIDENDS" class="form-control" id="dividends"
                           value="<fmt:formatNumber type="number" minFractionDigits="0"
                                           maxFractionDigits="2" value="${SECURITY.dividends}"/>"
                           min="0.00"
                           step="0.01"
                           onkeypress="return isNumber(event)">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>

                <div class="form-group">
                    <label for="securityType"><fmt:message key="label.type"/>:</label>
                    <select id="securityType" name="SECURITY_TYPE" class="form-control">
                        <c:forEach var="types" items="${SECURITY_TYPES_LIST}">
                            <option value="${types.key}">${types.value}</option>
                        </c:forEach>
                    </select>
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