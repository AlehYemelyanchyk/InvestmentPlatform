<%--
  Created by IntelliJ IDEA.
  User: Aleh
  Date: 3/15/2020
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users List</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link type="text/css" rel="stylesheet" href="css/login.css">
</head>
<body>
<button type="button" name="back" onclick="history.back()">back</button>
<br/><br/>
<div id="wrapper">
    <div id="header">
        <h2 align="center">All users list</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <table>
            <tr>
                <th>Login</th>
                <th>Email</th>
            </tr>

            <c:forEach var="tempUsers" items="${USERS_LIST}">

                <tr>
                    <td>${tempUsers.login}</td>
                    <td>${tempUsers.email} </td>
                </tr>

            </c:forEach>>
        </table>
    </div>
</div>
</body>
</html>
