<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <c:forEach var="product" items="${products}">
        <li>${product.id} ${product.title} - ${product.cost} р</li>
    </c:forEach>
</ul>

</body>
</html>