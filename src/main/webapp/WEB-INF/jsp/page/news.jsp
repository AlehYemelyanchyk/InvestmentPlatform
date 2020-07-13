<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>
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
<div class="container">
    <br/>

    <div class='row'>
        <div class='col-md-8'>
            <div style="border-bottom: 1px solid gray" class="row single-news">
                <div class="col-md-5">
                    <img style="width:100%" src="https://images.wsj.net/im-207787?width=300&size=1.5&pixel_ratio=1">
                </div>
                <div class="col-md-7">
                    <h4>Connecticut’s Big Bet on the Suburbs Might Finally Pay Off</h4>
                    <small>U.S.</small>
                    <p>The state never recovered from the last recession, as people passed over its pastoral towns to live in big cities. Officials now hope to capitalize on interest from New Yorkers looking for more space in the midst of Covid-19.</p>
                    <a href="https://www.wsj.com/articles/connecticut-suburbs-coronavirus-new-york-real-estate-houses-for-sale-weston-fairfield-11594558882"
                       class="btn btn-sm btn-primary" style="float:right;">Read more >></a>
                </div>
            </div>
            <div style="border-bottom: 1px solid gray" class="row single-news">
                <div class="col-md-5">
                    <img style="width:100%" src="https://images.wsj.net/im-208113?width=300&size=1.5&pixel_ratio=1">
                </div>
                <div class="col-md-7">
                    <h4>Derby’s Take: After Latest Data, a Requiem for Fed Repos</h4>
                    <small>CENTRAL BANKS COMMENTARY</small>
                    <p>The first wave of the Federal Reserve’s campaign to aid financial markets during the coronavirus pandemic appears to have run its course, with the Fed reporting its repurchase agreements with major financial institutions had fallen to zero for the first time since early September.</p>
                    <a href="https://www.wsj.com/articles/derbys-take-after-latest-data-a-requiem-for-fed-repos-11594632600"
                       class="btn btn-sm btn-primary" style="float:right;">Read more >></a>
                </div>
            </div>
            <div style="border-bottom: 1px solid gray" class="row single-news">
                <div class="col-md-5">
                    <img style="width:100%" src="https://images.wsj.net/im-208138?width=300&size=1.5&pixel_ratio=1">
                </div>
                <div class="col-md-7">
                    <h4>Why China Isn’t Expected to Power a Global Recovery</h4>
                    <small>ECONOMY</small>
                    <p>During the 2008-09 financial crisis, China’s soaring demand boosted growth world-wide. China isn’t poised to help as much now, as the country shows restraint on stimulus spending and takes advantage of increased self sufficiency.</p>
                    <a href="https://www.wsj.com/articles/why-china-isnt-expected-to-power-a-global-recovery-11594555200"
                       class="btn btn-sm btn-primary" style="float:right;">Read more >></a>
                </div>
            </div>
        </div>
        <div class='col-md-4'>
            <div class="container">
                <h4>Last traded:</h4>
                <table>
                    <thead>
                    <tr>
                        <th><fmt:message key="label.symbol"/></th>
                        <th><fmt:message key="label.price"/></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="transaction" items="${TRANSACTIONS_LIST}">

                        <c:url var="securityLink" value="getSecurity">
                            <c:param name="SECURITY_SYMBOL" value="${transaction.securitySymbol}"/>
                        </c:url>

                        <tr>
                            <td>
                                <a href="${securityLink}">${transaction.securitySymbol}</a>
                            </td>

                            <td>
                                <c:out value="${transaction.price}"></c:out>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script src="static/js/news.js"></script>
<script>
    let url = 'http://newsapi.org/v2/top-headlines?' +
        'country=us&' +
        'apiKey=ed709567b8a640a891ce860a1380e973';
    let req = new Request(url);
    fetch(req)
        .then(function (response) {
            console.log(response.json());
        })
</script>
</body>
</html>
