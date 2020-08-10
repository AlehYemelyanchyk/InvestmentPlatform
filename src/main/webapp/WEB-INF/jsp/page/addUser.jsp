<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="content"/>

<html lang="${cookie['lang'].value}">
<head>
    <title>Add user</title>
</head>
<body>
<div id="container">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form id="form" class="needs-validation form-container" novalidate action="${pageContext.request.contextPath}/addUserAdmin"
                  method="POST">
                <div class="form-group">
                    <label for="inputRole"><fmt:message key="label.role"/></label>
                    <select id="inputRole" name="role" class="form-control">
                        <option value="1">Admin</option>
                        <option value="2">User</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="login"><fmt:message key="label.login2"/></label>
                    <input type="text" name="login" class="form-control" id="login"
                           placeholder="<fmt:message key="label.login2"/>"
                           required
                           data-value-missing="Please, enter login">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>
                <div class="form-group">
                    <label for="password"><fmt:message key="label.password"/></label>
                    <input type="password" name="password" class="form-control" id="password"
                           placeholder="<fmt:message key="label.password"/>"
                           required minlength="8"
                           pattern="^(?=.*[A-Za-z])(?=.*\d)[a-zA-Z\d]{8,}$"
                           data-value-missing="Please, enter password"
                           data-pattern-length-mismatch="Password must be at least 8 characters long"
                           data-pattern-mismatch="A password must contain at least 1 alphabetical character and at least 1 numeric character">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>
                <div class="form-group">
                    <label for="email"><fmt:message key="label.email"/></label>
                    <input type="email" name="email" class="form-control" id="email"
                           placeholder="<fmt:message key="label.email"/>"
                           required
                           pattern="(?:[a-z0-9!#$%&amp;'*+/=?^_&#x60;{|}~-]+(?:\.[a-z0-9!#$%&amp;'*+/=?^_&#x60;{|}~-]+)*|&quot;(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*&quot;)@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])"
                           data-value-missing="Please, enter email"
                           data-pattern-mismatch="The e-mail address is not correct.">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>
                <div class="form-group">
                    <label for="name"><fmt:message key="label.name"/></label>
                    <input type="text" name="name" class="form-control" id="name"
                           placeholder="<fmt:message key="label.name"/>"
                           required
                           data-value-missing="Please, enter name">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>
                <div class="form-group">
                    <label for="surname"><fmt:message key="label.surname"/></label>
                    <input type="text" name="surname" class="form-control" id="surname"
                           placeholder="<fmt:message key="label.surname"/>"
                           required
                           data-value-missing="Please, enter surname">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>
                <div class="form-group">
                    <label for="inputCountry"><fmt:message key="label.country"/></label>
                    <select id="inputCountry" name="country" class="form-control">
                        <c:forEach var="country" items="${sessionScope.COUNTRIES_LIST}">
                            <option value="${country}">${country}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="invalidCheck"
                           required
                           data-value-missing="You must agree before submitting">
                    <label class="form-check-label" for="invalidCheck">Agree to terms and conditions</label>
                    <div class="invalid-feedback"></div>
                </div>
                <button onclick="XSSPrevent()" type="submit" class="btn btn-primary btn-block"><fmt:message
                        key="label.submit"/>
                </button>
            </form>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>
</body>
</html>