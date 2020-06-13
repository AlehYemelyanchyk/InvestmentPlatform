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
    <br/>
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form action="${pageContext.request.contextPath}/updateUser" method="POST">

                <input type="hidden" name="CURRENT_USER_ID" value="${CURRENT_USER.id}">
                <input type="hidden" name="CURRENT_USER_LOGIN" value="${CURRENT_USER.login}">
                <input type="hidden" name="CURRENT_USER_ROLE" value="${CURRENT_USER.role}">

                <div class="form-group">
                    <label for="validationServer01"><fmt:message key="label.oldPassword"/>:</label>
                    <input type="password" name="password" class="form-control is-valid" id="validationServer01"
                           placeholder="<fmt:message key="label.oldPassword"/>" required>
                    <div class="valid-feedback">
                        Good!
                    </div>
                </div>

                <div class="form-group">
                    <label for="validationServer02"><fmt:message key="label.newPassword"/>:</label>
                    <input type="password" name="password" class="form-control is-valid" id="validationServer02"
                           placeholder="<fmt:message key="label.newPassword"/>" required>
                    <div class="valid-feedback">
                        Good!
                    </div>
                </div>

                <div class="form-group">
                    <label for="validationServer03"><fmt:message key="label.repeatNewPassword"/>:</label>
                    <input type="password" name="password" class="form-control is-valid" id="validationServer03"
                           placeholder="<fmt:message key="label.repeatNewPassword"/>" required>
                    <div class="valid-feedback">
                        Good!
                    </div>
                </div>

                <div class="form-group">
                    <label for="validationServer04"><fmt:message key="label.email"/></label>
                    <input type="email" name="email" class="form-control is-valid" id="validationServer04"
                           placeholder="<fmt:message key="label.email"/>" required>
                    <div class="valid-feedback">
                        Good!
                    </div>
                </div>

                <div class="form-group">
                    <label for="validationServer05"><fmt:message key="label.name"/></label>
                    <input type="text" name="name" class="form-control is-valid" id="validationServer05"
                           placeholder="<fmt:message key="label.name"/>" required>
                    <div class="valid-feedback">
                        Good!
                    </div>
                </div>

                <div class="form-group">
                    <label for="validationServer06"><fmt:message key="label.surname"/></label>
                    <input type="text" name="surname" class="form-control is-valid" id="validationServer06"
                           placeholder="<fmt:message key="label.surname"/>" required>
                    <div class="valid-feedback">
                        Good!
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputCountry"><fmt:message key="label.country"/></label>
                    <select id="inputCountry" name="country" class="form-control">
                        <c:forEach var="country" items="${sessionScope.COUNTRIES_LIST}">
                            <option value="${country}">${country}</option>
                        </c:forEach>Co
                    </select>
                </div>

                <button onclick="XSSPrevent()" type="submit" class="btn btn-primary"><fmt:message
                        key="label.submit"/>
                </button>
                <br/>
                <br/>
                <br/>
                <br/>
            </form>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>
</body>
</html>