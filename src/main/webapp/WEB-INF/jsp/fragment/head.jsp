<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="project-tag" uri="/WEB-INF/tags.tld" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>

<html lang="${sessionScope.lang}">
<div id="wrapper">
    <div id="header">
        <h1 align="center">
            <a id="header-link" href="http://localhost:8080/investmentplatform/">Investment Platform</a>
        </h1>
        <%--                <project-tag:static/>--%>
    </div>
    <div>
        <c:url var="link_en" value="${COMMAND_ATTRIBUTE}">
            <c:param name="SECURITY_SYMBOL" value="${SECURITY.symbol}"/>
            <c:param name="PORTFOLIO_ID" value="${PORTFOLIO_ID}"/>
<%--            <c:param name="SECURITY_NAME" value="${SECURITY_NAME}"/>--%>
            <c:param name="sessionLocale" value="en"/>
        </c:url>
        <c:url var="link_ru" value="${COMMAND_ATTRIBUTE}">
            <c:param name="SECURITY_SYMBOL" value="${SECURITY.symbol}"/>
            <c:param name="PORTFOLIO_ID" value="${PORTFOLIO_ID}"/>
<%--            <c:param name="SECURITY_NAME" value="${SECURITY_NAME}"/>--%>
            <c:param name="sessionLocale" value="ru"/>
        </c:url>
        <c:url var="link_by" value="${COMMAND_ATTRIBUTE}">
            <c:param name="SECURITY_SYMBOL" value="${SECURITY.symbol}"/>
            <c:param name="PORTFOLIO_ID" value="${PORTFOLIO_ID}"/>
<%--            <c:param name="SECURITY_NAME" value="${SECURITY_NAME}"/>--%>
            <c:param name="sessionLocale" value="by"/>
        </c:url>

        <p align="right">
            <a class="lang_icons" href=${link_en}><fmt:message key="label.lang.en"/></a>
            <a class="lang_icons" href=${link_ru}><fmt:message key="label.lang.ru"/></a>
            <a class="lang_icons" href=${link_by}><fmt:message key="label.lang.by"/></a>
        </p>
        <ul>
            <c:choose>
                <c:when test="${CURRENT_USER_ID == null}">
                    <a href="signup"><fmt:message key="label.signup"/></a> | <a href="login"><fmt:message
                        key="label.login"/></a>
                </c:when>
                <c:when test="${CURRENT_USER_ID != null}">
                    <a href="${pageContext.request.contextPath}/userSettings">${CURRENT_USER_LOGIN}</a>
                </c:when>
            </c:choose>
        </ul>

    </div>
    <br/><br/>
</div>
<body>
<input type="hidden" name="SECURITY_SYMBOL" value="${SECURITY.symbol}">
</body>
</html>