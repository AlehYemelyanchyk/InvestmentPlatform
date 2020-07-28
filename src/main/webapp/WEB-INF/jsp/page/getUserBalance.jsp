<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>

<html lang="${sessionScope.lang}">
<head>
    <title>All securities</title>
</head>

<body>
<div id="container">
    <br/>

    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <div>
                <c:set var="balance" value="${CURRENT_USER_BALANCE}"/>
                <h4>$<fmt:formatNumber type="number" minFractionDigits="2"
                                  maxFractionDigits="2" value="${balance}"/></h4>
            </div>
            <div>
                <h4><a href="${pageContext.request.contextPath}/deposit">
                    <fmt:message key="label.deposit"/>
                </a></h4>
            </div>
            <div>
                <c:choose>
                <c:when test="${CURRENT_USER_BALANCE <= 0}">
                    <h4><a hidden href="${pageContext.request.contextPath}/withdraw">
                    </c:when>

                    <c:otherwise>
                        <h4><a href="${pageContext.request.contextPath}/withdraw">
                        <fmt:message key="label.withdraw"/>
                    </a></h4>
                    </c:otherwise>
                    </c:choose>
            </div>
            <div>
                <h4><a href="${pageContext.request.contextPath}/loan">
                    <fmt:message key="label.loan"/>
                </a></h4>
            </div>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>




</body>
</html>
