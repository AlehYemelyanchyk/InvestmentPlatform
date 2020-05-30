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
<div id="wrapper">
    <div id="header">
        <h2 align="center"><fmt:message key="label.editPersonalDetails"/></h2>
    </div>
</div>

<div id="container">
    <form action="${pageContext.request.contextPath}/updateUser" method="POST">
        <table>
            <tbody>

            <tr>
                <td><input type="hidden" name="CURRENT_USER_ID" value="${CURRENT_USER.id}"></td>
                <td><input type="hidden" name="CURRENT_USER_LOGIN" value="${CURRENT_USER.login}"></td>
                <td><input type="hidden" name="CURRENT_USER_ROLE" value="${CURRENT_USER.role}"></td>
            </tr>

            <tr>
                <td><label><fmt:message key="label.oldPassword"/>: </label></td>
                <td><input type="password" name="oldPassword" value="${CURRENT_USER.password}"></td>
            </tr>

            <tr>
                <td><label><fmt:message key="label.newPassword"/>: </label></td>
                <td><input type="password" name="newPassword"></td>
            </tr>

            <tr>
                <td><label><fmt:message key="label.repeatNewPassword"/>: </label></td>
                <td><input type="password" name="CURRENT_USER_PASSWORD"></td>
            </tr>

            <tr>
                <td><label><fmt:message key="label.email"/>: </label></td>
                <td><input type="text" name="CURRENT_USER_EMAIL" value="${CURRENT_USER.email}"></td>
            </tr>

            <tr>
                <td><label><fmt:message key="label.name"/>: </label></td>
                <td><input type="text" id="input" name="CURRENT_USER_NAME" value="${CURRENT_USER.name}"></td>
            </tr>

            <tr>
                <td><label><fmt:message key="label.surname"/>: </label></td>
                <td><input type="text" id="input2" name="CURRENT_USER_SURNAME" value="${CURRENT_USER.surname}"></td>
            </tr>

            <tr>
                <td><label><fmt:message key="label.country"/>: </label></td>
                <td>
                    <select name="CURRENT_USER_COUNTRY">
                        <c:forEach var="country" items="${sessionScope.COUNTRIES_LIST}">
                            <option value="${country}">${country}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value="<fmt:message key="label.submit"/>" class="save"></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>