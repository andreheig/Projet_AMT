<%--
  Created by IntelliJ IDEA.
  User: Andre
  Date: 31.10.2018
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deconnection</title>
</head>
<body>
<%
    request.getSession().removeAttribute("user");
    request.getSession().invalidate();
%>
<jsp:forward page="home.jsp">
    <jsp:param name="msg" value="msg" />
</jsp:forward>
</body>
</html>
