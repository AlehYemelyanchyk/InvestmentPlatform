<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="content"/>

<html lang="${cookie['lang'].value}">
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
                <c:forEach var="security" items="${type.value}">

                    <tr>
                        <td>
                            <form id="formSymbol" action="${pageContext.request.contextPath}/getSecurity"
                                  method="POST">
                                <input type="hidden" name="SECURITY_SYMBOL" value="${security.symbol}">
                                <button type="submit" class="btn btn-link">
                                    <h6>${security.symbol}</h6>
                                </button>
                            </form>
                        </td>

                        <td>
                            <form id="formName" action="${pageContext.request.contextPath}/getSecurity"
                                  method="POST">
                                <input type="hidden" name="SECURITY_SYMBOL" value="${security.symbol}">
                                <button type="submit" class="btn btn-link">
                                    <h6>${security.name}</h6>
                                </button>
                            </form>
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

                        <td>
                            <form id="form${security.symbol}"
                                  action="${pageContext.request.contextPath}/addSecurityToPortfolioWindow"
                                  method="POST">
                                <input type="hidden" name="SECURITY_SYMBOL" value="${security.symbol}">
                                <input type="hidden" name="SECURITY_PRICE" value="${security.currentPrice}">
                                <input type="hidden" name="PORTFOLIO_ID" value="${PORTFOLIO_ID}">
                                <c:choose>
                                    <c:when test="${security.stopTradeDate != null}">
                                        <button
                                                class="btn btn-warning" type="submit"
                                                onclick="isClosed('${security.symbol}','${security.stopTradeDate}')"
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
