<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Users</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <c:url value="/users/edit" var="editUserUrl">
                <c:param name="id" value="${user.id}"/>
            </c:url>
            <td>${user.id}</td>
            <td>
                <a href="${editUserUrl}">${user.name}</a>
            </td>
            <td>${user.description}</td>
        </tr>
    </c:forEach>
    <c:forEach items="${products}" var="prod">
        <tr>
            <td>${prod.id}</td>
            <td>${prod.name}</td>
            <td>${prod.description}</td>
            <td>${prod.user.name}</td>
        </tr>
    </c:forEach>
</table>
<a href="createUser">Create new User</a>
<%--<form action="" method="get">--%>
    <%--<label for="userFilter">User filter</label>--%>
    <%--<select id="UserFilter" name="userId">--%>
        <%--<option value="${-1}" ${param['userId'] == null || param['userId'] == -1 ? 'selected' : ''}></option>--%>
        <%--<c:forEach items="${users}" var="user">--%>
            <%--<option value="${user.id}" ${param['userId'] == user.id ? 'selected' : ''} >${user.name}</option>--%>
        <%--</c:forEach>--%>
    <%--</select>--%>
    <%--<input type="submit" value="Apply" />--%>
<%--</form>--%>
</body>
</html>
