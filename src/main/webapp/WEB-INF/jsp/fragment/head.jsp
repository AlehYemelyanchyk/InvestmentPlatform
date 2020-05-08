<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="wrapper">
    <div id="header">
        <h1 align="center">Investment Platform</h1>
    </div>
    <div>
        <p align="right">
            <c:choose>
            <c:when test="${CURRENT_USER_ID == null}">
                <a href="signup">Sign Up</a> | <a href="login">Log In</a>
            </c:when>
                <c:when test="${CURRENT_USER_ID != null}">
                    <a href="${pageContext.request.contextPath}/userSettings">${CURRENT_USER_LOGIN}</a>
                </c:when>
            </c:choose>
        </p>
    </div>
    <br/><br/>
</div>