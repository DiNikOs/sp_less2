<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Categories</title>
</head>
<body>

<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
    </tr>

    <c:forEach items="${categories}" var="category">
        <tr>
            <c:url value="/categories/edit" var="editUrl">
                <c:param name="id" value="${category.id}"/>
            </c:url>
            <td>${category.id}</td>

            <td>
                <a href="${editUrl}">${category.name}</a>
            </td>

            <td>${category.description}</td>
        </tr>
    </c:forEach>

    <a href="create">Create new Category</a>

</table>
</body>

</html>
