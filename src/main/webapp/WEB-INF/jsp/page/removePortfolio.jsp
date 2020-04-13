<%--
  Created by IntelliJ IDEA.
  User: Aleh
  Date: 4/9/2020
  Time: 8:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<input type="hidden" name="THE_PORTFOLIO_ID" value="${THE_PORTFOLIO.id}">
<input type="hidden" name="THE_PORTFOLIO_USER_ID" value="${THE_PORTFOLIO.user_id}">
<input type="hidden" name="THE_PORTFOLIO_NAME" value="${THE_PORTFOLIO.name}">
<form action="${pageContext.request.contextPath}/deletePortfolio" method="post">
</form>
</body>
</html>
