<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <title>HomePage</title>
</head>
<body>
<div class="jumbotron my-jumbotron">
    <h1><b class="word-color-red">VIRGIN</b><i class="word-color-light-red">SHOP</i></h1>
    <h3><b class="word-color-purple"><spring:message code="for.sen"/></b>
        <i class="word-color-light-blue"><spring:message code="the.born.to.be.sen"/> </i>
        <b class="word-color-light-purple"><spring:message code="beautiful.sen"/></b></h3>
</div>
<div id="demo" class="carousel slide" data-ride="carousel">
    <ul class="carousel-indicators">
        <li data-target="#demo" data-slide-to="0" class="active"></li>
        <li data-target="#demo" data-slide-to="1"></li>
        <li data-target="#demo" data-slide-to="2"></li>
    </ul>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="/images/carouselOne.jpg" alt="carousel One" class="carousel-size">
            <div class="carousel-caption">
                <h5><spring:message code="extend.to.wardrobe.sen"/>!</h5>
            </div>
        </div>
        <div class="carousel-item">
            <img src="/images/carouselTwo.jpeg" alt="carousel Two" class="carousel-size">
            <div class="carousel-caption">
                <h5><spring:message code="enjoy.shopping.sen"/>!</h5>
            </div>
        </div>
        <div class="carousel-item">
            <img src="/images/carouselThree.jpg" alt="Carousel Three" class="carousel-size">
            <div class="carousel-caption">
                <h5><spring:message code="be.stylish.sen"/>!</h5>
            </div>
        </div>
    </div>
    <a class="carousel-control-prev" href="#demo" data-slide="prev">
        <span class="carousel-control-prev-icon"></span>
    </a>
    <a class="carousel-control-next" href="#demo" data-slide="next">
        <span class="carousel-control-next-icon"></span>
    </a>
</div>
<div class="container-fluid container-margin-top">

    <div class="row">
        <div class="col">
            <div class="container-fluid">
                <div class="container">
                    <div class="row text-center justify-content-center">
                        <c:forEach var="Product" items="${products}">
                            <form method="post" action="/cart/add">
                                <div class="col-xs-12 col-sm-8 col-md-6 col-lg-3
                                    container-product-info text-left margin-between-container-product-info">
                                <img src="data:image/png;base64,${Product.base64Image}" class="photo-size" alt="Image">
                                <h6 class="text-center text-capitalize">
                                        ${Product.category.name}: ${Product.name}</h6>
                                <p><spring:message code="producer.sen"/>: ${Product.producer.name}
                                    <br>${Product.description}<br>
                                    <spring:message code="color.sen"/>: ${Product.color}</p>
                                <h6 class="container-for-price"><spring:message code="price.sen"/>:
                                    <strong>${Product.price} $</strong></h6>
                                    <input type="hidden" id="myIdPr+${Product.id}" value=${Product.id} name="productId">
                                    <input type="button" class="btn btn-primary"
                                           data-target="#myModalAddedToYourShoppingCart"
                                           onclick="showHint(${Product.id})"
                                           value=<spring:message code="add.to.cart.sen"/>>
                                </div>
                            </form>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>