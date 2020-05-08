<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>All securities</title>
    <link href="static/css/bootstrap.min.css" rel="stylesheet"/>
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h2 align="center">Securities</h2>
    </div>
</div>

<div class="container">
    <div class="form-group">
        <select name="state" id="maxRows" class="form-control" style="width:150px;">
            <option value="5000">Show All</option>
            <option value="5">5</option>
            <option value="10">10</option>
            <option value="15">15</option>
            <option value="25">25</option>
            <option value="50">50</option>
            <option value="100">100</option>
        </select>
    </div>
    <div class="tabs_names">
        <li data-tab-target="#Bond" class="active tab">Bonds</li>
        <li data-tab-target="#Cryptocurrency" class="tab">Crypto</li>
        <li data-tab-target="#ETF" class="tab">ETFs</li>
        <li data-tab-target="#Fund" class="tab">Funds</li>
        <li data-tab-target="#Stock" class="tab">Stocks</li>
    </div>
    <div class="tabs_content">
        <c:forEach var="type" items="${SECURITIES_LIST}">

        <table id="mytable" class="tabs_content table-bordered table-striped">

                <div id="${type.key}" data-tab-content class="active">
<%--                    <table>--%>
                        <thead>
                        <tr>
                            <th>Symbol</th>
                            <th>Name</th>
                            <th>Exchange</th>
                            <th>Current price</th>
                            <th>Year change, %</th>
                            <th>Dividends</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="security" items="${type.value}">
                            <tr>
                                <td>
                                    <c:out value="${security.symbol}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.name}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.exchange}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.currentPrice}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.yearChangePercents}"></c:out>
                                </td>

                                <td>
                                    <c:out value="${security.dividends}"></c:out>
                                </td>

                                <td>
                                    <form action="addSecurityToPortfolio" method="GET">
                                        <input type="hidden" name="SECURITY_SYMBOL" value="${security.symbol}">
                                        <input type="hidden" name="SECURITY_PRICE" value="${security.currentPrice}">
                                        <input type="hidden" name="PORTFOLIO_ID" value="${PORTFOLIO_ID}">
                                        <input type="submit" name="submit" value="Add">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>>
                        </tbody>
<%--                    </table>--%>
                </div>
        </table>
        </c:forEach>

        <div class="pagination-container">
            <nav>
                <ul class="pagination"></ul>
            </nav>
        </div>

    </div>
</div>
</div>

<script src="jquery-3.5.1.min.js"></script>
<script src="static/css/bootstrap.min.css"></script>
<script>
    const tabs = document.querySelectorAll('[data-tab-target]')
    const tabContent = document.querySelectorAll('[data-tab-content]')

    tabs.forEach(tab => {
        tab.addEventListener('click', () => {
            const target = document.querySelector(tab.dataset.tabTarget)
            tabContent.forEach(tabContent => {
                tabContent.classList.remove('active')
            })
            tabs.forEach(tab => {
                tab.classList.remove('active')
            })
            tab.classList.add('active')
            target.classList.add('active')
        })
    })
</script>
<script>
    var table = '#mytable'
    $('#maxRows').on('change', function () {
        $('.pagination').html('')
        var trnum = 0
        var maxRows = parseInt($(this).val())
        var totalRows = $(table + ' tbody tr').length
        $(table + ' tr:gt(0)').each(function () {
            trnum++
            if (trnum > maxRows) {
                $(this).hide()
            }
            if (trnum <= maxRows) {
                $(this).show()
            }
        })
        if (totalRows > maxRows) {
            var pagenum = Math.ceil(totalRows / maxRows)
            for (var i = 1; i <= pagenum;) {
                $('.pagination').append('<li data-page="' + i + '">\<span>' + i++ + '' +
                    '<span class="sr-only">(current)</span></span>\</li>').show()
            }
        }
        $('.pagination li:first-child').addClass('active')
        $('.pagination li').on('click', function () {
            var pageNum = $(this).attr('data-page')
            var trIndex = 0;
            $('.pagination li').removeClass('active')
            $(this).addClass('active')
            $(table + ' tr:gt(0)').each(function () {
                trIndex++
                if (trIndex > (maxRows * pageNum) || trIndex <= ((maxRows * pageNum) - maxRows)) {
                    $(this).hide()
                } else {
                    $(this).show()
                }
            })
        })
    })
    // $(function () {
    //     $('table tr:eq(0)').prepend('<th>ID</th>')
    //     var id = 0;
    //     $('table tr:gt(0)').each(function () {
    //         id++
    //         $(this).prepend('<td>' + id + '</td>')
    //     })
    // })
</script>
</body>
</html>
