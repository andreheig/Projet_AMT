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
    <c:if test="${session.user.accountType == 'dev'}">
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
    </c:if>
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

    <c:if test="${session.user.accountType == 'admin'}">
        <table>
            <h1>Dev</h1>
            <c:forEach items="${developpers}" var="dev">
                <tr>
                    <td>${dev.id}</td>
                    <td>${dev.firstName}</td>
                    <td>${dev.lastName}</td>
                    <td>${dev.email}</td>
                    <td>${dev.accountType}</td>
                </tr>
            </c:forEach>

        </table>
    </c:if>
    <table>
        <h1>Dev</h1>
        <c:forEach items="${developpers}" var="dev">
            <tr>
                <td>${dev.id}</td>
                <td>${dev.firstName}</td>
                <td>${dev.lastName}</td>
                <td>${dev.email}</td>
                <td>${dev.accountType}</td>
            </tr>
        </c:forEach>

    </table>

<table>
    <h1>Users</h1>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.accountType}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
