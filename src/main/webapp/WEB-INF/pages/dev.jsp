<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 23.10.2018
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Applications</title>
</head>
<body>
<table>
    <h1>Applications</h1>
    <c:forEach items="${applications}" var="appli">
        <tr>
            <td>${appli.id}</td>
            <td>${appli.name}</td>
            <td>${appli.description}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
