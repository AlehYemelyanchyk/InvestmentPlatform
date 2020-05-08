<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add security</title>
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h2 align="center">Add a security</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <form action="addSecurity" method="POST">
            <table>
                <tbody>
                <tr>
                    <td><label>Name: </label></td>
                    <td><input type="text" name="name"></td>
                </tr>

                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Add" class="save"></td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>
</div>
</body>
</html>