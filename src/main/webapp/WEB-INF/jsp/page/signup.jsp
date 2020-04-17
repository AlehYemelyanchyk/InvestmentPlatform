<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<html>
<head>
    <title>Sign Up</title>
    <link type="text/css" rel="stylesheet" href="css/login.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2 align="center">Sign up</h2>
    </div>
</div>
<div id="container">
    <form action="${pageContext.request.contextPath}/signup" method="post">
        <table style="with: 50%">
            <tbody>
            <tr>
                <td>Role</td>
                <td><input type="text" name="role"/></td>
            </tr>
            <tr>
                <td>Login</td>
                <td><input type="text" name="login"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email"/></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td>Surname</td>
                <td><input type="text" name="surname"/></td>
            </tr>
            <tr>
                <td>Country</td>
                <td><select name="country">
                    <c:forEach items="${COUNTRIES_LIST}" var="country">
                        <option value="${country}">${country}</option>
                    </c:forEach>
                </select>
                </td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Submit" class="save"/></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>

</html>