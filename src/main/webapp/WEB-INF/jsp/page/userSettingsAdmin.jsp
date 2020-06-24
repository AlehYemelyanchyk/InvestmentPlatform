<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>

<html lang="${sessionScope.lang}">
<head>
    <title>Settings</title>
</head>
<body>
<div id="container">
    <br/>

    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">

            <c:set var="USER_ID" value="${USER_ID}"/>

            <c:url var="userPortfolios" value="getAllUserPortfoliosAdmin">
                <c:param name="USER_ID" value="${USER_ID}"/>
            </c:url>
            <c:url var="updateUser" value="updateUserAdmin">
                <c:param name="USER_ID" value="${USER_ID}"/>
            </c:url>

            <div>
                <h4>
                    <a href="${userPortfolios}">Portfolios</a>
                </h4>
            </div>

            <div>
                <h4>
                    <a href="${updateUser}">Personal details</a>
                </h4>
            </div>

            <div>
                <h4><a href="${pageContext.request.contextPath}/Ban">Ban</a></h4>
            </div>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>
</body>
</html>
