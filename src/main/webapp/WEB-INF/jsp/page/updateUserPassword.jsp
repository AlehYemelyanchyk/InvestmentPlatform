<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="content"/>

<html lang="${cookie['lang'].value}">
<head>
    <title>Update user</title>
</head>
<body>
<div id="container">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form id="form" class="needs-validation form-container" novalidate
                  action="${pageContext.request.contextPath}/updateUserPassword" method="POST">

                <div class="form-group">
                    <label for="oldPassword"><fmt:message key="label.oldPassword"/></label>
                    <input type="password" name="oldPassword" class="form-control" id="oldPassword"
                           placeholder="<fmt:message key="label.oldPassword"/>"
                           required
                           data-value-missing="Please, enter old password">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>

                <div class="form-group">
                    <label for="password"><fmt:message key="label.newPassword"/></label>
                    <input onchange="read()" type="password" name="password" class="form-control" id="password"
                           placeholder="<fmt:message key="label.newPassword"/>"
                           required minlength="8"
                           pattern="^(?=.*[A-Za-z])(?=.*\d)[a-zA-Z\d]{8,}$"
                           data-value-missing="Please, enter new password"
                           data-pattern-length-mismatch="Password must be at least 8 characters long"
                           data-pattern-mismatch="A password must contain at least 1 alphabetical character and at least 1 numeric character">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>
                ${pass}
                <div class="form-group">
                    <label for="password"><fmt:message key="label.repeatNewPassword"/></label>
                    <input type="password" name="password" class="form-control" id="passwordRepeat"
                           placeholder="<fmt:message key="label.repeatNewPassword"/>"
                           required minlength="8"
                           pattern
                           data-value-missing="Please, enter new password"
                           data-pattern-mismatch="The two passwords don't match">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>

                <button onclick="XSSPrevent()" type="submit" class="btn btn-primary btn-block"><fmt:message
                        key="label.submit"/>
                </button>
            </form>
            <br/>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>
<script src="static/js/passwordsMatch.js"></script>
</body>
</html>