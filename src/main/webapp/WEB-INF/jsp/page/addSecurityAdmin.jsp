<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="content"/>

<html lang="${cookie['lang'].value}">
<head>
    <title>Add Security</title>
</head>
<body>
<div id="container">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form id="form" class="needs-validation form-container" novalidate
                  action="${pageContext.request.contextPath}/addSecurityAdmin"
                  method="POST">
                <div class="form-group">
                    <label for="symbol"><fmt:message key="label.symbol"/></label>
                    <input type="text" name="SECURITY_SYMBOL" class="form-control" id="symbol"
                           placeholder="<fmt:message key="label.symbol"/>"
                           required
                           data-value-missing="Please, enter symbol">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>

                <div class="form-group">
                    <label for="name"><fmt:message key="label.name"/></label>
                    <input type="text" name="SECURITY_NAME" class="form-control" id="name"
                           placeholder="<fmt:message key="label.name"/>"
                           required
                           data-value-missing="Please, enter name">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>

                <div class="form-group">
                    <label for="exchange"><fmt:message key="label.exchange"/></label>
                    <select id="exchange" name="SECURITY_EXCHANGE" class="form-control">
                        <option value="1">Bitfinex</option>
                        <option value="2">NASDAQ</option>
                        <option value="3">NYSE</option>
                        <option value="4">OTC Markets</option>
                    </select>
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>

                <div class="form-group">
                    <label for="price"><fmt:message key="label.price"/>: </label>
                    <input type="number" name="SECURITY_PRICE" step="0.01" class="form-control" id="price"
                           required
                           data-value-missing="Please, enter amount"
                           onkeypress="return isNumber(event)">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>

                <div class="form-group">
                    <label for="yearChange"><fmt:message key="label.yearChange"/>, %: </label>
                    <input type="number" name="SECURITY_YEAR_CHANGE" step="0.01" class="form-control" id="yearChange"
                           required
                           data-value-missing="Please, enter amount"
                           onkeypress="return isNumber(event)">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>

                <div class="form-group">
                    <label for="dividends"><fmt:message key="label.dividends"/>: </label>
                    <input type="number" name="SECURITY_DIVIDENDS" min="0" step="0.01" class="form-control"
                           id="dividends"
                           required
                           data-value-missing="Please, enter amount"
                           onkeypress="return isNumber(event)">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>

                <div class="form-group">
                    <label for="type"><fmt:message key="label.type"/></label>
                    <select id="type" name="SECURITY_TYPE" class="form-control">
                        <option value="1">Bond</option>
                        <option value="2">Cryptocurrency</option>
                        <option value="3">ETF</option>
                        <option value="4">Fund</option>
                        <option value="5">Stock</option>
                    </select>
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>

                <button onclick="XSSPrevent()" type="submit" class="btn btn-primary btn-block"><fmt:message
                        key="label.submit"/>
                </button>
            </form>
        </div>
        <div class="col-md-4"></div>
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