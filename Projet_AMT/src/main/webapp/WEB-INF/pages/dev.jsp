<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 23.10.2018
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Applications</title>
</head>
<body>

<jsp:include page="header.jsp" />

    <h1>Applications</h1>
<form method="POST">
    <input type="submit" id="newApp" name="new-application-${user.userId}" value="New application">
</form>
    <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
        </tr>
    <c:forEach items="${apps}" var="appli">
        <tr>
            <td>${appli.id}</td>
            <td>${appli.name}</td>
            <td>${appli.description}</td>
            <td>
                <form method="POST">
                    <input type="submit" name="update-app-${appli.id}" value="Update application">
                </form>
            </td>
            <td>
                <form method="POST">
                    <input type="submit" name="delete-app-${appli.id}" value="Delete application">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="pagination.jsp" />
</body>
</html>
