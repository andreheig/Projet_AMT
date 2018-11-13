<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 09.11.2018
  Time: 07:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>New application</title>
</head>

<jsp:include page="header.jsp" />

<h1>New application</h1>

<form method="POST" action="newApp" id="newAppForm">
    Application name
    </br>
    <textarea id="newAppName" name="appName" placeholder="Enter the application name here..."
              cols="40" rows="1"></textarea>
    </br>
    Application description
    </br>
    <textarea id="newAppDesc" name="appDescription" placeholder="Enter the application's description name here..."
              cols="40" rows="4"></textarea>
    </br>
    <input id="newAppSubmit" type="submit" name="newAppSubmit" value="Create">
</form>

<body>

</body>
</html>
