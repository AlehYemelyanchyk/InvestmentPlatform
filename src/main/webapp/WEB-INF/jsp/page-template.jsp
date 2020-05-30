<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>

<!doctype html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Investment Platform</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<%--    <link rel="stylesheet" href="static/css/fontawesome.css">--%>
    <link rel="stylesheet" href="static/css/app.css">
    <link rel="stylesheet" href="static/css/tabsStyle.css">
</head>
<body>
<header>
    <jsp:include page="fragment/head.jsp"/>
</header>
<div class="">
    <div class="row">
        <aside class="col-lg-2">
            <jsp:include page="fragment/aside.jsp"/>
        </aside>
        <main class="col-lg-10">
            <div class="panel-body">
                <jsp:include page="${CURRENT_PAGE}"/>
            </div>
        </main>
    </div>
</div>
<footer>
    <jsp:include page="fragment/footer.jsp"/>
</footer>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="static/js/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
<script src="static/js/app.js"></script>
<script src="static/js/tabs.js"></script>
<script src="static/js/pagination.js"></script>
<%--<script src="static/js/XSSPrevent.js"></script>--%>
</body>
</html>