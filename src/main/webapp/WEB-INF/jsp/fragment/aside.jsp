<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<div id="container">
    <div id="content">
        <div class="panel panel-default">
            <div class="panel-header"><h4><fmt:message key="label.menu"/></h4></div>
            <div class="panel-body">
                <div class="list-group">
                    <a href="getAllUserPortfolios" class="list-group-item"><fmt:message key="label.portfolios"/></a>
                    <a href="getAllSecurities" class="list-group-item"><fmt:message key="label.securities"/></a>
                </div>
<%--                <div class="panel-footer">--%>
<%--                    <button type="button" name="back"--%>
<%--                            onclick="history.back()"--%>
<%--                            class="btn btn-light"><fmt:message key="label.back"/>--%>
<%--                    </button>--%>
<%--                </div>--%>
            </div>
        </div>
    </div>
</body>
</html>
