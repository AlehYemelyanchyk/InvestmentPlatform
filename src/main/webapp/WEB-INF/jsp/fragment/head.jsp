<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="project-tag" uri="/WEB-INF/tags.tld" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>

<html lang="${sessionScope.lang}">
<body>

<input type="hidden" id="userRole" value="${CURRENT_USER_ROLE}"/>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="navbar-brand" href="http://localhost:8080/investmentplatform/"><h4>iUj</h4></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="http://localhost:8080/investmentplatform/">
                    <fmt:message key="label.news"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link guest-hidden" href="${pageContext.request.contextPath}/getAllUserPortfolios">
                    <fmt:message key="label.portfolios"/>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/getAllSecurities">
                <fmt:message key="label.securities"/></a>
            </li>
        </ul>
    </div>

    <div class="mx-auto order-0">
        <a class="navbar-brand mx-auto" href="http://localhost:8080/investmentplatform/">InvestUj</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".dual-collapse2">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>

    <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="dropdown">
                    <select class="btn btn-secondary" name="lang" id="langs" onchange="location = this.value;">
                        <c:choose>
                            <c:when test="${sessionScope.lang == null || sessionScope.lang == 'en'}">
                                <option class="dropdown-item" value="?sessionLocale=en"><fmt:message
                                        key="label.lang.en"/></option>
                                <option class="dropdown-item" value="?sessionLocale=ru"><fmt:message
                                        key="label.lang.ru"/></option>
                                <option class="dropdown-item" value="?sessionLocale=by"><fmt:message
                                        key="label.lang.by"/></option>
                            </c:when>

                            <c:when test="${sessionScope.lang == 'ru'}">
                                <option value="?sessionLocale=ru"><fmt:message key="label.lang.ru"/></option>
                                <option value="?sessionLocale=en"><fmt:message key="label.lang.en"/></option>
                                <option value="?sessionLocale=by"><fmt:message key="label.lang.by"/></option>
                            </c:when>

                            <c:otherwise>
                                <option value="?sessionLocale=by"><fmt:message key="label.lang.by"/></option>
                                <option value="?sessionLocale=en"><fmt:message key="label.lang.en"/></option>
                                <option value="?sessionLocale=ru"><fmt:message key="label.lang.ru"/></option>
                            </c:otherwise>
                        </c:choose>
                    </select>
                </a>
            </li>
            <c:choose>
                <c:when test="${CURRENT_USER_ID == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/signup">
                            <fmt:message key="label.signup"/></a>
                    </li>
                    <li class="nav-item">

                    <a class="nav-link" href="${pageContext.request.contextPath}/login">
                        <fmt:message key="label.login"/></a>
                </c:when>
                <c:when test="${CURRENT_USER_ID != null}">
                    <li class="nav-item active">
                        <a class="nav-link" href="${pageContext.request.contextPath}/userSettings">
                                ${CURRENT_USER_LOGIN}</a>
                    </li>
                </c:when>
            </c:choose>
            </li>
        </ul>
    </div>
</nav>
</body>
</html>

