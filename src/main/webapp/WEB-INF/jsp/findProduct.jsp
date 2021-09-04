<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<head>
    <meta charset="UTF-8">
    <title>Поиск продукта по id</title>
</head>

<body>
    <form:form method="POST" action="processFind" modelAttribute="product">
        id: <form:input path="id" />
        <input type="submit" value="Find" />
    </form:form>

    <h3><c:out value="${resultProduct.title} - ${resultProduct.price}" /></h3>
</body>
</html>