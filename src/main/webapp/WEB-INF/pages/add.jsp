<%@ page import="com.kilopo.kosshop.entity.Category" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="width:100%">
    <tr>
        <th>
            <form method="get" action="/category/add">
                Category:<br>
                Name:<input type="text" name="name"><br>
                <center><input type="SUBMIT"></center>
            </form>
        </th>
        <th>
            <form method="get" modelAttribute="Product" action="/product/add">
                Product:<br>
                Name:<input type="text" name="name"><br>
                Price:<input type="number" name="price"><br>
                Description:<input type="text" name="description"><br>
                Category:
                <select name="category.id">
                    <c:forEach var="Category" items="${categories}">
                        <option value="${Category.id}">${Category.name}</option>
                    </c:forEach>
                </select><br>
                Producer:
                <select name="producer.id">
                    <c:forEach var="Producer" items="${producers}">
                        <option value="${Producer.id}">${Producer.name}</option>
                    </c:forEach>
                </select><br>
                <center><input type="SUBMIT"></center>
            </form>
        </th>
        <th>
            <form method="get" action="/producer/add">
                Producer:<br>
                Name:<input type="text" name="name"><br>
                <center><input type="SUBMIT"></center>
            </form>
        </th>
    </tr>
</table>
</body>
</html>
