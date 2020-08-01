<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="content"/>

<html lang="${cookie['lang'].value}">
<head>
    <title>Portfolios</title>
</head>
<body>
<div id="container">
    <br/>

    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-3">
            <a class="btn btn-info" href="${pageContext.request.contextPath}/addPortfolio">
                New Portfolio
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

                <form id="form" action="${pageContext.request.contextPath}/getAllPortfolioSecurities" method="POST">
                    <input type="hidden" name="PORTFOLIO_NAME" value="${portfolio.name}">
                    <input type="hidden" name="PORTFOLIO_ID" value="${portfolio.id}">
                    <button type="submit" class="btn btn-link">
                        <h4>${portfolio.name}</h4>
                    </button>
                </form>

            </div>
            <div class="col-md-3"></div>
            <div class="col-md-3">
                <div class="row">
                    <div class="col-md-3">

                        <form id="formUpdate" action="${pageContext.request.contextPath}/updatePortfolioWindow"
                              method="POST">
                            <input type="hidden" name="PORTFOLIO_ID" value="${portfolio.id}">
                            <button type="submit"
                                    class="btn btn-link"
                                    data-tooltip title="<fmt:message key="label.edit"/>">
                                <i class="icon-edit"></i>
                            </button>
                        </form>

                    </div>
                    <div class="col-md-3">

                        <form id="formRemove${portfolio.name}"
                              action="${pageContext.request.contextPath}/removePortfolio" method="POST">
                            <input type="hidden" name="PORTFOLIO_ID" value="${portfolio.id}">
                            <button type="submit"
                                    class="btn btn-link"
                                    onclick="deletePortfolio('${portfolio.name}')"
                                    data-tooltip title="<fmt:message key="label.delete"/>">
                                <i class="icon-trash"></i>
                            </button>
                        </form>

                    </div>
                    <div class="col-md-3"></div>
                    <div class="col-md-3"></div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<script src="static/js/deletePortfolio.js"></script>
</body>
</html>
