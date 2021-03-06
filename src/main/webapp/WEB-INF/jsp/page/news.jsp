<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="content"/>

<html lang="${cookie['lang'].value}">
    <title>News API</title>
    <style>
        img {
            height: 200px;
            width: 250px;
        }
    </style>
</head>
<body>
<br/>

<div class='row'>
    <div class='col-md-9'>
        <div class="row single-news">
            <div class="col-md-5">
                <img style="width:100%" src="https://images.wsj.net/im-207787?width=300&size=1.5&pixel_ratio=1">
            </div>
            <div class="col-md-7">
                <h4>Connecticut’s Big Bet on the Suburbs Might Finally Pay Off</h4>
                <small>U.S.</small>
                <p>The state never recovered from the last recession, as people passed over its pastoral towns to live
                    in big cities. Officials now hope to capitalize on interest from New Yorkers looking for more space
                    in the midst of Covid-19.</p>
                <a href="https://www.wsj.com/articles/connecticut-suburbs-coronavirus-new-york-real-estate-houses-for-sale-weston-fairfield-11594558882"
                   class="btn btn-sm btn-primary" style="float:right;">
                    <fmt:message key="label.readMore"/> >></a>
            </div>
        </div>
        <div class="row single-news">
            <div class="col-md-5">
                <img style="width:100%" src="https://images.wsj.net/im-208113?width=300&size=1.5&pixel_ratio=1">
            </div>
            <div class="col-md-7">
                <h4>Derby’s Take: After Latest Data, a Requiem for Fed Repos</h4>
                <small>CENTRAL BANKS COMMENTARY</small>
                <p>The first wave of the Federal Reserve’s campaign to aid financial markets during the coronavirus
                    pandemic appears to have run its course, with the Fed reporting its repurchase agreements with major
                    financial institutions had fallen to zero for the first time since early September.</p>
                <a href="https://www.wsj.com/articles/derbys-take-after-latest-data-a-requiem-for-fed-repos-11594632600"
                   class="btn btn-sm btn-primary" style="float:right;">
                    <fmt:message key="label.readMore"/> >></a>
            </div>
        </div>
        <div class="row single-news">
            <div class="col-md-5">
                <img style="width:100%" src="https://images.wsj.net/im-208138?width=300&size=1.5&pixel_ratio=1">
            </div>
            <div class="col-md-7">
                <h4>Why China Isn’t Expected to Power a Global Recovery</h4>
                <small>ECONOMY</small>
                <p>During the 2008-09 financial crisis, China’s soaring demand boosted growth world-wide. China isn’t
                    poised to help as much now, as the country shows restraint on stimulus spending and takes advantage
                    of increased self sufficiency.</p>
                <a href="https://www.wsj.com/articles/why-china-isnt-expected-to-power-a-global-recovery-11594555200"
                   class="btn btn-sm btn-primary" style="float:right;">
                    <fmt:message key="label.readMore"/> >></a>
            </div>
        </div>
    </div>
    <div class='col-md-3'>
        <div class="container container-bordered2">
            <h4><fmt:message key="label.delistSoon"/>:</h4>
            <table>
                <thead>
                <tr>
                    <th><fmt:message key="label.symbol"/></th>
                    <th><fmt:message key="label.date"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="security" items="${SECURITIES_LIST}">

                    <tr>
                        <td>
                            <form action="${pageContext.request.contextPath}/getSecurity" method="POST">
                                <input type="hidden" name="SECURITY_SYMBOL" value="${security.symbol}">
                                <button class="btn btn-link" type="submit">
                                        ${security.symbol}
                                </button>
                            </form>
                        </td>

                        <td>
                            <c:out value="${security.stopTradeDate}"></c:out>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="container container-bordered2">
            <h4><fmt:message key="label.lastTraded"/>:</h4>
            <table>
                <thead>
                <tr>
                    <th><fmt:message key="label.symbol"/></th>
                    <th><fmt:message key="label.price"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="transaction" items="${TRANSACTIONS_LIST}">

                    <tr>
                        <td>
                            <form action="${pageContext.request.contextPath}/getSecurity" method="POST">
                                <input type="hidden" name="SECURITY_SYMBOL" value="${transaction.securitySymbol}">
                                <button class="btn btn-link" type="submit">
                                        ${transaction.securitySymbol}
                                </button>
                            </form>
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
</body>
</html>
