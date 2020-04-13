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
        <h2 align="center">All portfolios</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <input type="button" value="Create a New Portfolio"
               onclick="window.location.href='addPortfolio'; return false;"
               class="add-button"
        />
        <table>

            <tr>
                <th>Name</th>
                <th>Action</th>
            </tr>

            <c:forEach var="tempPortfolio" items="${PORTFOLIOS_LIST}">

                <c:url var="updateLink" value="updatePortfolio.jsp">
                    <c:param name="portfolioId" value="${tempPortfolio.id}"/>
                </c:url>

                <c:url var="removeLink" value="removePortfolio.jsp" >
                    <c:param name="portfolioId" value="${tempPortfolio.id}"/>
                </c:url>

                <tr>
                    <td>${tempPortfolio.name}</td>
                    <td>
                        <a href="${updateLink}">Update</a>
                        |
                        <a href="${removeLink}"
                           onclick="if (!(confirm('Are you sure you want to delete this portfolio?'))) return false">
                            Delete</a>
                    </td>
                </tr>

            </c:forEach>>
        </table>
    </div>
</div>
</body>
</html>
