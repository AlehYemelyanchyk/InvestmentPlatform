<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users List</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2 align="center">${portfolioName}</h2>
    </div>
</div>

<div id="container">
    <div id="content">

        <table>

            <c:forEach var="security" items="${PORTFOLIO_SECURITIES}">
                <tr>
                    <td>
                    <a href="${portfolioLink}">${security.name}</a>
                    </td>
                </tr>
            </c:forEach>>
        </table>
    </div>
</div>
</body>
</html>
