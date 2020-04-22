<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
                <td><input type="hidden" name="THE_PORTFOLIO_ID" value="${THE_PORTFOLIO.id}"></td>
                <td><input type="hidden" name="THE_PORTFOLIO_USER_ID" value="${THE_PORTFOLIO.user_id}"></td>
                <td><input type="hidden" name="THE_PORTFOLIO_NAME" value="${THE_PORTFOLIO.name}"></td>
            </tr>

            <tr>
                <td><label>Name: </label></td>
                <td><input type="text" name="name" value="${THE_PORTFOLIO.name}"></td>
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