<%@ page import="com.kilopo.kosshop.entity.Category" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <title>AddPage</title>
</head>
<body>
<!-- Nav tabs -->
<ul class="nav nav-tabs">
    <li class="nav-item">
        <a class="nav-link active" data-toggle="tab" href="#addFormCategory"><spring:message code="category.sen"/></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" data-toggle="tab" href="#addFormProduct"><spring:message code="product.sen"/></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" data-toggle="tab" href="#addFormProducer"><spring:message code="producer.sen"/></a>
    </li>
</ul>
<!-- Tab panes -->
<div class="tab-content">
    <div id="addFormCategory" class="container tab-pane active"><br>
        <form method="post" action="/category/add">
            <div class="form-group">
                <label><spring:message code="name.sen"/>:</label>
                <input type="text" class="form-control" placeholder=
                <spring:message code="name.sen"/> name="name"><br>
                <center><input type="submit" class="btn btn-primary" value=<spring:message code="Submit.but"/>></center>
            </div>
        </form>

    </div>
    <div id="addFormProduct" class="container tab-pane fade"><br>
        <form method="post" modelAttribute="Product" action="/product/add" enctype="multipart/form-data">
            <div class="form-group">
                <label><spring:message code="name.sen"/>:</label>
                <input type="text" class="form-control" placeholder=
                <spring:message code="name.sen"/> name="name">
            </div>
            <div class="form-group">
                <label><spring:message code="price.sen"/>:</label>
                <input type="number" step="0.01" class="form-control" placeholder=
                <spring:message code="price.sen"/> name="price">
            </div>
            <div class="form-group">
                <label><spring:message code="description.sen"/>:</label>
                <input type="text" class="form-control" placeholder=
                <spring:message code="description.sen"/> name="description">
            </div>
            <div class="form-group">
                <label><spring:message code="image.sen"/>:</label>
                <input type="button" class="btn btn-primary" value=
                <spring:message code="choice.image.but"/>
                        onclick="document.getElementById('file').click();"/>
                <input type="file" class="display-none" id="file" name="myImage"/>
            </div>
            <div class="row">
                <div class="col">
                    <label class="inputState"><spring:message code="color.sen"/>:</label>
                    <select class="form-control form-control-sm" name="color">
                        <c:forEach var="Color" items="${colors}">
                            <option value="${Color}">${Color.value}</option>
                        </c:forEach>
                    </select><br>
                </div>
                <div class="col">
                    <label class="inputState"><spring:message code="category.sen"/>:</label>
                    <select class="form-control form-control-sm" name="category.id">
                        <c:forEach var="Category" items="${categories}">
                            <option value="${Category.id}">${Category.name}</option>
                        </c:forEach>
                    </select><br>
                </div>
                <div class="col">
                    <label class="inputState"><spring:message code="producer.sen"/>:</label>
                    <select class="form-control form-control-sm" name="producer.id">
                        <c:forEach var="Producer" items="${producers}">
                            <option value="${Producer.id}">${Producer.name}</option>
                        </c:forEach>
                    </select><br>
                </div>
            </div>
            <center><input type="submit" class="btn btn-primary" value=<spring:message code="Submit.but"/>></center>
        </form>
    </div>
    <div id="addFormProducer" class="container tab-pane fade"><br>
        <form method="post" action="/producer/add">
            <div class="form-group">
                <label><spring:message code="name.sen"/>:</label>
                <input type="text" class="form-control" placeholder=
                <spring:message code="name.sen"/> name="name"><br>
                <center><input type="submit" class="btn btn-primary" value=<spring:message code="Submit.but"/>></center>
            </div>
        </form>
    </div>
</div>
</div>
</body>
</html>
