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

                <div>
                    <button type="button" class="btn btn-light btn-block">
                        <a href="${pageContext.request.contextPath}/updateUserPassword">
                            <h4><fmt:message key="label.password"/></h4>
                        </a>
                    </button>
                </div>

                <div class="form-group">
                    <label for="email"><fmt:message key="label.email"/></label>
                    <input type="email" name="email" class="form-control" id="email"
                           value="${CURRENT_USER.email}"
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