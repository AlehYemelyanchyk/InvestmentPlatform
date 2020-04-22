<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<div id="wrapper">
    <div id="header">
        <h2 align="center">${THE_PORTFOLIO_NAME}</h2>
    </div>
</div>

<div id="container">
    <div id="content">

        <table>

            <c:forEach var="security" items="${PORTFOLIO_SECURITIES}">
                <c:url var="securityLink" value="getAllSecurityTransactions">
                    <c:param name="THE_PORTFOLIO_ID" value="${THE_PORTFOLIO_ID}"/>
                    <c:param name="THE_SECURITY_NAME" value="${security.name}"/>
                    <c:param name="THE_SECURITY_SYMBOL" value="${security.symbol}"/>
                </c:url>

                <tr>
                    <td>
                    <a href="${securityLink}">${security.name}</a>
                    </td>
                </tr>
            </c:forEach>>
        </table>
    </div>
</div>
</body>
</html>
