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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="static/css/app.css">
    <link rel="stylesheet" href="static/css/tabsStyle.css">
    <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
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
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <script src="static/js/app.js"></script>
    <script src="static/js/hideElement.js"></script>
    <script src="static/js/pagination.js"></script>
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