<%--
  Created by IntelliJ IDEA.
  User: Andre
  Date: 31.10.2018
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<td>
    <tr>
        <th>Welcome : </th>
        <th>${user.firstName}</th>
        <th>${user.lastName}</th>
    </tr>
    <tr>
        <td>Email : </td>
        <td>${user.email}</td>
    </tr>
</td>
<td>
    <form method="POST" action="deconnexion">
        <input type="submit" name ="deco-${user.userId}" value="Log out">
    </form>
</td>
</body>
</html>
