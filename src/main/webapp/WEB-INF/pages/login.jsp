<%--
  Created by IntelliJ IDEA.
  User: SILVERCORP
  Date: 15.10.2018
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>PROJET AMT 2018</title>
    <meta charset="utf-8">
    <meta name="author" content="pixelhint.com">
    <meta name="description" content="Minima is a minimal, clean HTML5 multi-purpose template, well-coded & commented code"/>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
</head>
<body>
<header>

    <div class="wrapper">
        <h1>Log-in</h1><br>
        <form>
            <input type="text" name="user" placeholder="Username">
            <input type="password" name="pass" placeholder="Password">
            <input type="submit" name="login" class="login login-submit" value="login">
        </form>

        <div class="login-help">
            <a href="form">Register</a> • <a href="login">Forgot Password</a>
        </div>
    </div>

</header><!-- End Header -->

<section class="billboard">
    <section class="caption">
        <h1>${message}</h1>
    </section>
</section><!-- End billboard -->

<script src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>

</body>
</html>
