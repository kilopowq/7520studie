<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage</title>
</head>
<body style="background-color: white">
<div class="jumbotron text-center" style="margin-bottom:0">
    <h1>Virgin</h1>
    <p>Beauty, style, uniqueness</p>
</div>
<div id="demo" class="carousel slide" data-ride="carousel">
    <ul class="carousel-indicators">
        <li data-target="#demo" data-slide-to="0" class="active"></li>
        <li data-target="#demo" data-slide-to="1"></li>
        <li data-target="#demo" data-slide-to="2"></li>
    </ul>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="/images/carousel1.jpg" alt="Los Angeles" width="1600" height="350">
            <div class="carousel-caption">
                <h3>Some text</h3>
                <p>some detail information</p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="/images/carousel2.jpg" alt="Chicago" width="1600" height="350">
            <div class="carousel-caption">
                <h3>Some text</h3>
                <p>some detail information</p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="/images/carousel3.jpg" alt="New York" width="1600" height="350">
            <div class="carousel-caption">
                <h3>Some text</h3>
                <p>some detail information</p>
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
            <div class="container-fluid" style="margin-top:30px">
                <div class="row text-center">
                    <div class="col-4 w-100">
                        <div class="ContainerProductInfo w-100">
                            <p>some information</p>
                            <img src="/images/empty.png" style="width:200px;height:200px" alt="Image">
                            <p>some information some information some information some information some information some information</p>
                        </div>
                    </div>
                    <div class="col-4 w-100">
                        <div class="ContainerProductInfo w-100">
                            <p>some information</p>
                            <img src="/images/empty.png" style="width:200px;height:200px" alt="Image">
                            <p>some information some information some information some information some information some information</p>
                        </div>
                    </div>
                    <div class="col-4 w-100">
                        <div class="ContainerProductInfo w-100">
                            <p>some information</p>
                            <img src="/images/empty.png" style="width:200px;height:200px" alt="Image">
                            <p>some information some information some information some information some information some information</p>
                        </div>
                    </div>
                </div>
                <div class="row text-center" id="cp">
                    <div class="col-4 w-100">
                        <div class="ContainerProductInfo w-100">
                            <p>some information</p>
                            <img src="/images/empty.png" style="width:200px;height:200px" alt="Image">
                            <p>some information some information some information some information some information some information</p>
                        </div>
                    </div>
                    <div class="col-4">
                        <div class="ContainerProductInfo w-100">
                            <p>some information some information</p>
                            <img src="/images/empty.png" style="width:200px;height:200px" alt="Image">
                            <p>some information some information some information some information some information some information</p>
                        </div>
                    </div>
                    <div class="col-4">
                        <div class="ContainerProductInfo w-100">
                            <p>some information</p>
                            <img src="/images/empty.png" style="width:200px;height:200px" alt="Image">
                            <p>some information some information some information some information some information some information</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>