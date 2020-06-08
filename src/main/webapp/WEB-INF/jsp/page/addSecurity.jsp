<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>

<html lang="${sessionScope.lang}">
<head>
    <title>Add security</title>
</head>

<body>
<%--<div id="header">--%>
<%--    <h4 align="center"><fmt:message key="label.addSecurity"/></h4>--%>
<%--</div>--%>

<div id="container">
    <div id="content">
        <form action="addSecurity" method="POST">
            <table>
                <tbody>
                <tr>
                    <td><label><fmt:message key="label.name"/>: </label></td>
                    <td><input type="text" name="name"></td>
                </tr>

                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="<fmt:message key="label.add"/>"
                               class="save" onclick="XSSPrevent()"></td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>
</div>
</body>
</html>