<%--
  Created by IntelliJ IDEA.
  User: Aleh
  Date: 3/23/2020
  Time: 8:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<html>
<head>
    <title>Error</title>

    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link type="text/css" rel="stylesheet" href="css/login.css">
</head>
<body>
<button type="button" name="back" onclick="history.back()">back</button>
<br/><br/>
<div id="wrapper">
    <div id="header">
        <h2>Error</h2>
    </div>
</div>

<div id="container">
    <table>
            <c:out value="${error}"/>
        </table>
    </form>
</div>
</body>
</html>
