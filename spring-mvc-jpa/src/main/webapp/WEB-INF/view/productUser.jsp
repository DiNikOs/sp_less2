<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product User</title>
</head>
<body>
<c:url value="/products/createUser" var="createUserUrl"/>
<form action="${createUserUrl}" method="post">
    <%-- Очень часто применяемый способ передачи id через форму --%>
    <input type="hidden" name="id" id="id" value="${product.id}">
    <input type="hidden" name="userId" id="userId" value="${product.user.id}">
    <p>
        <label for="nameUser">Name</label>
        <input type="text" id="nameUser" name="name" value="${product.name}" />
    </p>
    <%--<p>--%>
        <%--<label for="user">User</label>--%>
        <%--<input type="text" id="user" name="user" value="${product.user.name}" disabled />--%>
    <%--</p>--%>
    <p>
        <label for="priceUser">Price</label>
        <input type="number" id="priceUser" name="price" value="${product.price}" />
    </p>
    <p>
        <label for="descriptionUser">Description</label>
        <input type="text" id="descriptionUser" name="description" value="${product.description}" />
    </p>
        <form action="" method="get">
            <label for="productFilter">Product filter</label>
            <select id="productFilter" name="userId">
                <option value="${-1}" ${param['userId'] == null || param['userId'] == -1 ? 'selected' : ''}></option>
                <c:forEach items="${users}" var="user">
                    <option value="${user.id}" ${param['userId'] == user.id ? 'selected' : ''} >${user.name}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Apply" />
        </form>
    <input type="submit" />

        <c:forEach items="${products}" var="prod">
            <tr>
                <td>${prod.id}</td>
                <td>${prod.name}</td>
                <td>${prod.description}</td>
                <%--<td>${prod.category.name}</td>--%>
                <td>${prod.user.name}</td>
            </tr>
        </c:forEach>
</form>
</body>
</html>
