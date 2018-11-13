<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Andre
  Date: 18.10.2018
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Log-in AMT 2018</title>

    <link rel="stylesheet" href="static/css/style.css" media="screen" type="text/css" />

    <link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>

</head>

<body>

<div class="register">
    <br>
    <c:if test="${not empty error }">
        <c:out value="${error}">${error}</c:out>
    </c:if>

    <br />

    <h1>Log-in</h1>

    <br>
    <form method="POST" action="login">

        <c:if test="${not empty emailNull || not empty emailInccorect }">
            <c:out value="${emailNull}">${emailNull}</c:out>
            <c:out value="${emailInccorect}">${emailInccorect}</c:out>
        </c:if>
        <br />


        <input id="loginEmail" type="text" name="email" placeholder="Username">

        <br>

        <c:if test="${not empty passwordNull}">
            <c:out value="${passwordNull}">${passwordNull}</c:out>
        </c:if>
        <br />

        <input id="loginPassword" type="password" name="password" placeholder="Password">
        <input id="loginSubmit" type="submit" name="login" class="login login-submit" value="login"> </input>
    </form>

    <div class="login-help">
        <a href="register">Register</a> • <a href="forgotPassword">Forgot Pass</a>
    </div>
</div>

<script src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>

</body>
</html>
