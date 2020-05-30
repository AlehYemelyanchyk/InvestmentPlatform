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
        <h1 align="center">Investment Platform</h1>
        <%--                <project-tag:static/>--%>
    </div>
    <div>
        <p>
            <a href="?sessionLocale=en"><fmt:message key="label.lang.en"/></a>
            <a href="?sessionLocale=ru"><fmt:message key="label.lang.ru"/></a>
            <a href="?sessionLocale=by"><fmt:message key="label.lang.by"/></a>
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
</html>