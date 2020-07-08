<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>

<html lang="${sessionScope.lang}">
<head>
    <title>Users</title>
</head>
<body>
<div id="container">
    <br/>

    <div class="row">
        <div class="col-md-2">
            <a class="btn btn-dark" href="${pageContext.request.contextPath}/addUserAdmin"
               data-tooltip title="Add User">
                <i class="icon-plus-sign-alt"></i>
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
                            <button class="btn btn-dark" type="submit"
                                    data-tooltip title="<fmt:message key="label.edit"/>">
                                <i class="icon-edit"></i>
                            </button>
                        </form>
                    </td>

                    <td>
                        <form action="removeUserAdmin" method="POST">
                            <input type="hidden" name="USER_ID" value="${user.id}">
                            <button class="btn btn-dark" type="submit"
                                    data-tooltip title="<fmt:message key="label.delete"/>"
                                    onclick="if (!(confirm('<fmt:message
                                            key="label.deleteUserWarning"/>'))) return false">
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
</body>
</html>
