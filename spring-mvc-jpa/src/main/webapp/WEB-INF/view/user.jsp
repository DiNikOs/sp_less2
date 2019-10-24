<%--
  Created by IntelliJ IDEA.
  User: Dion
  Date: 24.10.2019
  Time: 5:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>User</title>
</head>
<body>

<form action="${action}" method="post">
    <%-- Очень часто применяемый способ передачи id через форму --%>
    <input type="hidden" name="id" id="id" value="${user.id}">
    <p>
        <label for="name">Name</label>
        <input type="text" id="name" name="name" value="${user.name}" />
    </p>
    <p>
        <label for="description">Description</label>
        <input type="text" id="description" name="description" value="${user.description}" />
    </p>
    <input type="submit" />
</form>

<c:url value="/users/create" var="createUrl">
    <%-- Нам нужно указать, продукт какой категории мы создаем --%>
    <c:param name="userId" value="${user.id}"/>
</c:url>
<a href="${createUrl}">Create new Product</a>

<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
    </tr>

    <c:forEach items="${user.productsUser}" var="prod">
        <tr>
            <td>${prod.id}</td>
            <td>${prod.name}</td>
            <td>${prod.description}</td>
            <td>${prod.price}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
