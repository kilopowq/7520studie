<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <script src="/webjars/jquery/3.3.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script src="/script/modal_windows.js"></script>
    <script src="/script/cart.js"></script>
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
    <ul class="navbar-nav">
        <li class="nav-item">
            <span id="buttonLoadCart" class="fa-stack fa-2x has-badge"
                  data-count="${(sessionScope.cart.countOfProducts) != null ? (sessionScope.cart.countOfProducts) : 0}"
                  data-toggle="modal" data-target="#myModalCart">
            <i class="fa fa-circle fa-stack-2x"></i>
            <i class="fa fa-shopping-cart fa-stack-1x fa-inverse"></i>
            </span>
        </li>
    </ul>
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

            <form name='f' action="/perform_login" method="POST">
                <!-- Modal body -->
                <div class="modal-body">
                    <c:if test="${param.error != null}">
                        <div id="error" class="alert alert-danger">
                            <spring:message code="message.badCredentials">
                            </spring:message>
                        </div>
                    </c:if>
                    <input type="text" id="myInput" class="form-control" name="username" placeholder="Email address"
                           required autofocus value="Freezer">
                    <input type="password" class="form-control" name="password" placeholder="Password" required
                           value="1234">
                </div>
                <div class="registation-link-div">
                    <a href="/registration"><spring:message code="message.registration"/></a>
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
<div class="modal fade active" id="myModalApprovalSentLink">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title"><spring:message code="approve.link.sent.to.your.email"></spring:message></h5>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary btn-block" data-dismiss="modal" type="submit">OK</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade active" id="myModalApproved" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title"><spring:message code="successfully.approved"></spring:message></h4>
            </div>
            <div class="modal-footer">
                <div><h4>${param.Login}</h4></div>
                <div><a href="/" class="btn btn-info" role="button"><i aria-hidden="true"></i>
                    OK</a>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade active" id="myModalNotApproved" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title"><spring:message code="unsuccessfully.approved"></spring:message></h4>
            </div>
            <div class="modal-footer">
                <div><a href="/" class="btn btn-info" role="button"><i aria-hidden="true"></i>
                    OK</a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Cart modal  -->
<div class="modal fade active" id="myModalCart" data-backdrop="static">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title"><spring:message code="header.modal.your.cart">
                </spring:message></h4>
                <button type="button" class="close" data-dismiss="modal" onclick="javascript:window.location.reload()">&times;</button>
            </div>

            <form name='f' action="/" method="POST">
                <!-- Modal body -->

                <c:if test="${empty cartProduct}">
                    <h2><spring:message code="producer.sen"/></h2>
                </c:if>
                <c:if test="${cart != null}">
                    <h2${cart}</h2>
                </c:if>
                <div id ="products_table">
                    <c:forEach var="CartProduct" items="${sessionScope.cart.cartProducts}">
                        <div class="col-xs-12 col-sm-8 col-md-5 col-lg-4 col-xl-3 container-cartProduct-info text-left">
                            <div class="row">
                                <div class="col-md-4">
                                    <img src="data:image/png;base64,${CartProduct.product.base64Image}" class="photo-size" alt="Image">
                                </div>
                                <div class="col-md-3">
                                    <h6 class="text-capitalize">
                                            ${CartProduct.product.category.name}: ${CartProduct.product.name}</h6>
                                    <h6 class="text-capitalize">${CartProduct.product.description}</h6>
                                    <h6 class="text-capitalize"><spring:message code="producer.sen"/>:
                                            ${CartProduct.product.producer.name}</h6>
                                    <h6><spring:message code="color.sen"/>: ${CartProduct.product.color}</h6>
                                    <h6 class="container-for-price"><spring:message code="price.sen"/>:
                                        <strong>${CartProduct.product.price} $</strong>
                                    </h6>
                                </div>
                                <div class="col-md-3">
                                    <div class="number">
                                        <span class="minus" onclick="decrease(${CartProduct.product.id})">-</span>
                                        <input id="input-amount" class="inputs" type="text" value="${CartProduct.amount}"
                                               onfocusout="inputChange(${CartProduct.product.id})"/>
                                        <span class="plus" onclick="increase(${CartProduct.product.id})">+</span>
                                    </div>

                                </div>
                                <div class="col-md-2">
                                    <button type="button" class="close"
                                            onclick="removeCartProductFromCart(${CartProduct.product.id})">&times;</button>
                                    <p class="sum"><b><spring:message code="sum.sen"/></b>
                                        <span class="yellow-background">${CartProduct.sum}$</span></p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
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
<div class="modal fade active" id="myModalAddedToYourShoppingCart">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title"><spring:message code="item.added.to.your.cart"></spring:message></h4>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary btn-block" data-dismiss="modal" type="submit">OK</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade active" id="removeProductConfirmModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title"><spring:message code="remove.item.from.cart"></spring:message></h4>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" id="modelButtonOk" data-dismiss="modal" type="submit">OK</button>
                <button type="button" class="btn btn-danger" data-dismiss="modal"><spring:message
                        code="header.modal.close">
                </spring:message></button>
            </div>
        </div>
    </div>
</div>
<script>

</script>

<c:if test="${param.error != null}">
    <input type="hidden" id="paramError" value="paramError">
</c:if>
<c:if test="${param.Login != null}">
    <input type="hidden" id="paramLogin" value="paramLogin">
</c:if>
<c:if test="${notApproved != null}">
    <input type="hidden" id="notApproved" value="notApproved">
</c:if>
<c:if test="${approvalLinkSended != null}">
    <input type="hidden" id="approvalLinkSended" value="approvalLinkSended">
</c:if>
<c:if test="${param.notAuth != null}">
    <input type="hidden" id="notAuthorized" value="notAuthorized">
</c:if>


</body>
</html>
