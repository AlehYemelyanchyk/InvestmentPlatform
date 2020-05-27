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
    <form action="${pageContext.request.contextPath}/login" method="POST">
        <table>
            <tbody>
            <tr>
                <td><label><fmt:message key="label.login2"/>:</label></td>
                <td><input type="text" name="login" placeholder="Login" autocomplete="off"></td>
            </tr>

            <tr>
                <td><label><fmt:message key="label.password"/>:</label></td>
                <td><input type="password" name="password" placeholder="Password" autocomplete="off"></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" class="btn btn-primary" value="<fmt:message key="label.login"/>" class="save"></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
