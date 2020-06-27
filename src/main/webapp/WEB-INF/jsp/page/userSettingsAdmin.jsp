<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>

<html lang="${sessionScope.lang}">
<head>
    <title>Settings</title>
</head>
<body>
<div id="container">
    <br/>

    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <div class="row">
                <div class="col-md-8">
                    <c:set var="USER_ID" value="${USER_ID}"/>

                    <c:url var="userPortfolios" value="getAllUserPortfoliosAdmin">
                        <c:param name="USER_ID" value="${USER_ID}"/>
                    </c:url>
                    <c:url var="updateUser" value="updateUserAdmin">
                        <c:param name="USER_ID" value="${USER_ID}"/>
                    </c:url>

                    <div>
                        <h4>
                            <a href="${userPortfolios}">Portfolios</a>
                        </h4>
                    </div>

                    <div>
                    </div>

                    <div>
                        <h4> Ban status </h4>
                    </div>
                    <div>
                        <h4> Transactions ban </h4>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="custom-control custom-switch">
                    </div>
                    <div class="custom-control custom-switch">
                        <form action="${pageContext.request.contextPath}/banUser" method="POST">
                            <c:choose>
                                <c:when test="${USER_BAN_STATUS == 1}">
                                    <input checked type="checkbox" name="USER_BAN_STATUS" class="custom-control-input"
                                           id="customSwitch1">
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" name="USER_BAN_STATUS" class="custom-control-input"
                                           id="customSwitch1">
                                </c:otherwise>
                            </c:choose>
                            <label class="custom-control-label" for="customSwitch1"></label>
                        </form>
                    </div>
                    <div class="custom-control custom-switch">
                        <form action="${pageContext.request.contextPath}/banUserTransactions" method="POST">
                            <c:choose>
                                <c:when test="${TRANSACTIONS_BAN_STATUS == 1}">
                                    <input checked type="checkbox" name="TRANSACTIONS_BAN_STATUS" class="custom-control-input"
                                           id="customSwitch2">
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" name="TRANSACTIONS_BAN_STATUS" class="custom-control-input"
                                           id="customSwitch2">
                                </c:otherwise>
                            </c:choose>
                            <label class="custom-control-label" for="customSwitch2"></label>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-4"></div>
</div>
</div>
</body>
</html>
