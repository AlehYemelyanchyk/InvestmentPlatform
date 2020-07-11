<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<html>
<head>
    <title>News API</title>
    <style>
        img {
            height: 200px;
            width: 250px;
        }
    </style>
</head>
<body>
<div class="container news"></div>
<script src="static/js/news.js"></script>
<script>
    var url = 'http://newsapi.org/v2/top-headlines?' +
        'country=us&' +
        'apiKey=ed709567b8a640a891ce860a1380e973';
    var req = new Request(url);
    fetch(req)
        .then(function(response) {
            console.log(response.json());
        })
</script>
</body>
</html>
