<%@page language="java" contentType="text/html charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>Список продуктов</title>
</head>

<body>
<h1>Список продуктов</h1>

<ul>
    <c:forEach var="product" items="${productList}">
        <li>${product.id} ${product.title} - ${product.price} р</li>
    </c:forEach>
</ul>

</body>
</html>