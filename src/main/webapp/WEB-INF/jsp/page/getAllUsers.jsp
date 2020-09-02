<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="content"/>

<html lang="${cookie['lang'].value}">
<head>
    <title>Users</title>
</head>
<body>
<div id="container">
    <br/>

    <div class="row">
        <div class="col-md-2">
            <a class="btn btn-info" href="${pageContext.request.contextPath}/addUserAdmin">
                <fmt:message key="label.addUser"/>
            </a>
        </div>
        <div class="col-md-2"></div>
        <div class="col-md-2"></div>
        <div class="col-md-2"></div>
        <div class="col-md-2"></div>
        <div class="col-md-2"></div>
    </div>
    <div>
        <br/>

        <table>
            <thead>
            <tr>
                <th><fmt:message key="label.login2"/></th>
                <th><fmt:message key="label.email"/></th>
                <th><fmt:message key="label.name"/></th>
                <th><fmt:message key="label.surname"/></th>
                <th><fmt:message key="label.country"/></th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${USERS_LIST}">

                <c:url var="userLink" value="getUserSettingsAdmin">
                    <c:param name="PORTFOLIO_USER_ID" value="${user.id}"/>
                    <c:param name="USER_BAN_STATUS" value="${user.banned}"/>
                    <c:param name="TRANSACTIONS_BAN_STATUS" value="${user.transactionBanned}"/>
                </c:url>

                <tr>
                    <td>
                        <a href="${userLink}">${user.login}</a>
                    </td>

                    <td>
                        <c:out value="${user.email}"></c:out>
                    </td>

                    <td>
                        <c:out value="${user.name}"></c:out>
                    </td>

                    <td>
                        <c:out value="${user.surname}"></c:out>
                    </td>

                    <td>
                        <c:out value="${user.country}"></c:out>
                    </td>

                    <td>
                        <form action="updateUserAdmin" method="GET">
                            <input type="hidden" name="USER_ID" value="${user.id}">
                            <button class="btn btn-link" type="submit"
                                    data-tooltip title="<fmt:message key="label.edit"/>">
                                <i class="icon-edit"></i>
                            </button>
                        </form>
                    </td>

                    <td>
                        <form id="formRemove${user.login}"
                              action="${pageContext.request.contextPath}/removeUserAdmin" method="POST">
                            <input type="hidden" name="USER_ID" value="${user.id}">
                            <button class="btn btn-link" type="submit"
                                    data-tooltip title="<fmt:message key="label.delete"/>"
                                    onclick="deleteUser('${user.login}')">
                                <i class="icon-trash"></i>
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script src="static/js/deleteUser.js"></script>
</body>
</html>
