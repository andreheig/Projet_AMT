<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 23.10.2018
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin page</title>
</head>
<body>
    <table>
        <h1>
            Developpers
        </h1>
        <c:forEach items="${developpers}" var = "dev">
            <tr>
                <td>${dev.id}</td>
                <td>${dev.firstName}</td>
                <td>${dev.lastName}</td>
                <td>${dev.email}</td>
                <td>${dev.accountType}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
