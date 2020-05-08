<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Error</h2>
    </div>
</div>

<div id="container">
    <table>
            <c:out value="${ERROR_ATTRIBUTE}"/>
        </table>
    </form>
</div>
</body>
</html>
