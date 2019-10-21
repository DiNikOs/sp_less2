<%--
  Created by IntelliJ IDEA.
  User: Dion
  Date: 20.10.2019
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message</title>
</head>
<body>
<c:forEach items="${msgList}" var="msg">
    <h1>${msg.message}</h1>
</c:forEach>
</body>
</html>
