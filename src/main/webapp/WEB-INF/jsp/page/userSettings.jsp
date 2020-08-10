<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="content"/>

<html lang="${cookie['lang'].value}">
<head>
    <title>Settings</title>
</head>
<body>
<div id="container">
    <br/>

    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <div>
                <h4><a href="${pageContext.request.contextPath}/updateUser"><fmt:message
                        key="label.personalDetails"/></a></h4>
            </div>
            <div>
                <h4><a href="${pageContext.request.contextPath}/getBalance"><fmt:message
                        key="label.balance"/></a></h4>
            </div>
            <div>
                <h4><a href="${pageContext.request.contextPath}/logout"><fmt:message
                        key="label.logOut"/></a></h4>
            </div>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>
</body>
</html>
