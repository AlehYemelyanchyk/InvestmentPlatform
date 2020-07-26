<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>

<html lang="${sessionScope.lang}">
<body>
<c:set var="REQUEST_METHOD" value="${REQUEST_METHOD}"/>
<c:set var="redirectLink" value="${REDIRECT_LINK}"/>
<c:set var="substring" value="news"/>
<c:choose>
    <c:when test="${fn:contains(redirectLink, substring)}">
        <form id="formRedirect" action="${pageContext.request.contextPath}/news" method="POST"></form>
    </c:when>
    <c:otherwise>
<%--        ${REQUEST_METHOD}--%>
        <form id="formRedirect" action="${REDIRECT_LINK}" method="${REQUEST_METHOD}"></form>
    </c:otherwise>
</c:choose>
<script>
    document.getElementById('formRedirect').submit();
</script>
</body>
</html>
