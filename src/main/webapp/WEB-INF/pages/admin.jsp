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
        <td>Id</td>
        <td>First name</td>
        <td>Last name</td>
        <td>Email</td>
        <td>Account type</td>
        <c:forEach items="${developpers}" var = "dev">
            <tr>
                <td>${dev.id}</td>
                <td>${dev.firstName}</td>
                <td>${dev.lastName}</td>
                <td>${dev.email}</td>
                <td>${dev.accountType}</td>
                <td>
                    <form method="POST" action="admin">
                        <input type="submit" name ="reset-${dev.id}" value="Reset password">
                    </form>
                </td>
                <c:choose>
                    <c:when test="${dev.isAccountSuspended}">
                        <td>
                            <form method="POST" action="admin">
                                <input type="submit" name="reactivate-${dev.id}" value="Reactivate account">
                            </form>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td>
                            <form method="POST" action="admin">
                                <input type="submit" name="suspend-${dev.id}" value="Suspend account">
                            </form>
                        </td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
