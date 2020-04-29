<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="css/tabsStyle.css">
    <link type="text/css" rel="stylesheet" href="css/autocompleteSearch.css">
    <script type="text/javascript" src="jquery-3.5.0.min.js"></script>
    <%--    <script type="text/javascript" src="js/tabs.js"></script>--%>
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h2 align="center">${PORTFOLIO_NAME}</h2>
    </div>
</div>

<div id="container">
    <div id="content">

        <div class="autocomplete">
            <input type="text" placeholder="Find a security">
            <span class="close">Cancel</span>
            <div class="dialog">
            </div>
        </div>

        <div class="tabs_names">
            <li data-tab-target="#holdings" class="active tab">Holdings</li>
            <li data-tab-target="#transactions" class="tab">Transactions</li>
        </div>

        <div class="tabs_content">
            <div id="holdings" data-tab-content class="active">
                <table>
                    <tr>
                        <th>Symbol</th>
                        <th>Name</th>
                        <th>Exchange</th>
                        <th>Amount</th>
                        <th>Average price</th>
                        <th>Year change, %</th>
                        <th>Type</th>
                        <th></th>
                    </tr>

                    <c:forEach var="security" items="${PORTFOLIO_SECURITIES}">
                        <c:url var="securityLink" value="getAllSecurityTransactions">
                            <c:param name="PORTFOLIO_ID" value="${PORTFOLIO_ID}"/>
                            <c:param name="SECURITY_NAME" value="${security.value.name}"/>
                            <c:param name="SECURITY_SYMBOL" value="${security.key}"/>
                        </c:url>

                        <tr>
                            <td>
                                <c:out value="${security.key}"></c:out>
                            </td>

                            <td>
                                <c:out value="${security.value.name}"></c:out>
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
                                    <input type="submit" name="submit" value="Delete">
                                </form>
                            </td>

                        </tr>
                    </c:forEach>>
                </table>
            </div>
            <div id="transactions" data-tab-content>
                <table>
                    <tr>
                        <th>Symbol</th>
                        <th>Type</th>
                        <th>Amount</th>
                        <th>Price</th>
                        <th>Date</th>
                        <th></th>
                    </tr>

                    <c:forEach var="transaction" items="${PORTFOLIO_TRANSACTIONS}">
                        <tr>
                            <td>
                                <c:out value="${transaction.securitySymbol}"></c:out>
                            </td>

                            <td>
                                <c:choose>
                                    <c:when test="${transaction.transactionType == 1}">
                                        Buy
                                    </c:when>
                                    <c:when test="${transaction.transactionType == 2}">
                                        Sell
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
                                <a href="${removeLink}"
                                   onclick="if (!(confirm('Are you sure you want to delete this security?'))) return false">
                                    Delete</a>
                            </td>
                        </tr>
                    </c:forEach>>
                </table>
            </div>
        </div>
    </div>
</div>
<script>
    const tabs = document.querySelectorAll('[data-tab-target]')
    const tabContent = document.querySelectorAll('[data-tab-content]')

    tabs.forEach(tab => {
        tab.addEventListener('click', () => {
            const target = document.querySelector(tab.dataset.tabTarget)
            tabContent.forEach(tabContent => {
                tabContent.classList.remove('active')
            })
            tabs.forEach(tab => {
                tab.classList.remove('active')
            })
            tab.classList.add('active')
            target.classList.add('active')
        })
    })
</script>
<script>
    $(function () {
        var alreadyFilled = false;
        var securities = new Array()

        <c:forEach var="security" items="${PORTFOLIO_SECURITIES}">
        <c:url var="securityLink" value="addSecurity">
        <c:param name="SECURITY" value="${security}"/>
        </c:url>
        securities.push(
            "${security.value.symbol}" + "   " +
            "${security.value.name}" + "   " +
            "${security.value.exchange}");
        </c:forEach>

        function initDialog() {
            clearDialog();
            for (var i = 0; i < securities.length; i++) {
                $('.dialog').append('<div>' + securities[i] + '</div>');
            }
        }

        function clearDialog() {
            $('.dialog').empty();
        }

        $('.autocomplete input').click(function () {
            if (!alreadyFilled) {
                $('.dialog').addClass('open');
            }

        });
        $('body').on('click', '.dialog > div', function () {
            $('.autocomplete input').val($(this).text()).focus();
            $('.autocomplete .close').addClass('visible');
            alreadyFilled = true;
        });
        $('.autocomplete .close').click(function () {
            alreadyFilled = false;
            $('.dialog').addClass('open');
            $('.autocomplete input').val('').focus();
            $(this).removeClass('visible');
        });

        function match(str) {
            str = str.toLowerCase();
            clearDialog();
            for (var i = 0; i < securities.length; i++) {
                if (securities[i].toLowerCase().startsWith(str)) {
                    $('.dialog').append('<div>' + securities[i] + '</div>');
                }
            }
        }

        $('.autocomplete input').on('input', function () {
            $('.dialog').addClass('open');
            alreadyFilled = false;
            match($(this).val());
        });
        $('body').click(function (e) {
            if (!$(e.target).is("input, .close")) {
                $('.dialog').removeClass('open');
            }
        });
        initDialog();
    });
</script>
</body>
</html>
