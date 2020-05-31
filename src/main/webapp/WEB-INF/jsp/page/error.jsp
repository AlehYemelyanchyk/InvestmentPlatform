<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<div>
    <p>
    <h2>Code: ${STATUS_CODE}</h2>
    </p>
    <p>
        <c:out value="${ERROR_ATTRIBUTE}"/>
    </p>
    <c:choose>
        <c:when test="${STATUS_CODE == 403}">You don't have permission to view this resource.</c:when>
        <c:when test="${STATUS_CODE == 404}">Requested resource not found.</c:when>
        <c:otherwise>Can't process this request. Please, try later...</c:otherwise>
    </c:choose>
</div>
</body>
</html>
