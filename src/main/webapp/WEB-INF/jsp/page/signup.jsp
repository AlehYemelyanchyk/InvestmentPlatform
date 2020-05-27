<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>

<html lang="${sessionScope.lang}">
<head>
    <title>Signup</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2 align="center"><fmt:message key="label.signup2"/></h2>
    </div>
</div>
<div id="container">
    <form action="${pageContext.request.contextPath}/signup" method="post">
        <table style="with: 50%">
            <tbody>
            <tr>
                <td><fmt:message key="label.role"/></td>
                <td><input type="text" name="role"/></td>
            </tr>
            <tr>
                <td><fmt:message key="label.login2"/></td>
                <td><input type="text" name="login"/></td>
            </tr>
            <tr>
                <td><fmt:message key="label.password"/></td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td><fmt:message key="label.email"/></td>
                <td><input type="text" name="email"/></td>
            </tr>
            <tr>
                <td><fmt:message key="label.name"/></td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td><fmt:message key="label.surname"/></td>
                <td><input type="text" name="surname"/></td>
            </tr>
            <tr>
                <td><fmt:message key="label.country"/></td>
                <td>
                    <select name="country">
                        <c:forEach var="country" items="${sessionScope.COUNTRIES_LIST}">
                            <option value="${country}">${country}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="<fmt:message key="label.submit"/>" class="save"/></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>

</html>