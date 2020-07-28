<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="content"/>

<html lang="${sessionScope.lang}">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            © <fmt:message key="label.copyright"/> 2020 Investment Platform. Aleh Yemelyanchyk. <fmt:message
                key="label.allRightsReserved"/>.
        </div>
        <div class="col-md-2">
            <form id="form" action="${pageContext.request.contextPath}/contactUs" method="POST">
                <button id=contactUs" type="submit" class="btn btn-link">
                    <h5>Contact us</h5>
                </button>
            </form>
        </div>
    </div>
</html>