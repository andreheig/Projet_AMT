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

<jsp:include page="header.jsp" />

        <h1>
            Developpers
        </h1>

        <table border="1" cellpadding="5" cellspacing="5">
            <tr>
                <th>Id</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Email</th>
                <th>Account type</th>
                <th>Applications</th>
            </tr>
        <c:forEach items="${developpers}" var = "dev">
            <tr>
                <td>${dev.userId}</td>
                <td>${dev.firstName}</td>
                <td>${dev.lastName}</td>
                <td>${dev.email}</td>
                <td>${dev.accountType}</td>
                <td><a href="admin/devApps?devId=${dev.userId}">See apps</a></td>
                <td>
                    <form method="POST" action="admin">
                        <input type="submit" name ="reset-${dev.userId}" value="Reset password">
                    </form>
                </td>
                <c:choose>
                    <c:when test="${dev.isAccountSuspended}">
                        <td>
                            <form method="POST" action="admin">
                                <input type="submit" name="reactivate-${dev.userId}" value="Reactivate account">
                            </form>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td>
                            <form method="POST" action="admin">
                                <input type="submit" name="suspend-${dev.userId}" value="Suspend account">
                            </form>
                        </td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:forEach>
            </table>

<jsp:include page="pagination.jsp" />

</body>
</html>
