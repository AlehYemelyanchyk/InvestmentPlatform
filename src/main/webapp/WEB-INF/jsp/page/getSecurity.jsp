<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>

<html lang="${sessionScope.lang}">
<head>
    <script src="https://www.chartjs.org/dist/2.9.3/Chart.min.js"></script>
    <script src="https://www.chartjs.org/samples/latest/utils.js"></script>
    <link rel="stylesheet" href="static/css/chart.min.css">
    <title>Security</title>
</head>
<body>

<input type="hidden" id="dates" value="${DATES}"/>
<input type="hidden" id="prices" value="${PRICES}"/>
<input type="hidden" id="securityName" value="${SECURITY.name}"/>


<div id="container">
    <form action="${pageContext.request.contextPath}/signup" method="post">
        <table style="with: 50%">
            <thead>
            <tr>
                <th><fmt:message key="label.symbol"/></th>
                <th><fmt:message key="label.name"/></th>
                <th><fmt:message key="label.exchange"/></th>
                <th><fmt:message key="label.currentPrice"/></th>
                <th><fmt:message key="label.yearChange"/>, %</th>
                <th><fmt:message key="label.dividends"/></th>
                <th><fmt:message key="label.type"/></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    <c:out value="${SECURITY.symbol}"></c:out>
                </td>

                <td>
                    <c:out value="${SECURITY.name}"></c:out>
                </td>

                <td>
                    <c:out value="${SECURITY.exchange}"></c:out>
                </td>

                <td>
                    <c:out value="${SECURITY.currentPrice}"></c:out>
                </td>

                <td>
                    <c:out value="${SECURITY.yearChangePercents}"></c:out>
                </td>

                <td>
                    <c:out value="${SECURITY.dividends}"></c:out>
                </td>

                <td>
                    <c:out value="${SECURITY.securityType}"></c:out>
                </td>
            </tr>
            </tbody>
        </table>
        <div align="center">
            <br/>
            <canvas id="canvas"></canvas>
        </div>
    </form>
</div>
<script>
    let randomScalingFactor = function () {
        return Math.round(Math.random() * 100);
    };

    let dates = document.getElementById("dates").getAttribute("value");
    let prices = document.getElementById("prices").getAttribute("value");
    let securityname = document.getElementById("securityName").getAttribute("value");
    let datestrimmed = dates.substring(1, dates.length - 1);
    let pricepoints = Array.from((prices.split(", ")));
    let datelabels = Array.from((datestrimmed.split(", ")));

    let config = {
        type: 'line',
        data: {
            labels: datelabels,
            datasets: [{
                label: securityname,
                data: pricepoints,
                borderColor: window.chartColors.green,
                backgroundColor: 'rgba(0, 0, 0, 0)',
                fill: false,
                lineTension: 0
            }]
        },
        options: {
            responsive: true,
            title: {
                display: true,
                text: 'Nasdaq Delayed Price. Currency in USD'
            },
            tooltips: {
                mode: 'index'
            },
            scales: {
                xAxes: [{
                    display: true,
                    scaleLabel: {
                        display: true
                    }
                }],
                yAxes: [{
                    display: true,
                    scaleLabel: {
                        display: true,
                        labelString: 'Value'
                    },
                    ticks: {
                        suggestedMin: 0,
                        suggestedMax: 200,
                    }
                }]
            }
        }
    };

    window.onload = function () {
        var ctx = document.getElementById('canvas').getContext('2d');
        window.myLine = new Chart(ctx, config);
    };
</script>
</body>

</html>