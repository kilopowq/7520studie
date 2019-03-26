<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <script src="/webjars/jquery/3.3.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
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
            <sec:authorize access="hasAnyAuthority('ADMIN','MODERATOR')">
                <li class="nav-item">
                    <a class="nav-link <c:if test="${requestScope['javax.servlet.forward.request_uri'] eq '/add'}">
                            active</c:if>" href="/add"><spring:message code="header.add.but"/></a>
                </li>
            </sec:authorize>
            <li class="nav-item">
                <a class="nav-link <c:if test="${requestScope['javax.servlet.forward.request_uri'] eq '/product/'}">
                            active</c:if>" href="/product/"><spring:message code="header.products.but"/></a>
            </li>
        </ul>
    </div>
    <sec:authorize access="!isAuthenticated()">
        <div class="user-logo-icon-and-username">
            <i class="fas fa-user-slash user-logo-color"></i>
        </div>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <div class="user-logo-icon-and-username">
            <i class="fas fa-user-check user-logo-color"> <sec:authentication property="principal.username"/></i>
        </div>
    </sec:authorize>
    <a class="navbar-brand" href="?mylocale=en">
        <img src="/images/usa-flag.png" class="local-flag-size" alt="logo">
    </a>
    <a class="navbar-brand" href="?mylocale=uk">
        <img src="/images/uk-flag.png" class="local-flag-size" alt="logo">
    </a>
    <sec:authorize access="!isAuthenticated()">
        <button id="myBtn" type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal"><i
                class="fa fa-sign-in-alt" aria-hidden="true"></i>
            <spring:message code="header.login.but"/>
        </button>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <form class="form-inline my-2 my-lg-0">
            <a href="/logout" class="btn btn-info" role="button"><i class="fa fa-sign-out-alt" aria-hidden="true"></i>
                <spring:message code="header.logout.but"/></a>
        </form>
    </sec:authorize>
</nav>
<!-- The Modal Authorization -->
<div class="modal fade active" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title"><spring:message code="header.modal.please.sign.in">
                </spring:message></h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <c:url value="/j_spring_security_check" var="loginUrl"/>
            <form name='f' action="${loginUrl}" method="POST">
                <!-- Modal body -->
                <div class="modal-body">
                    <c:if test="${param.error != null}">
                        <div id="error" class="alert alert-danger">
                            <spring:message code="message.badCredentials">
                            </spring:message>
                        </div>
                    </c:if>
                    <input type="text" id="myInput" class="form-control" name="j_username" placeholder="Email address"
                           required autofocus value="Freezer">
                    <input type="password" class="form-control" name="j_password" placeholder="Password" required
                           value="1234">
                </div>
                <!-- Modal footer -->
                <div class="modal-footer">
                    <button class="btn btn-primary btn-block" type="submit"><spring:message code="header.modal.confirm">
                    </spring:message></button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal"><spring:message
                            code="header.modal.close">
                    </spring:message></button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    <c:if test="${param.error != null}">
    $('#myModal').modal('show');
    </c:if>
</script>
</body>
</html>
