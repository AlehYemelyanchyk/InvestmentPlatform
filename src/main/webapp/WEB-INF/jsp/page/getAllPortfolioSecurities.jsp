<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="content"/>

<html lang="${cookie['lang'].value}">
<head>
    <title>Portfolio securities</title>
</head>

<body>
<div class="container mt-2 mb-2 table-striped">
    <div id="header">
        <h4 align="center">${PORTFOLIO_NAME}</h4>
    </div>

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

    <div id="holdings" data-tab-content class="active">
        <table
                data-toggle="table"
                data-pagination="true"
                data-search="true">
            <thead>
            <tr>
                <th data-field="symbol" data-sortable="true"><fmt:message key="label.symbol"/></th>
                <th data-field="name" data-sortable="true"><fmt:message key="label.name"/></th>
                <th data-field="exchange" data-sortable="true"><fmt:message key="label.exchange"/></th>
                <th data-field="amount" data-sortable="true"><fmt:message key="label.amount"/></th>
                <th data-field="average_price" data-sortable="true"><fmt:message key="label.averagePrice"/></th>
                <th data-field="year_change" data-sortable="true"><fmt:message key="label.yearChange"/>, %</th>
                <th data-field="type" data-sortable="true"><fmt:message key="label.type"/></th>
                <th data-field="add" data-sortable="false"></th>
                <th data-field="sell" data-sortable="false"></th>
                <th data-field="remove" data-sortable="false"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="transaction" items="${PORTFOLIO_SECURITIES}">
                <tr>
                    <td>
                        <form id="formSymbol" action="${pageContext.request.contextPath}/getAllSecurityTransactions"
                              method="POST">
                            <input type="hidden" name="PORTFOLIO_ID" value="${PORTFOLIO_ID}">
                            <input type="hidden" name="SECURITY_NAME" value="${transaction.value.name}">
                            <input type="hidden" name="SECURITY_SYMBOL" value="${transaction.key}">
                            <button type="submit" class="btn btn-link">
                                <h6>${transaction.key}</h6>
                            </button>
                        </form>
                    </td>

                    <td>
                        <form id="formName" action="${pageContext.request.contextPath}/getAllSecurityTransactions"
                              method="POST">
                            <input type="hidden" name="PORTFOLIO_ID" value="${PORTFOLIO_ID}">
                            <input type="hidden" name="SECURITY_NAME" value="${transaction.value.name}">
                            <input type="hidden" name="SECURITY_SYMBOL" value="${transaction.key}">
                            <button type="submit" class="btn btn-link">
                                <h6>${transaction.value.name}</h6>
                            </button>
                        </form>
                    </td>

                    <td>
                        <c:out value="${transaction.value.exchange}"></c:out>
                    </td>

                    <td>
                        <c:out value="${transaction.value.amount}"></c:out>
                    </td>

                    <td>
                        <c:set var="averagePrice" value="${transaction.value.averagePrice}"/>
                        <fmt:formatNumber type="number" minFractionDigits="2"
                                          maxFractionDigits="2" value="${averagePrice}"/>
                    </td>

                    <td>
                        <c:set var="yearChangePercents" value="${transaction.value.yearChangePercents}"/>
                        <fmt:formatNumber type="number" minFractionDigits="2"
                                          maxFractionDigits="2" value="${yearChangePercents}"/>
                    </td>

                    <td>
                        <c:out value="${transaction.value.securityType}"></c:out>
                    </td>

                    <td>
                        <form id="form${transaction.value.symbol}"
                              action="${pageContext.request.contextPath}/addSecurityToPortfolioWindow" method="POST">
                            <input type="hidden" name="SECURITY_SYMBOL" value="${transaction.value.symbol}">
                            <input type="hidden" name="SECURITY_PRICE" value="${transaction.value.averagePrice}">
                            <input type="hidden" name="PORTFOLIO_ID" value="${PORTFOLIO_ID}">
                            <c:choose>
                                <c:when test="${transaction.value.stopTradeDate != null}">
                                    <button class="btn btn-warning" type="submit"
                                            onclick="isClosed('${transaction.value.symbol}','${transaction.value.stopTradeDate}')"
                                            data-tooltip title="<fmt:message key="label.add"/>">
                                        <i class="icon-plus"></i>
                                    </button>
                                </c:when>
                                <c:otherwise>
                                    <button class="btn btn-link" type="submit"
                                            data-tooltip title="<fmt:message key="label.add"/>">
                                        <i class="icon-plus"></i>
                                    </button>
                                </c:otherwise>
                            </c:choose>
                        </form>
                    </td>

                    <td>
                        <form action="${pageContext.request.contextPath}/sellSecurityFromPortfolioWindow" method="POST">
                            <input type="hidden" name="SECURITY_SYMBOL" value="${transaction.value.symbol}">
                            <input type="hidden" name="SECURITY_PRICE" value="${averagePrice}">
                            <input type="hidden" name="PORTFOLIO_ID" value="${PORTFOLIO_ID}">
                            <input type="hidden" name="AMOUNT" value="${transaction.value.amount}">
                            <button class="btn btn-link" type="submit"
                                    data-tooltip title="<fmt:message key="label.sell"/>">
                                <i class="icon-minus"></i>
                            </button>
                        </form>
                    </td>

                    <td>
                        <form id="formRemove${transaction.value.symbol}"
                              action="${pageContext.request.contextPath}/removeSecurityFromPortfolio" method="POST">
                            <input type="hidden" name="SECURITY_SYMBOL" value="${transaction.value.symbol}">
                            <input type="hidden" name="PORTFOLIO_ID" value="${PORTFOLIO_ID}">
                            <button class="btn btn-link" type="submit"
                                    data-tooltip title="<fmt:message key="label.delete"/>"
                                    onclick="deleteSecurity('${transaction.value.symbol}')">
                                <i class="icon-trash btn-link"></i>
                            </button>
                        </form>
                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div id="transactions" data-tab-content>
        <table
                data-toggle="table"
                data-pagination="true"
                data-search="true">
            <thead>
            <tr>
                <th data-field="symbol" data-sortable="true"><fmt:message key="label.symbol"/></th>
                <th data-field="type" data-sortable="true"><fmt:message key="label.type"/></th>
                <th data-field="amount" data-sortable="true"><fmt:message key="label.amount"/></th>
                <th data-field="price" data-sortable="true"><fmt:message key="label.price"/></th>
                <th data-field="date" data-sortable="true"><fmt:message key="label.date"/></th>
                <th data-field="edit" data-sortable="false"></th>
                <th data-field="remove" data-sortable="false"></th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="transaction" items="${PORTFOLIO_TRANSACTIONS}">
                <tr>
                    <td>
                        <form action="${pageContext.request.contextPath}/getSecurity" method="POST">
                            <input type="hidden" name="SECURITY_SYMBOL" value="${transaction.securitySymbol}">
                            <button class="btn btn-link" type="submit">
                                    ${transaction.securitySymbol}
                            </button>
                        </form>
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
                        <form action="${pageContext.request.contextPath}/updateTransactionWindow" method="POST">
                            <input type="hidden" name="TRANSACTION_ID" value="${transaction.id}">
                            <input type="hidden" name="PORTFOLIO_NAME" value="${PORTFOLIO_NAME}">
                            <button class="btn btn-link" type="submit"
                                    data-tooltip title="<fmt:message key="label.edit"/>">
                                <i class="icon-edit"></i>
                            </button>
                        </form>
                    </td>

                    <td>
                        <form id="formRemove${transaction.id}"
                              action="${pageContext.request.contextPath}/removeTransaction" method="POST">
                            <input type="hidden" name="TRANSACTION_ID" value="${transaction.id}">
                            <input type="hidden" name="PORTFOLIO_NAME" value="${PORTFOLIO_NAME}">
                            <button class="btn btn-link" type="submit"
                                    data-tooltip title="<fmt:message key="label.delete"/>"
                                    onclick="deleteTransaction('${transaction.id}')">
                                <i class="icon-trash"></i>
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="pagination-container">
        <nav>
            <ul class="pagination"></ul>
        </nav>
    </div>
</div>
<script src="static/js/deleteTransaction.js"></script>
<script src="static/js/deleteSecurity.js"></script>
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
