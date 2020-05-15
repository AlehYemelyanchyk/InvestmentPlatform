<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="ex" uri="WEB-INF/tags.tld" %>--%>
<html>
<head>
    <title>Portfolios</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2 align="center">All portfolios</h2>
<%--        <c:out/>--%>
    </div>
</div>

<div id="container">
    <div id="content">
        <input type="button" value="Create a New Portfolio"
               onclick="window.location.href='addPortfolio'; return false;"
               class="btn btn-primary"
        />
        <table>

            <tr>
                <th>Name</th>
                <th>Action</th>
            </tr>

            <c:forEach var="portfolio" items="${PORTFOLIOS_LIST}">

                <c:url var="portfolioLink" value="getAllPortfolioSecurities">
                    <c:param name="PORTFOLIO_NAME" value="${portfolio.name}"/>
                    <c:param name="PORTFOLIO_ID" value="${portfolio.id}"/>
                </c:url>

                <c:url var="updateLink" value="updatePortfolio">
                    <c:param name="PORTFOLIO_ID" value="${portfolio.id}"/>
                </c:url>

                <c:url var="removeLink" value="removePortfolio">
                    <c:param name="PORTFOLIO_ID" value="${portfolio.id}"/>
                </c:url>

                <tr>
                    <td>
                        <a href="${portfolioLink}">${portfolio.name}</a>
                    </td>
                    <td>
                        <a href="${updateLink}">Edit</a>
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
