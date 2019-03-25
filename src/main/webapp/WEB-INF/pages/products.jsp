<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <title>ProductsPage</title>
</head>
<body>
<div class="container-fluid container-margin-top">
    <div class="row">
        <div class="col-3 text-left">
            <h4><u><spring:message code="categories.sen"/></u></h4>
            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a class="nav-link <c:if test = "${categoryActive eq null}">
                            active</c:if>" href="/product/"><strong>All</strong></a>
                </li>
                <c:forEach var="Category" items="${categories}">
                    <li class="nav-item">
                        <a class="nav-link text-capitalize <c:if test = "${categoryActive eq Category.name}">
                            active</c:if>
                            " href="
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
                    <c:if test="${empty products}">
                        <h2 class="text-center"><spring:message code="the.goods.of.this.category.are.absent.sen"/></h2>
                    </c:if>
                    <div class="row text-center justify-content-center">
                        <c:forEach var="Product" items="${products}">
                            <div class="col-xs-12 col-sm-8 col-md-5 col-lg-4 col-xl-3 container-product-info text-left">
                                <img src="data:image/png;base64,${Product.base64Image}" class="photo-size" alt="Image">
                                <h6 class="text-center text-capitalize">
                                        ${Product.category.name}: ${Product.name}</h6>
                                <p><spring:message code="producer.sen"/>: ${Product.producer.name}
                                    <br>${Product.description}<br>
                                    <spring:message code="color.sen"/>: ${Product.color}</p>
                                <h6 class="container-for-price"><spring:message code="price.sen"/>:
                                    <strong>${Product.price} $</strong>
                                </h6>
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
