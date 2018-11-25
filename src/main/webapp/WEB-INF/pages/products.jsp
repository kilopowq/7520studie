<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProductsPage</title>
</head>
<body>
<div class="container-fluid" style="margin-top:40px">
    <div class="row">
        <div class="col-3" style="text-align:left">
            <h4 style="text-decoration: underline">Categories</h4>
            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a class="nav-link <c:if test = "${categoryActive eq null}">
                            active</c:if>" href="/product/"><strong>All</strong></a>
                </li>
                <c:forEach var="Category" items="${categories}">
                    <li class="nav-item">
                        <a class="nav-link <c:if test = "${categoryActive eq Category.name}">
                            active</c:if>
                            " style="text-transform: capitalize" href="
                                    <c:url value="/product/searchByCategory">
                                    <c:param name="categoryName" value="${Category.name}"/>
                                    </c:url>
                            ">${Category.name}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <div class="col">
            <div class="container-fluid">
                <div class="container">
                    <div class="row text-center justify-content-center">
                        <c:forEach var="Product" items="${products}">
                            <div class="col-xs-12 col-sm-8 col-md-5 col-lg-4 col-xl-3 ContainerProductInfo text-left">
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
