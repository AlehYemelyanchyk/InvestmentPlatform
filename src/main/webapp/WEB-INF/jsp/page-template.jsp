<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>InvestUj</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
<%--          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">--%>
    <link rel="stylesheet" href="static/css/font-awesome.css">
    <link rel="stylesheet" href="static/css/bootstrap-table.min.css">
    <link rel="stylesheet" href="static/css/app.css">
    <link rel="stylesheet" href="static/css/tabsStyle.css">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
<header>
    <c:choose>
        <c:when test="${CURRENT_USER_ROLE == 1}">
            <jsp:include page="fragment/headAdmin.jsp"/>
        </c:when>
        <c:otherwise>
            <jsp:include page="fragment/head.jsp"/>
        </c:otherwise>
    </c:choose>
</header>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <c:choose>

                <c:when test="${CURRENT_PAGE != null}">
                    <jsp:include page="${CURRENT_PAGE}"/>
                </c:when>
                <c:otherwise>
                    <jsp:include page="/WEB-INF/jsp/page/news.jsp"/>
                </c:otherwise>

            </c:choose>
        </div>
    </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="static/js/jquery-3.5.1.min.js"></script>
    <script src="static/js/popper.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
    <script src="static/js/app.js"></script>
    <script src="static/js/ban.js"></script>
    <script src="static/js/bootstrap-table.min.js"></script>
    <script src="static/js/formValidation.js"></script>
    <script src="static/js/hideElement.js"></script>
    <script src="static/js/isClosed.js"></script>
    <script src="static/js/isDeletePortfolio.js"></script>
    <script src="static/js/tabs.js"></script>
    <script src="static/js/tooltip.js"></script>
    <script src="static/js/XSSPrevent.js"></script>
</div>
</body>
<footer class="fixed-bottom">
    <div class="footer-text">
        <jsp:include page="fragment/footer.jsp"/>
    </div>
</footer>
</html>