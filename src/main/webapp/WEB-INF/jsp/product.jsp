<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>${product.title}</title>
</head>

<body>
    <h1>${product.title}</h1>
    <h2>id: ${product.id}, цена: ${product.cost}</h2>
</body>
</html>