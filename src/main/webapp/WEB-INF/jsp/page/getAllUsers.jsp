<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>

<html lang="${sessionScope.lang}">
<head>
    <title>Users</title>
</head>
<body>
<div id="container">
    <br/>

    <div class="row">
        <div class="col-md-2">
            <a class="btn btn-dark" href="${pageContext.request.contextPath}/addUser"
               data-tooltip title="Add User">
                <i class="icon-plus-sign-alt"></i>
            </a>
        </div>
        <div class="col-md-2"></div>
        <div class="col-md-2"></div>
        <div class="col-md-2"></div>
        <div class="col-md-2"></div>
        <div class="col-md-2"></div>
    </div>

    <br/>

    <div class="row">
        <div class="col-md-2"><h4>Login</h4></div>
        <div class="col-md-2"><h4>Password</h4></div>
        <div class="col-md-2"><h4>Email</h4></div>
        <div class="col-md-2"><h4>Name</h4></div>
        <div class="col-md-2"><h4>Surname</h4></div>
        <div class="col-md-2"><h4>Country</h4></div>
        <c:forEach var="user" items="${USERS_LIST}">
            <div class="col-md-2">
                <c:url var="userLink" value="getAllUserPortfoliosAdmin">
                    <c:param name="PORTFOLIO_USER_ID" value="${user.id}"/>
                </c:url>

                <h6><a href="${userLink}">${user.login}</a></h6>
            </div>
            <div class="col-md-2"><h6><a>${user.password}</a></h6></div>
            <div class="col-md-2"><h6><a>${user.email}</a></h6></div>
            <div class="col-md-2"><h6><a>${user.name}</a></h6></div>
            <div class="col-md-2"><h6><a>${user.surname}</a></h6></div>
            <div class="col-md-2"><h6><a>${user.country}</a></h6></div>
        </c:forEach>
    </div>
</div>
</body>
</html>
