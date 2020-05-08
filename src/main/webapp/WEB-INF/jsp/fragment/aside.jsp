<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<div id="container">
    <div id="content">
        <div class="panel panel-default">
            <div class="panel-header"><h4>Menu</h4></div>
            <div class="panel-body">
                <div class="list-group">
                    <a href="getAllUserPortfolios"   class="list-group-item">Portfolios</a>
                    <a href="getAllSecurities" class="list-group-item">Securities</a>
                </div>
                <div class="panel-footer">
                    <button type="button" name="back"
                            onclick="history.back()"
                            class="btn btn-secondaryu">Back
                    </button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
