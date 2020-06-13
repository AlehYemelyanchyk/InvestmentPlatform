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
<div id="container">
    <br/>

    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-3">
            <a class="btn btn-dark" href="${pageContext.request.contextPath}/addPortfolio"
               data-tooltip title="<fmt:message key="label.createNewPortfolio"/>">
                <i class="icon-plus-sign-alt"></i>
            </a>
        </div>
        <div class="col-md-3"></div>
        <div class="col-md-3"></div>
    </div>

    <br/>

    <div class="row">
        <c:forEach var="portfolio" items="${PORTFOLIOS_LIST}">
            <div class="col-md-3"></div>
            <div class="col-md-3">
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

                <h4><a href="${portfolioLink}">${portfolio.name}</a></h4>
            </div>
            <div class="col-md-3"></div>
            <div class="col-md-3">
                <div class="row">
                    <div class="col-md-3">
                        <a href="${updateLink}" data-tooltip title="<fmt:message key="label.edit"/>">
                            <i class="icon-edit"></i>
                        </a>
                    </div>
                    <div class="col-md-3">
                        <a href="${removeLink}" data-tooltip title="<fmt:message key="label.delete"/>"
                           onclick="if (!(confirm('<fmt:message key="label.deletePortfolio"/>'))) return false">
                            <i class="icon-trash"></i>
                        </a>
                    </div>
                    <div class="col-md-3"></div>
                    <div class="col-md-3"></div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
