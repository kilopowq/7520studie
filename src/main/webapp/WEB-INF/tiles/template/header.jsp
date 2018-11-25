<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                            active</c:if>" href="/add">Add</a>
            </li>
            <li class="nav-item">
                <a class="nav-link <c:if test="${requestScope['javax.servlet.forward.request_uri'] eq '/product/'}">
                            active</c:if>" href="/product/">Products</a>
            </li>
        </ul>
    </div>
    <form class="form-inline my-2 my-lg-0">
        <a href="#" class="btn btn-info" role="button"><i class="fa fa-sign-in-alt" aria-hidden="true"></i> Log in</a>
    </form>
</nav>
</body>
</html>
