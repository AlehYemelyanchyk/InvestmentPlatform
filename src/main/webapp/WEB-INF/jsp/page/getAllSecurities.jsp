<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>All securities</title>
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h2 align="center">Securities</h2>
    </div>
</div>

<div class="container">
    <div class="form-group">
        <select name="state" id="maxRows" class="form-control" style="width:150px;">
            <option value="5000">Show All</option>
            <option value="5">5</option>
            <option value="10">10</option>
            <option value="15">15</option>
            <option value="25">25</option>
            <option value="50">50</option>
            <option value="100">100</option>
        </select>
    </div>
    <div class="tabs_names">
        <li data-tab-target="#Bond" class="active tab">Bonds</li>
        <li data-tab-target="#Cryptocurrency" class="tab">Crypto</li>
        <li data-tab-target="#ETF" class="tab">ETFs</li>
        <li data-tab-target="#Fund" class="tab">Funds</li>
        <li data-tab-target="#Stock" class="tab">Stocks</li>
    </div>

    <div class="tabs_content table-bordered table-striped">

        <c:forEach var="type" items="${SECURITIES_LIST}">

            <div id="${type.key}" data-tab-content class="active">
                p<table>
                    <thead>
                    <tr>
                        <th>Symbol</th>
                        <th>Name</th>
                        <th>Exchange</th>
                        <th>Current price</th>
                        <th>Year change, %</th>
                        <th>Dividends</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="security" items="${type.value}">
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

                            <td>
                                <form action="addSecurityToPortfolio" method="GET">
                                    <input type="hidden" name="SECURITY_SYMBOL" value="${security.symbol}">
                                    <input type="hidden" name="SECURITY_PRICE" value="${security.currentPrice}">
                                    <input type="hidden" name="PORTFOLIO_ID" value="${PORTFOLIO_ID}">
                                    <input type="submit" name="submit" value="Add">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>>
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
</div>
</div>
</body>
</html>
