<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="get" action="/product/search">
        Searching By Product:<br>
        Name:<input type="text" name="name"><br>
        CategoryName:<input type="text" name="category.name"><br>
        ProducerName:<input type="text" name="producer.name"><br>
        <center><input type="SUBMIT"></center>
    </form>
</body>
</html>
