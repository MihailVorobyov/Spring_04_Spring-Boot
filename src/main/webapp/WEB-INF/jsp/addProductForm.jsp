<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
    <meta charset="UTF-8">
    <title>Добавление нового продукта</title>
</head>

<body>
    <form:form action="processAdd" modelAttribute="product">
        Название: <form:input path="title" />
        <br>
        Цена: <form:input path="price" />
        <br>
        <input type="submit" value="Добавить" />
    </form:form>
</body>
</html>