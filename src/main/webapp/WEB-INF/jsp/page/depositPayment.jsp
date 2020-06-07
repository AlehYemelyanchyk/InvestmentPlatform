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
            <form accept-charset="UTF-8" action="${pageContext.request.contextPath}/deposit" class="require-validation" data-cc-on-file="false" data-stripe-publishable-key="pk_bQQaTxnaZlzv4FnnuZ28LFHccVSaj" id="payment-form" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="✓" /><input name="_method" type="hidden" value="PUT" /><input name="authenticity_token" type="hidden" value="qLZ9cScer7ZxqulsUWazw4x3cSEzv899SP/7ThPCOV8=" /></div>


                <project-tag:getCurrentDate/>
                <input type="hidden" name="TRANSACTION_TYPE" value="3">

                <div class='form-row'>
                    <div class='col-xs-12 form-group required'>
                        <label><fmt:message key="label.amount"/></label>
                        <input class='form-control' size='4' type='text' name="AMOUNT">
                    </div>
                </div>
                <div class='form-row'>
                    <div class='col-xs-12 form-group required'>
                        <label><fmt:message key="label.nameOnCard"/></label>
                        <input class='form-control' size='4' type='text'>
                    </div>
                </div>
                <div class='form-row'>
                    <div class='col-xs-12 form-group card required'>
                        <label><fmt:message key="label.cardNumber"/></label>
                        <input autocomplete='off' class='form-control card-number' size='20' type='text'>
                    </div>
                </div>
                <div class='form-row'>
                    <div class='col-xs-4 form-group cvc required'>
                        <label class='control-label'>CVC</label>
                        <input autocomplete='off' class='form-control card-cvc' placeholder='ex. 311' size='4' type='text'>
                    </div>
                    <div class='col-xs-4 form-group expiration required'>
                        <label><fmt:message key="label.expiration"/></label>
                        <input class='form-control card-expiry-month' placeholder='MM' size='2' type='text'>
                    </div>
                    <div class='col-xs-4 form-group expiration required'>
                        <label class='control-label'> </label>
                        <input class='form-control card-expiry-year' placeholder='YYYY' size='4' type='text'>
                    </div>
                </div>
                <div class='form-row'>
                    <div class='col-md-12 form-group'>
                        <button class='form-control btn btn-primary submit-button' type='submit'><fmt:message key="label.pay"/></button>
                    </div>
                </div>
<%--                <div class='form-row'>--%>
<%--                    <div class='col-md-12 error form-group hide'>--%>
<%--                        <div class='alert-danger alert'>--%>
<%--                            Please correct the errors and try again.--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
            </form>
        </div>
        <div class='col-md-4'></div>
    </div>
</div>
<%--<script>--%>
<%--    $(function() {--%>
<%--        $('form.require-validation').bind('submit', function(e) {--%>
<%--            var $form         = $(e.target).closest('form'),--%>
<%--                inputSelector = ['input[type=email]', 'input[type=password]',--%>
<%--                    'input[type=text]', 'input[type=file]',--%>
<%--                    'textarea'].join(', '),--%>
<%--                $inputs       = $form.find('.required').find(inputSelector),--%>
<%--                $errorMessage = $form.find('div.error'),--%>
<%--                valid         = true;--%>

<%--            $errorMessage.addClass('hide');--%>
<%--            $('.has-error').removeClass('has-error');--%>
<%--            $inputs.each(function(i, el) {--%>
<%--                var $input = $(el);--%>
<%--                if ($input.val() === '') {--%>
<%--                    $input.parent().addClass('has-error');--%>
<%--                    $errorMessage.removeClass('hide');--%>
<%--                    e.preventDefault(); // cancel on first error--%>
<%--                }--%>
<%--            });--%>
<%--        });--%>
<%--    });--%>

<%--    $(function() {--%>
<%--        var $form = $("#payment-form");--%>

<%--        $form.on('submit', function(e) {--%>
<%--            if (!$form.data('cc-on-file')) {--%>
<%--                e.preventDefault();--%>
<%--                Stripe.setPublishableKey($form.data('stripe-publishable-key'));--%>
<%--                Stripe.createToken({--%>
<%--                    number: $('.card-number').val(),--%>
<%--                    cvc: $('.card-cvc').val(),--%>
<%--                    exp_month: $('.card-expiry-month').val(),--%>
<%--                    exp_year: $('.card-expiry-year').val()--%>
<%--                }, stripeResponseHandler);--%>
<%--            }--%>
<%--        });--%>

<%--        function stripeResponseHandler(status, response) {--%>
<%--            if (response.error) {--%>
<%--                $('.error')--%>
<%--                    .removeClass('hide')--%>
<%--                    .find('.alert')--%>
<%--                    .text(response.error.message);--%>
<%--            } else {--%>
<%--                // token contains id, last4, and card type--%>
<%--                var token = response['id'];--%>
<%--                // insert the token into the form so it gets submitted to the server--%>
<%--                $form.find('input[type=text]').empty();--%>
<%--                $form.append("<input type='hidden' name='reservation[stripe_token]' value='" + token + "'/>");--%>
<%--                $form.get(0).submit();--%>
<%--            }--%>
<%--        }--%>
<%--    })--%>
<%--</script>--%>
</body>
</html>
