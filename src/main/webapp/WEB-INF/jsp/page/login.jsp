<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<link type="text/css" rel="stylesheet" href="css/login.css">
<div id="wrapper">
    <div id="header">
        <h2 align="center">Log In</h2>
    </div>
</div>

<div id="container">
    <form action="${pageContext.request.contextPath}/login" method="POST">
        <table>
            <tbody>
            <tr>
                <td><label>Login:</label></td>
                <td><input type="text" name="login"></td>
            </tr>

            <tr>
                <td><label>Password:</label></td>
                <td><input type="password" name="password"></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Log in" class="save"></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
