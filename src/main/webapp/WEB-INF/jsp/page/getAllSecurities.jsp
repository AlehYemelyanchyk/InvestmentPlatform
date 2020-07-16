<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>

<html lang="${sessionScope.lang}">
<head>
    <title>All securities</title>
</head>

<body>
<div class="container mt-2 mb-2 table-striped">
    <br/>

    <div class="tabs_names">
        <li data-tab-target="#Fund" class="active tab">Funds</li>
        <li data-tab-target="#Bond" class="tab">Bonds</li>
        <li data-tab-target="#Cryptocurrency" class="tab">Crypto</li>
        <li data-tab-target="#ETF" class="tab">ETFs</li>
        <li data-tab-target="#Stock" class="tab">Stocks</li>
    </div>

    <c:forEach var="type" items="${SECURITIES_LIST}" varStatus="loop">

    <c:choose>

    <c:when test="${loop.index == 0}">
    <div id="${type.key}" data-tab-content class="active">
        </c:when>

        <c:otherwise>
        <div id="${type.key}" data-tab-content>
            </c:otherwise>

            </c:choose>

            <table
                    data-toggle="table"
                    data-pagination="true"
                    data-search="true">
                <thead>
                <tr>
                    <th data-field="symbol" data-sortable="true"><fmt:message key="label.symbol"/></th>
                    <th data-field="name" data-sortable="true"><fmt:message key="label.name"/></th>
                    <th data-field="exchange" data-sortable="true"><fmt:message key="label.exchange"/></th>
                    <th data-field="current_price" data-sortable="true"><fmt:message key="label.currentPrice"/></th>
                    <th data-field="year_change" data-sortable="true"><fmt:message key="label.yearChange"/>, %</th>
                    <th data-field="dividends" data-sortable="true"><fmt:message key="label.dividends"/></th>
                    <th data-field="" data-sortable="false"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="transaction" items="${type.value}">

                    <c:url var="securityLink" value="getSecurity">
                        <c:param name="SECURITY_SYMBOL" value="${transaction.symbol}"/>
                    </c:url>

                    <tr>
                        <td>
                            <a href="${securityLink}">${transaction.symbol}</a>
                        </td>

                        <td>
                            <a href="${securityLink}">${transaction.name}</a>
                        </td>

                        <td>
                            <c:out value="${transaction.exchange}"></c:out>
                        </td>

                        <td>
                            <c:out value="${transaction.currentPrice}"></c:out>
                        </td>

                        <td>
                            <c:out value="${transaction.yearChangePercents}"></c:out>
                        </td>

                        <td>
                            <c:out value="${transaction.dividends}"></c:out>
                        </td>

                        <td>
                            <form id="form${transaction.symbol}"
                                  action="${pageContext.request.contextPath}/addSecurityToPortfolio" method="GET">
                                <input type="hidden" name="SECURITY_SYMBOL" value="${transaction.symbol}">
                                <input type="hidden" name="SECURITY_PRICE" value="${transaction.currentPrice}">
                                <input type="hidden" name="PORTFOLIO_ID" value="${PORTFOLIO_ID}">
                                    <%--                                    <button ${CURRENT_USER_ID == null?'disabled="disabled"':''}--%>
                                <c:choose>
                                    <c:when test="${transaction.stopTradeDate != null}">
                                        <button
                                                class="btn btn-warning" type="submit"
                                                onclick="isClosed('${transaction.symbol}','${transaction.stopTradeDate}')"
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
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>

        </c:forEach>

        <div class="pagination-container">
            <nav>
                <ul class="pagination"></ul>
            </nav>
        </div>
    </div>
</body>
</html>
