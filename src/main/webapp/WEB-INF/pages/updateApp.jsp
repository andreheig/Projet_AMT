<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 09.11.2018
  Time: 07:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update application</title>
</head>

<jsp:include page="header.jsp" />

<h1>Update application</h1>

<form action = "POST" id="updateAppForm">
    Application name
    </br>
    <textarea id="updateAppName" name="appName" placeholder="Enter the application name here..."></textarea>
    </br>
    Application description
    </br>
    <textarea id="updateAppDesc" name="appDescription" placeholder="Enter the application's description here..."></textarea>
    </br>
    <input id="UpdateAppSubmit" type="submit" name="UpdateAppSubmit" value="update">
</form>

<body>

</body>
</html>
