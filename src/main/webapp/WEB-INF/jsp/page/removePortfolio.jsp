<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<tr>
    <td><input type="hidden" name="THE_PORTFOLIO_ID" value="${THE_PORTFOLIO_ID}"></td>
</tr>
<form action="${pageContext.request.contextPath}/removePortfolio" method="post">
</form>
</body>
</html>
