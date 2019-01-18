<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark sticky-top">
    <a class="navbar-brand" href="/">
        <img src="/images/Logo.png" class="img-thumbnail logo-size" alt="logo">
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link <c:if test="${requestScope['javax.servlet.forward.request_uri'] eq '/add'}">
                            active</c:if>" href="/add"><spring:message code="header.add.but"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link <c:if test="${requestScope['javax.servlet.forward.request_uri'] eq '/product/'}">
                            active</c:if>" href="/product/"><spring:message code="header.products.but"/></a>
            </li>
        </ul>
    </div>
    <a class="navbar-brand" href="?mylocale=en">
        <img src="/images/usa-flag.png" class="local-flag-size" alt="logo">
    </a>
    <a class="navbar-brand" href="?mylocale=uk">
        <img src="/images/uk-flag.png" class="local-flag-size" alt="logo">
    </a>
    <form class="form-inline my-2 my-lg-0">
        <a href="#" class="btn btn-info" role="button"><i class="fa fa-sign-in-alt" aria-hidden="true"></i>
            <spring:message code="header.login.but"/></a>
    </form>
</nav>
</body>
</html>
