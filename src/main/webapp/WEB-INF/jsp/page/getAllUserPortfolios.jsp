<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>

<html lang="${sessionScope.lang}">
<head>
    <title>Portfolios</title>
</head>
<body>
<div id="header">
    <h4 align="center">
        <fmt:message key="label.allPortfolios"/>
    </h4>
</div>

<div id="container">
    <input type="button" value="<fmt:message key="label.createNewPortfolio"/>"
           onclick="window.location.href='addPortfolio'; return false;"
           class="btn btn-primary"/>
    <table>
        <c:forEach var="portfolio" items="${PORTFOLIOS_LIST}">

            <c:url var="portfolioLink" value="getAllPortfolioSecurities">
                <c:param name="PORTFOLIO_NAME" value="${portfolio.name}"/>
                <c:param name="PORTFOLIO_ID" value="${portfolio.id}"/>
            </c:url>

            <c:url var="updateLink" value="updatePortfolio">
                <c:param name="PORTFOLIO_ID" value="${portfolio.id}"/>
            </c:url>

            <c:url var="removeLink" value="removePortfolio">
                <c:param name="PORTFOLIO_ID" value="${portfolio.id}"/>
            </c:url>

            <tr>
                <td>
                    <h4><a href="${portfolioLink}">${portfolio.name}</a></h4>
                </td>
                <td>
                    <a href="${updateLink}"><fmt:message key="label.edit"/></a>
                    |
                    <a href="${removeLink}"
                       onclick="if (!(confirm('<fmt:message key="label.deletePortfolio"/>'))) return false">
                        <fmt:message key="label.delete"/></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
