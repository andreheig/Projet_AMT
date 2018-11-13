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
    <title>Update application</title>
</head>

<jsp:include page="header.jsp" />

<h1>Update application</h1>

<form method="POST" id="updateAppForm">
    Application name
    </br>
    <textarea id="updateAppName" name="appName" cols="40" rows="1">${app.name}</textarea>
    </br>
    Application description
    </br>
    <textarea id="updateAppDesc" name="appDescription" cols="40" rows="4">${app.description}</textarea>
    </br>
    <input id="updateAppSubmit" type="submit" name="update-app-${app.id}" value="Update">
</form>
<form method="POST" id="addUserToAppForm">
    <input id="addUserToAppEmail" type="text" name="add-user-${app.id}" placeholder="User email"
            size="40">
    </br>
    <input id="addUserToAppButton" type="submit" name="addUserToAppButton" value="Add user">
</form>

<body>

</body>
</html>
