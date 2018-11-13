<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 11.11.2018
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dev applications </title>
</head>
<body>
    <jsp:include page="header.jsp" />

    <h1>Applications for dev id = ${devId}</h1>
    <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
        </tr>
        <c:forEach items="${apps}" var="app">
            <tr>
                <td>${app.id}</td>
                <td>${app.name}</td>
                <td>${app.description}</td>
            </tr>
        </c:forEach>
    </table>
    <jsp:include page="pagination.jsp" />
</body>
</html>
