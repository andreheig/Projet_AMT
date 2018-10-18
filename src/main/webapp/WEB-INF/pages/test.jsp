<%--
  Created by IntelliJ IDEA.
  User: Andre
  Date: 15.10.2018
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
    <c:if test="${session.user.type_compte == 'dev'}">
        <table>
            <h1>Applications</h1>
            <c:forEach items="${applications}" var="appli">
                <tr>
                    <td>${appli.application_id}</td>
                    <td>${appli.name}</td>
                    <td>${appli.description}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <table>
        <h1>Applications</h1>
        <c:forEach items="${applications}" var="appli">
            <tr>
                <td>${appli.application_id}</td>
                <td>${appli.name}</td>
                <td>${appli.description}</td>
            </tr>
        </c:forEach>
    </table>

    <c:if test="${session.user.type_compte == 'admin'}">
        <table>
            <h1>Dev</h1>
            <c:forEach items="${developpers}" var="dev">
                <tr>
                    <td>${dev.user_id}</td>
                    <td>${dev.firstname}</td>
                    <td>${dev.lastname}</td>
                    <td>${dev.email}</td>
                    <td>${dev.type_compte}</td>
                </tr>
            </c:forEach>

        </table>
    </c:if>
    <table>
        <h1>Dev</h1>
        <c:forEach items="${developpers}" var="dev">
            <tr>
                <td>${dev.user_id}</td>
                <td>${dev.firstname}</td>
                <td>${dev.lastname}</td>
                <td>${dev.email}</td>
                <td>${dev.type_compte}</td>
            </tr>
        </c:forEach>

    </table>

<table>
    <h1>Users</h1>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.user_id}</td>
            <td>${user.firstname}</td>
            <td>${user.lastname}</td>
            <td>${user.email}</td>
            <td>${user.type_compte}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
