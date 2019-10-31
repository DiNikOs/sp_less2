<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <ul>
        <c:url value="/categories/" var="categoriesUrl" />
        <li><a href="${categoriesUrl}">Categories</a></li>
        <c:url value="/products/" var="productsUrl" />
        <li><a href="${productsUrl}">Products</a></li>
        <li>Customers</li>
    </ul>
</body>
</html>
