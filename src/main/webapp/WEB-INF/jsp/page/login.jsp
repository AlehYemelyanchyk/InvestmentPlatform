<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="content"/>

<html lang="${cookie['lang'].value}">
<head>
    <title>Login</title>
</head>
<body>
<div id="container">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form id="form" class="needs-validation form-container" novalidate action="${pageContext.request.contextPath}/login"
                  method="POST">
                <div>
                    <input type="hidden" name="REDIRECT_LINK" value="${REDIRECT_LINK}">
                    <div class="valid-feedback"></div>
                    <div class="invalid-feedback"></div>
                </div>
                <div class="form-group">
                    <label for="login"><fmt:message key="label.login2"/></label>
                    <input type="text" name="login" class="form-control" id="login"
                           placeholder="<fmt:message key="label.login2"/>"
                           required
                           data-value-missing="Please, enter login">
                    <div class="valid-feedback"></div>
                    <div class="invalid-feedback"></div>
                </div>
                <div class="form-group">
                    <label for="password"><fmt:message key="label.password"/></label>
                    <input type="password" name="password" class="form-control" id="password"
                           placeholder="<fmt:message key="label.password"/>"
                           required
                           data-value-missing="Please, enter password">
                    <div class="valid-feedback"></div>
                    <div class="invalid-feedback"></div>
                </div>
<%--                <div class="form-check">--%>
<%--                    <input type="checkbox" class="form-check-input" id="checkbox"--%>
<%--                           name="rememberMe"--%>
<%--                           data-value-missing="You must agree before submitting">--%>
<%--                    <label class="form-check-label" for="checkbox">Remember me</label>--%>
<%--                </div>--%>
                <button onclick="XSSPrevent()" type="submit" class="btn btn-success btn-block"><fmt:message
                        key="label.login"/>
                </button>

                <div align="center">
                    <br>

                    <span><fmt:message key="label.dontHaveAccount"/> </span>
                    <a href="${pageContext.request.contextPath}/signup">
                        <fmt:message key="label.freeSignUp"/>
                    </a>
                </div>
            </form>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>
</body>
</html>
