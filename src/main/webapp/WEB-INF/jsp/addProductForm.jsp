<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
    <meta charset="UTF-8">
    <title>Добавление нового продукта</title>
</head>

<body>
    <form:form action="processForm" modelAttribute="product">
        Название: <form:input path="title" />
        <br>
        Цена: <form:input path="cost" />
        <br>
        <input type="submit" value="Submit" />
    </form:form>
</body>
</html>