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
<div class="container">
    <div class="form-group">
        <select name="state" id="maxRows" class="form-control" style="width:150px;">
            <option value="5000"><fmt:message key="label.showAll"/></option>
            <option value="5">5</option>
            <option value="10">10</option>
            <option value="15">15</option>
            <option value="25">25</option>
            <option value="50">50</option>
            <option value="100">100</option>
        </select>
    </div>
    <div class="tabs_names">
        <li data-tab-target="#Fund" class="active tab">Funds</li>
        <li data-tab-target="#Bond" class="tab">Bonds</li>
        <li data-tab-target="#Cryptocurrency" class="tab">Crypto</li>
        <li data-tab-target="#ETF" class="tab">ETFs</li>
        <li data-tab-target="#Stock" class="tab">Stocks</li>
    </div>

    <div class="tabs_content table-bordered table-striped">

        <c:forEach var="type" items="${SECURITIES_LIST}" varStatus="loop">

        <c:choose>

        <c:when test="${loop.index == 0}">
        <div id="${type.key}" data-tab-content class="active">
            </c:when>

            <c:otherwise>
            <div id="${type.key}" data-tab-content>
                </c:otherwise>

                </c:choose>
                <br/>

                <table>
                    <thead>
                    <tr>
                        <th><fmt:message key="label.symbol"/></th>
                        <th><fmt:message key="label.name"/></th>
                        <th>Users hold</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="security" items="${type.value}">

                        <c:url var="securityLink" value="getSecurity">
                            <c:param name="SECURITY_SYMBOL" value="${security.symbol}"/>
                        </c:url>

                        <tr>
                            <td>
                                <a href="${securityLink}">${security.symbol}</a>
                            </td>

                            <td>
                                <a href="${securityLink}">${security.name}</a>
                            </td>

                            <td>
                                <form action="archiveSecurity" method="GET">
                                    <input type="hidden" name="SECURITY_SYMBOL" value="${security.symbol}">
                                    <input type="hidden" name="SECURITY_PRICE" value="${security.currentPrice}">
                                    <input type="hidden" name="PORTFOLIO_ID" value="${PORTFOLIO_ID}">
                                    <button ${CURRENT_USER_ID == null?'disabled="disabled"':''}
                                            class="btn btn-dark" type="submit"
                                            data-tooltip title="Click">
                                        <i class="icon-question-sign"></i>
                                    </button>
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
    </div>
</div>
</body>
</html>
