<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>

<html lang="${sessionScope.lang}">
<head>
    <title>Login</title>
</head>
<body>
<div id="container">
    <br/>

    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form action="${pageContext.request.contextPath}/login" method="POST">
                <div class="form-group">
                    <label for="exampleInputEmail1"><fmt:message key="label.login2"/></label>
                    <input type="text" name="login" class="form-control" id="exampleInputEmail1"
                           placeholder=<fmt:message key="label.login2"/>>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1"><fmt:message key="label.password"/></label>
                    <input type="password" name="password" class="form-control" id="exampleInputPassword1"
                           placeholder="<fmt:message key="label.password"/>">
                </div>
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Remember me</label>
                </div>
                <button onclick="XSSPrevent()" type="submit" class="btn btn-primary"><fmt:message
                        key="label.submit"/>
                </button>
            </form>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>
</body>
</html>
