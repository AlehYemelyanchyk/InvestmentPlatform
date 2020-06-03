<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>

<html lang="${sessionScope.lang}">
<head>
    <title>Portfolio securities</title>
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h2 align="center">${PORTFOLIO_NAME}</h2>
    </div>
</div>

<div id="container">
    <div id="content">

<%--        <div class="autocomplete">--%>
<%--            <input type="text" placeholder="<fmt:message key="label.findSecurity"/>">--%>
<%--            <span class="close"><fmt:message key="label.cancel"/></span>--%>
<%--            <div class="dialog">--%>
<%--            </div>--%>
<%--        </div>--%>

        <div class="tabs_names">
            <li data-tab-target="#holdings" class="active tab"><fmt:message key="label.holdings"/></li>
            <li data-tab-target="#transactions" class="tab"><fmt:message key="label.transactions"/></li>
        </div>

        <div class="tabs_content table-bordered table-striped">
            <div id="holdings" data-tab-content class="active">
                <table>
                    <tr>
                        <th><fmt:message key="label.symbol"/></th>
                        <th><fmt:message key="label.name"/></th>
                        <th><fmt:message key="label.exchange"/></th>
                        <th><fmt:message key="label.amount"/></th>
                        <th><fmt:message key="label.averagePrice"/></th>
                        <th><fmt:message key="label.yearChange"/>, %</th>
                        <th><fmt:message key="label.type"/></th>
                        <th></th>
                    </tr>

                    <p>
                        <c:forEach var="security" items="${PORTFOLIO_SECURITIES}">
                            <c:url var="securityLink" value="getAllSecurityTransactions">
                                <c:param name="PORTFOLIO_ID" value="${PORTFOLIO_ID}"/>
                                <c:param name="SECURITY_NAME" value="${security.value.name}"/>
                                <c:param name="SECURITY_SYMBOL" value="${security.key}"/>
                            </c:url>

                            <tr>
                                <td>
                                    <a href="${securityLink}">${security.key}</a>
                                </td>

                                <td>
                                    <a href="${securityLink}">${security.value.name}</a>
                                </td>

                                <td>
                                    <c:out value="${security.value.exchange}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.value.amount}"></c:out>
                                </td>

                                <td>
                                    <c:set var="averagePrice" value="${security.value.averagePrice}"/>
                                    <fmt:formatNumber type="number" minFractionDigits="2"
                                                      maxFractionDigits="2" value="${averagePrice}"/>
                                </td>

                                <td>
                                    <c:set var="yearChangePercents" value="${security.value.yearChangePercents}"/>
                                    <fmt:formatNumber type="number" minFractionDigits="2"
                                                      maxFractionDigits="2" value="${yearChangePercents}"/>
                                </td>

                                <td>
                                    <c:out value="${security.value.securityType}"></c:out>
                                </td>

                                <td>
                                    <form action="removeSecurityFromPortfolio" method="POST">
                                        <input type="hidden" name="SECURITY_SYMBOL" value="${security.value.symbol}">
                                        <input type="hidden" name="PORTFOLIO_ID" value="${PORTFOLIO_ID}">
                                        <input type="submit" class="short-button"
                                               onclick="if (!(confirm('<fmt:message
                                                       key="label.deleteSecurityWarning"/>'))) return false"
                                               name="submit" value="<fmt:message key="label.delete"/>">
                                    </form>
                                </td>

                            </tr>
                        </c:forEach>
                    </p>
                </table>
            </div>
            <div id="transactions" data-tab-content>
                <table>
                    <tr>
                        <th><fmt:message key="label.symbol"/></th>
                        <th><fmt:message key="label.type"/></th>
                        <th><fmt:message key="label.amount"/></th>
                        <th><fmt:message key="label.price"/></th>
                        <th><fmt:message key="label.date"/></th>
                        <th></th>
                        <th></th>
                    </tr>

                    <p>
                        <c:forEach var="transaction" items="${PORTFOLIO_TRANSACTIONS}">
                            <tr>
                                <td>
                                    <c:out value="${transaction.securitySymbol}"></c:out>
                                </td>

                                <td>
                                    <c:choose>
                                        <c:when test="${transaction.transactionType == 1}">
                                            <fmt:message key="label.buy"/>
                                        </c:when>
                                        <c:when test="${transaction.transactionType == 2}">
                                            <fmt:message key="label.sell"/>
                                        </c:when>
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
                                    <form action="updateTransaction" method="GET">
                                        <input type="hidden" name="TRANSACTION_ID" value="${transaction.id}">
                                        <input type="hidden" name="PORTFOLIO_NAME" value="${PORTFOLIO_NAME}">
                                        <input type="submit" class="short-button"
                                               name="submit" value="<fmt:message key="label.edit"/>">
                                    </form>
                                </td>

                                <td>
                                    <form action="removeTransaction" method="POST">
                                        <input type="hidden" name="TRANSACTION_ID" value="${transaction.id}">
                                        <input type="hidden" name="PORTFOLIO_NAME" value="${PORTFOLIO_NAME}">
                                        <input type="submit" class="short-button"
                                               onclick="if (!(confirm('<fmt:message
                                                       key="label.deleteTransactionWarning"/>'))) return false"
                                               name="submit" value="<fmt:message key="label.delete"/>">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </p>
                </table>
            </div>
        </div>
    </div>
