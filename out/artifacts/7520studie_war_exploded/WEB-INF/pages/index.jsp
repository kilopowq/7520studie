<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage</title>


</head>
<body>

<div class="jumbotron myJumbotron">
    <h1><b style="color:#e62e00">VIRGIN</b><i style="color:#ff704d">SHOP</i></h1>
    <h3><b style="color: #b300b3">for</b><i style="color:#00b3b3"> the born to be</i> <b style="color: #9966ff">beautiful</b></h3>
</div>
<div id="demo" class="carousel slide" data-ride="carousel">
    <ul class="carousel-indicators">
        <li data-target="#demo" data-slide-to="0" class="active"></li>
        <li data-target="#demo" data-slide-to="1"></li>
        <li data-target="#demo" data-slide-to="2"></li>
    </ul>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="/images/carouselOne.jpg" alt="carousel One" width="1600" height="650">
            <div class="carousel-caption">
                <h5>Extend the wardrobe!</h5>
            </div>
        </div>
        <div class="carousel-item">
            <img src="/images/carouselTwo.jpeg" alt="carousel Two" width="1600" height="650">
            <div class="carousel-caption">
                <h5>Enjoy shopping!</h5>
            </div>
        </div>
        <div class="carousel-item">
            <img src="/images/carouselThree.jpg" alt="Carousel Three" width="1600" height="650">
            <div class="carousel-caption">
                <h5>Be stylish!</h5>
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

<div class="container-fluid" style="margin-top:40px">
    <div class="row">
        <div class="col">
            <div class="container-fluid">
                <div class="container">
                    <div class="row text-center justify-content-center">
                        <c:forEach var="Product" items="${products}">
                            <div class="col-xs-12 col-sm-8 col-md-6 col-lg-3 ContainerProductInfo text-left"
                                 style="margin: 25px 10px">
                                <img src="/photos/${Product.image}" style="width:238px;height:294px" alt="Image">
                                <h6 style="text-align: center;text-transform: capitalize">
                                        ${Product.category.name}: ${Product.name}</h6>
                                <p>Producer: ${Product.producer.name}
                                <br>${Product.description}<br>Color : ${Product.color}</p>
                                <h6 class="containerForPrice">Prise: <strong>${Product.price} USD</strong></h6>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>