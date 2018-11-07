<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet"/>
<head>
    <title>Title</title>
    <style>
        .fakeimg {
            height: 200px;
            background: #aaa;
        }
        .p-0{
            padding: 0;
        }
        #cp {

        }
        #accept{

        }
        #modd{

        }
        .P-right{
            position: absolute;
            right: 10px;
        }
        #nothing {

        }
        .container1 {
            margin: 15px;
            width: 320px;
            height: 380px;
            position: relative;
            border: 2px solid lightgray;
        }
        .container2 {
            width: 320px;
            height: 500px;
            position: relative;
            border: 2px solid lightgray;
        }
        p {
            margin: 3px;
            padding-left: 7px;
        }
        #botm {
            position: absolute;
            bottom: 0;
        }

        .displayed {
            display: block;
            margin-left: auto;
            margin-right: auto;
            margin-bottom: 2%;
        }
        .gear {
            display: block;
            position: absolute;
            width: 30px;
            height: 30px;
            top: 30px;
            left: 30px;
            background: url(http://i.imgur.com/lOBxb.png);
            -webkit-animation: barrelRoll 2s infinite linear;
            -webkit-animation-play-state: paused;
        }

        .gear:last-of-type {
            top: 15px;
            left:1023px;
            -webkit-animation-name: invertBarrelRoll;
        }
        .o{
        }
        .o:hover > .gear {
            -webkit-animation-play-state: running;
        }

        @-webkit-keyframes invertBarrelRoll {
            0% { -webkit-transform: rotate(0deg); }
            100% { -webkit-transform: rotate(-360deg); }
        }
        .slidecontainer {
            width: 100%;
        }



        .slider:hover {
            opacity: 1;
        }

    </style>
</head>
<body>

<div class="jumbotron text-center" style="margin-bottom:0">
    <h1>Hire will be some page</h1>
    <p>and couple of words</p>
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark sticky-top">
    <a class="navbar-brand" href="#">LOGO</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
        </ul>
    </div>
    <form class="form-inline my-2 my-lg-0" action="/action_page.php">
        <input class="form-control mr-sm-2" type="text" placeholder="Search">
        <button class="btn btn-success" type="submit">Search</button>
    </form>
</nav>
<nav class="navbar navbar-expand-sm bg-light navbar-light   ">
    <div class="collapse navbar-collapse">
        <div class="container-fluid">
            <div class="row">
                <div class="col w-100"></div>
                <div class="col-2">thelephone</div>
                <div class="col-2">one more thelefone</div>
                <div class="col-1">
                    <a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a>
                </div>
            </div>
        </div>
    </div>
</nav>
<div id="demo" class="carousel slide" data-ride="carousel">
    <ul class="carousel-indicators">
        <li data-target="#demo" data-slide-to="0" class="active"></li>
        <li data-target="#demo" data-slide-to="1"></li>
        <li data-target="#demo" data-slide-to="2"></li>
    </ul>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="/images/1.jpg" alt="Los Angeles" width="1600" height="350">
            <div class="carousel-caption">
                <h3>Some text</h3>
                <p>some detail information</p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="/images/2.jpg" alt="Chicago" width="1600" height="350">
            <div class="carousel-caption">
                <h3>Some text</h3>
                <p>some detail information</p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="/images/3.jpg" alt="New York" width="1600" height="350">
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
<div class="container-fluid" style="margin-top:30px">
    <div class="row">
        <div class="col-2">
            <h3>Some Links</h3>
            <p>Lorem ipsum dolor sit ame.</p>
            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a class="nav-link active" href="#">Active</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#">Disabled</a>
                </li>
            </ul>
            <hr class="d-sm-none">
        </div>
        <div class="col">
            <div class="container-fluid" style="margin-top:30px">
                <div class="row text-center">
                    <div class="col-4 w-100">
                        <div class="container1 w-100">
                            <p>some information</p>
                            <img src="https://placehold.it/150x80?text=IMAGE" style="width:200px;height:200px" alt="Image">
                            <p>some information some information some information some information some information some information</p>
                        </div>
                    </div>
                    <div class="col-4 w-100">
                        <div class="container1 w-100">
                            <p>some information</p>
                            <img src="https://placehold.it/150x80?text=IMAGE" style="width:200px;height:200px" alt="Image">
                            <p>some information some information some information some information some information some information</p>
                        </div>
                    </div>
                    <div class="col-4 w-100">
                        <div class="container1 w-100">
                            <p>some information</p>
                            <img src="https://placehold.it/150x80?text=IMAGE" style="width:200px;height:200px" alt="Image">
                            <p>some information some information some information some information some information some information</p>
                        </div>
                    </div>
                </div>
                <div class="row text-center" id="cp">
                    <div class="col-4 w-100">
                        <div class="container1 w-100">
                            <p>some information</p>
                            <img src="https://placehold.it/150x80?text=IMAGE" style="width:200px;height:200px" alt="Image">
                            <p>some information some information some information some information some information some information</p>
                        </div>
                    </div>
                    <div class="col-4">
                        <div class="container1 w-100">
                            <p>some information some information</p>
                            <img src="https://placehold.it/150x80?text=IMAGE" style="width:200px;height:200px" alt="Image">
                            <p>some information some information some information some information some information some information</p>
                        </div>
                    </div>
                    <div class="col-4">
                        <div class="container1 w-100">
                            <p>some information</p>
                            <img src="https://placehold.it/150x80?text=IMAGE" style="width:200px;height:200px" alt="Image">
                            <p>some information some information some information some information some information some information</p>
                        </div>
                    </div>



                </div>
            </div>
        </div>
    </div>
</div>

<div class="jumbotron text-center container-fluid " style="margin-bottom:0;margin-top:30px">
    <p>Footer</p>
</div>


<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>
