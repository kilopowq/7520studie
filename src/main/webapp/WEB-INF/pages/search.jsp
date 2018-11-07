<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SearchPage</title>
</head>
<body>
<div class="container text-center">
    <form method="get" action="/product/search">
        Product Search:<br>
        Name:<input type="text" name="name"><br>
        CategoryName:<input type="text" name="category.name"><br>
        ProducerName:<input type="text" name="producer.name"><br>
        <center><input type="SUBMIT"></center>
    </form>
</div>
</body>
</html>
