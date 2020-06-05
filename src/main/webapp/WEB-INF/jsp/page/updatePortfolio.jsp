<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>

<html lang="${sessionScope.lang}">
<head>
    <title>Update portfolio</title>
</head>
<body>
<div id="header">
    <h4 align="center">
        <fmt:message key="label.editPortfolio"/>
    </h4>
</div>

<div id="container">
    <form action="${pageContext.request.contextPath}/updatePortfolio" method="POST">
        <table class="login">
            <tbody>
            <tr>
                <td><input type="hidden" name="PORTFOLIO_ID" value="${PORTFOLIO.id}"></td>
                <td><input type="hidden" name="PORTFOLIO_USER_ID" value="${PORTFOLIO.user_id}"></td>
            </tr>

            <tr>
                <td><label><fmt:message key="label.name"/>: </label></td>
                <td><input type="text" name="name" value="${PORTFOLIO.name}"></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" class="btn btn-primary" value="<fmt:message key="label.submit"/>"
                           class="save" onclick="XSSPrevent()"></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>