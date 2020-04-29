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
        <h2 align="center">Securities</h2>
    </div>
</div>

<div id="container">
    <div id="content">

        <div class="tabs_names">
            <li data-tab-target="#bonds" class="active tab">Bonds</li>
            <li data-tab-target="#crypto" class="tab">Crypto</li>
            <li data-tab-target="#etfs" class="tab">ETFs</li>
            <li data-tab-target="#funds" class="tab">Funds</li>
            <li data-tab-target="#stocks" class="tab">Stocks</li>
        </div>

        <div class="tabs_content">
            <div id="bonds" data-tab-content class="active">
                <table>
                    <tr>
                        <th>Symbol</th>
                        <th>Name</th>
                        <th>Exchange</th>
                        <th>Current price</th>
                        <th>Year change, %</th>
                        <th>Dividends</th>
                    </tr>

                    <c:forEach var="security" items="${SECURITIES_LIST}">
                        <c:if test="${security.securityType == 'Bond'}">
                            <tr>
                                <td>
                                    <c:out value="${security.symbol}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.name}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.exchange}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.currentPrice}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.yearChangePercents}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.dividends}"></c:out>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>>
                </table>
            </div>
            <div id="crypto" data-tab-content class="active">
                <table>
                    <tr>
                        <th>Symbol</th>
                        <th>Name</th>
                        <th>Exchange</th>
                        <th>Current price</th>
                        <th>Year change, %</th>
                        <th>Dividends</th>
                    </tr>

                    <c:forEach var="security" items="${SECURITIES_LIST}">
                        <c:if test="${security.securityType == 'Cryptocurrency'}">
                            <tr>
                                <td>
                                    <c:out value="${security.symbol}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.name}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.exchange}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.currentPrice}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.yearChangePercents}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.dividends}"></c:out>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>>
                </table>
            </div>
            <div id="etfs" data-tab-content class="active">
                <table>
                    <tr>
                        <th>Symbol</th>
                        <th>Name</th>
                        <th>Exchange</th>
                        <th>Current price</th>
                        <th>Year change, %</th>
                        <th>Dividends</th>
                    </tr>

                    <c:forEach var="security" items="${SECURITIES_LIST}">
                        <c:if test="${security.securityType == 'ETF'}">
                            <tr>
                                <td>
                                    <c:out value="${security.symbol}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.name}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.exchange}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.currentPrice}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.yearChangePercents}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.dividends}"></c:out>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>>
                </table>
            </div>
            <div id="funds" data-tab-content class="active">
                <table>
                    <tr>
                        <th>Symbol</th>
                        <th>Name</th>
                        <th>Exchange</th>
                        <th>Current price</th>
                        <th>Year change, %</th>
                        <th>Dividends</th>
                    </tr>

                    <c:forEach var="security" items="${SECURITIES_LIST}">
                        <c:if test="${security.securityType == 'Fund'}">
                            <tr>
                                <td>
                                    <c:out value="${security.symbol}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.name}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.exchange}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.currentPrice}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.yearChangePercents}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.dividends}"></c:out>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>>
                </table>
            </div>
            <div id="stocks" data-tab-content class="active">
                <table>
                    <tr>
                        <th>Symbol</th>
                        <th>Name</th>
                        <th>Exchange</th>
                        <th>Current price</th>
                        <th>Year change, %</th>
                        <th>Dividends</th>
                    </tr>

                    <c:forEach var="security" items="${SECURITIES_LIST}">
                        <c:if test="${security.securityType == 'Stock'}">
                            <tr>
                                <td>
                                    <c:out value="${security.symbol}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.name}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.exchange}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.currentPrice}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.yearChangePercents}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.dividends}"></c:out>
                                </td>
                            </tr>
                        </c:if>
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
</body>
</html>
