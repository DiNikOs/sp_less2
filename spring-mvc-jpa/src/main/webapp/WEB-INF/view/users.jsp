<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Users</title>
</head>
<body>

<a href="create">Create new User</a>

<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
    </tr>

    <c:forEach items="${users}" var="user">
        <tr>
            <c:url value="/users/edit" var="editUrl">
                <c:param name="id" value="${user.id}"/>
            </c:url>
            <td>${user.id}</td>

            <td>
                <a href="${editUrl}">${user.name}</a>
            </td>

            <td>${user.description}</td>
        </tr>
    </c:forEach>

</table>
</body>

</html>
