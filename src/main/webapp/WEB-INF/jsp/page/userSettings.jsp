<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Settings</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2 align="center">Settings</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <p>
            <a href="${pageContext.request.contextPath}/updateUser">Edit Personal Details</a>
        </p>
        <p>
            <a href="${pageContext.request.contextPath}/getBalance">Balance</a>
        </p>
        <p>
            <a href="${pageContext.request.contextPath}/logout">Log out</a>
        </p>
    </div>
</div>
</body>
</html>
