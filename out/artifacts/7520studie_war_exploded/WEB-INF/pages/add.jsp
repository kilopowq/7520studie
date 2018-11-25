<%@ page import="com.kilopo.kosshop.entity.Category" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddPage</title>
</head>
<body>
<!-- Nav tabs -->
<ul class="nav nav-tabs">
    <li class="nav-item">
        <a class="nav-link active" data-toggle="tab" href="#addFormCategory">Category</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" data-toggle="tab" href="#addFormProduct">Product</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" data-toggle="tab" href="#addFormProducer">Producer</a>
    </li>
</ul>
<!-- Tab panes -->
<div class="tab-content">
    <div id="addFormCategory" class="container tab-pane active"><br>
        <form method="post" action="/category/add">
            <div class="form-group">
            <label>Name:</label>
            <input type="text" class="form-control"  placeholder="name" name="name"><br>
            <center><input type="submit" class="btn btn-default" value="Submit"></center>
            </div>
        </form>
    </div>
    <div id="addFormProduct" class="container tab-pane fade"><br>
        <form method="post" modelAttribute="Product" action="/product/add">
            <div class="form-group">
            <label>Name:</label>
            <input type="text" class="form-control" placeholder="name" name="name">
            </div>
            <div class="form-group">
            <label>Price:</label>
            <input type="number" class="form-control" placeholder="price" name="price">
            </div>
            <div class="form-group">
            <label>Description:</label>
            <input type="text" class="form-control" placeholder="description" name="description">
            </div>
            <div class="form-group">
            <label>Image href:</label>
            <input type="text" class="form-control" placeholder="image href" name="image">
            </div>
            <div class="row">
                <div class="col">
                    <label class="inputState"> Color:</label>
                    <select class="form-control form-control-sm" name="color">
                        <c:forEach var="Color" items="${colors}">
                            <option value="${Color}">${Color.value}</option>
                        </c:forEach>
                    </select><br>
                </div>
                <div class="col">
                    <label class="inputState"> Category:</label>
                    <select class="form-control form-control-sm" name="category.id">
                        <c:forEach var="Category" items="${categories}">
                            <option value="${Category.id}">${Category.name}</option>
                        </c:forEach>
                    </select><br>
                </div>
                <div class="col">
                    <label class="inputState"> Producer:</label>
                    <select class="form-control form-control-sm" name="producer.id">
                        <c:forEach var="Producer" items="${producers}">
                            <option value="${Producer.id}">${Producer.name}</option>
                        </c:forEach>
                    </select><br>
                </div>
            </div>
            <center><input type="submit" class="btn btn-default" value="Submit"></center>
        </form>
    </div>
    <div id="addFormProducer" class="container tab-pane fade"><br>
        <form method="post" action="/producer/add">
            <div class="form-group">
            <label>Name:</label>
            <input type="text" class="form-control" placeholder="name" name="name"><br>
            <center><input type="submit" class="btn btn-default" value="Submit"></center>
            </div>
        </form>
    </div>
</div>
</div>
</body>
</html>
