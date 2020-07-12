<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="project-tag" uri="/WEB-INF/tags.tld" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>

<html lang="${sessionScope.lang}">
<head>
    <title>All securities</title>
</head>

<body>

<project-tag:getCurrentDate/>

<div class="container mt-2 mb-2 table-striped">
    <br/>

    <a class="btn btn-dark" href="${pageContext.request.contextPath}/addSecurityAdmin"
       data-tooltip title="Add Security">
        <i class="icon-plus-sign-alt"></i>
    </a>

    <div class="tabs_names">
        <li data-tab-target="#Fund" class="active tab">Funds</li>
        <li data-tab-target="#Bond" class="tab">Bonds</li>
        <li data-tab-target="#Cryptocurrency" class="tab">Crypto</li>
        <li data-tab-target="#ETF" class="tab">ETFs</li>
        <li data-tab-target="#Stock" class="tab">Stocks</li>
    </div>

    <c:forEach var="type" items="${SECURITIES_LIST}" varStatus="loop">

    <c:choose>

    <c:when test="${loop.index == 0}">
    <div id="${type.key}" data-tab-content class="active">
        </c:when>

        <c:otherwise>
        <div id="${type.key}" data-tab-content>
            </c:otherwise>

            </c:choose>
            <table
                    data-toggle="table"
                    data-pagination="true"
                    data-search="true">
                <thead>
                <tr>
                    <th data-field="symbol" data-sortable="true"><fmt:message key="label.symbol"/></th>
                    <th data-field="name" data-sortable="true"><fmt:message key="label.name"/></th>
                    <th data-field="edit" data-sortable="false"></th>
                    <th data-field="archive" data-sortable="false"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="security" items="${type.value}">

                    <c:url var="securityLink" value="getSecurity">
                        <c:param name="SECURITY_SYMBOL" value="${security.symbol}"/>
                    </c:url>

                    <tr>
                        <td>
                            <a href="${securityLink}">${security.symbol}</a>
                        </td>

                        <td>
                            <a href="${securityLink}">${security.name}</a>
                        </td>

                        <td>
                            <form action="${pageContext.request.contextPath}/updateSecurity" method="GET">
                                <input type="hidden" name="SECURITY_SYMBOL" value="${security.symbol}">
                                <button
                                        class="btn btn-dark" type="submit"
                                        data-tooltip title="Edit">
                                    <i class="icon-edit"></i>
                                </button>
                            </form>
                        </td>

                        <td>
                            <form id="form${security.symbol}"
                                  action="${pageContext.request.contextPath}/archiveSecurity" method="POST">
                                <input type="hidden" name="SECURITY_SYMBOL" value="${security.symbol}">
                                <button class="btn btn-dark" type="button"
                                        data-toggle="modal"
                                        data-target="#${security.symbol}"
                                        data-tooltip title="Archive">
                                    <i class="icon-archive"></i>
                                </button>
                                <!-- Modal -->
                                <div class="modal fade" id="${security.symbol}" tabindex="-1" role="dialog"
                                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLabel">Archive the security</h5>
                                                <button type="button" class="close" data-dismiss="modal"
                                                        aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <input type="date" name="DATE" class="form-control" id="date"
                                                       value="${DATE}"
                                                       min="${DATE}" max="2099-01-01"
                                                       required
                                                       data-value-missing="Please, enter date">
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                                    Close
                                                </button>
                                                <button id="${security.symbol}" type="submit"
                                                        onclick="popUp(this.id)"
                                                        data-toggle="modal"
                                                        data-target="#successModal"
                                                        class="btn btn-primary">
                                                    Archive
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        </c:forEach>

        <div class="pagination-container">
            <nav>
                <ul class="pagination"></ul>
            </nav>
        </div>
    </div>
</div>
<script>
    function popUp(id) {
        event.preventDefault();
        swal("Success!", "The security has been archived.", "success", {
            button: "Ok",
        }).then(() => {
            document.getElementById("form".concat(id)).submit();
        });
    }
</script>
</body>
</html>
