<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="project-tag" uri="/WEB-INF/tags.tld" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>

<html lang="${sessionScope.lang}">
<head>
    <title>Payment</title>
</head>
<body>
<div class="container">
    <div class='row'>
        <div class='col-md-4'></div>
        <div class='col-md-4'>
            <form id="form" class="needs-validation form-container" novalidate
                  action="${pageContext.request.contextPath}/deposit" data-cc-on-file="false"
                  data-stripe-publishable-key="pk_bQQaTxnaZlzv4FnnuZ28LFHccVSaj" id="payment-form" method="POST">

                <project-tag:getCurrentDate/>

                <div>
                    <input type="hidden" name="TRANSACTION_TYPE" value="3">
                    <div class="valid-feedback"></div>
                    <div class="invalid-feedback"></div>
                </div>

                <div class="form-group">
                    <label for="amount"><fmt:message key="label.amount"/>: </label>
                    <input type="number" name="AMOUNT" min="1" step="1" class="form-control" id="amount"
                           required
                           data-value-missing="Please, enter amount"
                           onkeypress="return isNumber(event)">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>
                <div class='form-row'>
                    <div class='col-xs-12 form-group'>
                        <label><fmt:message key="label.nameOnCard"/></label>
                        <input class='form-control' size='4' type='text'>
                        <div class="valid-feedback"></div>
                        <div class="invalid-feedback"></div>
                    </div>
                </div>
                <div class='form-row'>
                    <div class='col-xs-12 form-group card required'>
                        <label><fmt:message key="label.cardNumber"/></label>
                        <input autocomplete='off' class='form-control card-number' size='20' type='text'>
                        <div class="valid-feedback"></div>
                        <div class="invalid-feedback"></div>
                    </div>
                </div>
                <div class='form-row'>
                    <div class='col-xs-4 form-group cvc required'>
                        <label class='control-label'>CVC</label>
                        <input autocomplete='off' class='form-control card-cvc' placeholder='ex. 311' size='4' type='text'>
                        <div class="valid-feedback"></div>
                        <div class="invalid-feedback"></div>
                    </div>
                    <div class='col-xs-4 form-group expiration required'>
                        <label><fmt:message key="label.expiration"/></label>
                        <input class='form-control card-expiry-month' placeholder='MM' size='2' type='text'>
                        <div class="valid-feedback"></div>
                        <div class="invalid-feedback"></div>
                    </div>
                    <div class='col-xs-4 form-group expiration required'>
                        <label class='control-label'> </label>
                        <input class='form-control card-expiry-year' placeholder='YYYY' size='4' type='text'>
                        <div class="valid-feedback"></div>
                        <div class="invalid-feedback"></div>
                    </div>
                </div>
                <button onclick="XSSPrevent()" type="submit" class="btn btn-primary btn-block"><fmt:message
                        key="label.submit"/>
                </button>
            </form>
        </div>
        <div class='col-md-4'></div>
    </div>
</div>
</body>
</html>
