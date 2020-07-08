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

    <a class="btn btn-dark" href="${pageContext.request.contextPath}/addSecurityAdmin"
       data-tooltip title="Add Security">
        <i class="icon-plus-sign-alt"></i>
    </a>

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
                    <th data-field="edit" data-sortable="false"></th>
                    <th data-field="archive" data-sortable="false"></th>
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
                            <form action="${pageContext.request.contextPath}/updateSecurity" method="GET">
                                <input type="hidden" name="SECURITY_SYMBOL" value="${security.symbol}">
                                <button
                                        class="btn btn-dark" type="submit"
                                        data-tooltip title="Edit">
                                    <i class="icon-edit"></i>
                                </button>
                            </form>
                        </td>

                        <td>
                            <form action="${pageContext.request.contextPath}/archiveSecurity" method="GET">
                                <input type="hidden" name="SECURITY_SYMBOL" value="${security.symbol}">
                                <input type="hidden" name="SECURITY_PRICE" value="${security.currentPrice}">
                                <input type="hidden" name="PORTFOLIO_ID" value="${PORTFOLIO_ID}">
                                <button ${CURRENT_USER_ID == null?'disabled="disabled"':''}
                                        class="btn btn-dark" type="submit"
                                        data-tooltip title="Archive">
                                    <i class="icon-archive"></i>
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
</body>
</html>
