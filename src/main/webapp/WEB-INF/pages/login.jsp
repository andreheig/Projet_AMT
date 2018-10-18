<%--
  Created by IntelliJ IDEA.
  User: Andre
  Date: 18.10.2018
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="UTF-8">

    <title>CodePen - Log-in</title>

    <link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>

    <link rel="stylesheet" href="static/css/style.css" media="screen" type="text/css" />

</head>

<body>

<div class="login-card">
    <h1>Log-in</h1><br>
    <form>
        <input type="text" name="user" placeholder="Username">
        <input type="password" name="pass" placeholder="Password">
        <input type="submit" name="login" class="login login-submit" value="login">
    </form>

    <div class="login-help">
        <a href="#">Register</a> • <a href="#">Forgot Password</a>
    </div>
</div>

<!-- <div id="error"><img src="https://dl.dropboxusercontent.com/u/23299152/Delete-icon.png" /> Your caps-lock is on.</div> -->

<script src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>

</body>
</html>
