<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Products User</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
        <th>Category</th>
    </tr>
    <form action="" method="get">
        <label for="UserFilter">User filter</label>
        <select id="UserFilter" name="userId">
            <option value="${-1}" ${param['userId'] == null || param['userId'] == -1 ? 'selected' : ''}></option>
            <c:forEach items="${users}" var="user">
                <option value="${user.id}" ${param['userId'] == user.id ? 'selected' : ''} >${user.name}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Apply" />
    </form>
    <c:forEach items="${productsUser}" var="prod">
        <tr>
            <td>${prod.id}</td>
            <td>${prod.name}</td>
            <td>${prod.description}</td>
            <td>${prod.user.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
