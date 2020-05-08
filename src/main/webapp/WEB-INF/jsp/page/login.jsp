<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div id="container">
    <form action="${pageContext.request.contextPath}/login" method="POST">
        <table>
            <tbody>
            <tr>
                <td><label>Login:</label></td>
                <td><input type="text" name="login" placeholder="Login" autocomplete="off"></td>
            </tr>

            <tr>
                <td><label>Password:</label></td>
                <td><input type="password" name="password" placeholder="Password" autocomplete="off"></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" class="btn btn-primary" value="Log in" class="save"></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