</div>
<%--<script>--%>
<%--    // search form script--%>
<%--    $(function () {--%>
<%--        var alreadyFilled = false;--%>
<%--        var securities = new Array()--%>

<%--        <c:forEach var="security" items="${PORTFOLIO_SECURITIES}">--%>
<%--        <c:url var="securityLink" value="addSecurity">--%>
<%--        <c:param name="SECURITY" value="${security}"/>--%>
<%--        </c:url>--%>
<%--        securities.push(--%>
<%--            "${security.value.symbol}" + "   " +--%>
<%--            "${security.value.name}" + "   " +--%>
<%--            "${security.value.exchange}");--%>
<%--        </c:forEach>--%>

<%--        function initDialog() {--%>
<%--            clearDialog();--%>
<%--            for (var i = 0; i < securities.length; i++) {--%>
<%--                $('.dialog').append('<div>' + securities[i] + '</div>');--%>
<%--            }--%>
<%--        }--%>

<%--        function clearDialog() {--%>
<%--            $('.dialog').empty();--%>
<%--        }--%>

<%--        $('.autocomplete input').click(function () {--%>
<%--            if (!alreadyFilled) {--%>
<%--                $('.dialog').addClass('open');--%>
<%--            }--%>

<%--        });--%>
<%--        $('body').on('click', '.dialog > div', function () {--%>
<%--            $('.autocomplete input').val($(this).text()).focus();--%>
<%--            $('.autocomplete .close').addClass('visible');--%>
<%--            alreadyFilled = true;--%>
<%--        });--%>
<%--        $('.autocomplete .close').click(function () {--%>
<%--            alreadyFilled = false;--%>
<%--            $('.dialog').addClass('open');--%>
<%--            $('.autocomplete input').val('').focus();--%>
<%--            $(this).removeClass('visible');--%>
<%--        });--%>

<%--        function match(str) {--%>
<%--            str = str.toLowerCase();--%>
<%--            clearDialog();--%>
<%--            for (var i = 0; i < securities.length; i++) {--%>
<%--                if (securities[i].toLowerCase().startsWith(str)) {--%>
<%--                    $('.dialog').append('<div>' + securities[i] + '</div>');--%>
<%--                }--%>
<%--            }--%>
<%--        }--%>

<%--        $('.autocomplete input').on('input', function () {--%>
<%--            $('.dialog').addClass('open');--%>
<%--            alreadyFilled = false;--%>
<%--            match($(this).val());--%>
<%--        });--%>
<%--        $('body').click(function (e) {--%>
<%--            if (!$(e.target).is("input, .close")) {--%>
<%--                $('.dialog').removeClass('open');--%>
<%--            }--%>
<%--        });--%>
<%--        initDialog();--%>
<%--    });--%>
<%--</script>--%>
</body>
</html>
