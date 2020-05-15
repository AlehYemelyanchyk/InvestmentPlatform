<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update user</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2 align="center">Edit Personal Details</h2>
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
                <td><label>Old password: </label></td>
                <td><input type="password" name="oldPassword" value="${CURRENT_USER.password}"></td>
            </tr>

            <tr>
                <td><label>New password: </label></td>
                <td><input type="password" name="newPassword"></td>
            </tr>

            <tr>
                <td><label>Repeat new password: </label></td>
                <td><input type="password" name="CURRENT_USER_PASSWORD"></td>
            </tr>

            <tr>
                <td><label>Email: </label></td>
                <td><input type="text" name="CURRENT_USER_EMAIL" value="${CURRENT_USER.email}"></td>
            </tr>

            <tr>
                <td><label>Name: </label></td>
                <td><input type="text" name="CURRENT_USER_NAME" value="${CURRENT_USER.name}"></td>
            </tr>

            <tr>
                <td><label>Surname: </label></td>
                <td><input type="text" name="CURRENT_USER_SURNAME" value="${CURRENT_USER.surname}"></td>
            </tr>

            <tr>
                <td><label>Country: </label></td>
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
                <%--                <c:if test="${CURRENT_USER.password} Eq ${oldPassword}">--%>
                <%--                    --%>
                <%--                </c:if>--%>
                <td><input type="submit" value="Update" class="save"></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>