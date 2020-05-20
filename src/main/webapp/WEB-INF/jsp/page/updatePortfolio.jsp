<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update portfolio</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2 align="center">Edit portfolio</h2>
    </div>
</div>

<div id="container">
    <form action="${pageContext.request.contextPath}/updatePortfolio" method="POST">
        <table>
            <tbody>

            <tr>
                <td><input type="hidden" name="PORTFOLIO_ID" value="${PORTFOLIO.id}"></td>
                <td><input type="hidden" name="PORTFOLIO_USER_ID" value="${PORTFOLIO.user_id}"></td>
            </tr>

            <tr>
                <td><label>Name: </label></td>
                <td><input type="text" name="name" value="${PORTFOLIO.name}"></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Update" class="save"></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>