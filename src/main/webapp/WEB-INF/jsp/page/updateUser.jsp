<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>

<html lang="${sessionScope.lang}">
<head>
    <title>Update user</title>
</head>
<body>
<div id="container">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form id="form" class="needs-validation form-container" novalidate
                  action="${pageContext.request.contextPath}/updateUser" method="POST">

                <div>
                    <input type="hidden" name="CURRENT_USER_ID" value="${CURRENT_USER.id}">
                    <div class="valid-feedback"></div>
                    <div class="invalid-feedback"></div>
                </div>
                <div>
                    <input type="hidden" name="CURRENT_USER_LOGIN" value="${CURRENT_USER.login}">
                    <div class="valid-feedback"></div>
                    <div class="invalid-feedback"></div>
                </div>

                <div>
                    <input type="hidden" name="CURRENT_USER_ROLE" value="${CURRENT_USER.role}">
                    <div class="valid-feedback"></div>
                    <div class="invalid-feedback"></div>
                </div>

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
                    <input type="password" name="password" class="form-control" id="password"
                           placeholder="<fmt:message key="label.newPassword"/>"
                           required minlength="8"
                           pattern="^(?=.*[A-Za-z])(?=.*\d)[a-zA-Z\d]{8,}$"
                           data-value-missing="Please, enter new password"
                           data-pattern-length-mismatch="Password must be at least 8 characters long"
                           data-pattern-mismatch="A password must contain at least 1 alphabetical character and at least 1 numeric character">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>
                <div class="form-group">
                    <label for="email"><fmt:message key="label.email"/></label>
                    <input type="email" name="email" class="form-control" id="email"
                           value="${CURRENT_USER.email}"
                           placeholder="<fmt:message key="label.email"/>"
                           required
                           pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$"
                           data-value-missing="Please, enter email"
                           data-pattern-mismatch="The e-mail address is not correct.">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>
                <div class="form-group">
                    <label for="name"><fmt:message key="label.name"/></label>
                    <input type="text" name="name" class="form-control" id="name"
                           value="${CURRENT_USER.name}"
                           placeholder="<fmt:message key="label.name"/>"
                           required
                           data-value-missing="Please, enter name">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>
                <div class="form-group">
                    <label for="surname"><fmt:message key="label.surname"/></label>
                    <input type="text" name="surname" class="form-control" id="surname"
                           value="${CURRENT_USER.surname}"
                           placeholder="<fmt:message key="label.surname"/>"
                           required
                           data-value-missing="Please, enter surname">
                    <div class="valid-feedback">Good!</div>
                    <div class="invalid-feedback"></div>
                </div>
                <div class="form-group">
                    <label for="inputCountry"><fmt:message key="label.country"/></label>
                    <select id="inputCountry" name="country" class="form-control">
                        <option value="${CURRENT_USER.country}">${CURRENT_USER.country}</option>
                        <c:forEach var="country" items="${sessionScope.COUNTRIES_LIST}">
                            <option value="${country}">${country}</option>
                        </c:forEach>
                    </select>
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
</body>
</html>