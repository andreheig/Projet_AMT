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

    <title>Log-in AMT 2018</title>

    <link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>

    <link rel="stylesheet" href="static/css/style.css" media="screen" type="text/css" />

</head>

<body>

<div class="register">

    <% if(request.getAttribute("error") != null) {%>
    <div class="error">Une erreur a été rencontrée: <%=request.getAttribute("error")%></div>
    <%}%>


    <%
        String login_msg=(String)request.getAttribute("error");
        if(login_msg!=null)
            out.println("<font color=red size=4px>"+login_msg+"</font>");
    %>


    <c:if test="${not empty error}">
        <c:out value="${error}"> </c:out>
    </c:if>


    <h1>Log-in</h1><br>

    <form method="POST" action="login">
        <c:if test="${not empty emailNull || emailInccorect}">
            <c:out value="${emailNull}"> </c:out>
        </c:if>
        <input id="login_email" type="text" name="email" placeholder="Username">
        <c:if test="${not empty passwordNull}">
            <c:out value="${error}"> </c:out>
        </c:if>
        <input id="login_password" type="password" name="password" placeholder="Password">
        <input id="login_submit" type="submit" name="login" class="login login-submit" value="login">
    </form>

    <div class="login-help">
        <a href="register">Register</a> • <a href="#">Forgot Password <= vraiment neccessaire?</a>
    </div>
</div>

<!-- <div id="error"><img src="https://dl.dropboxusercontent.com/u/23299152/Delete-icon.png" /> Your caps-lock is on.</div> -->

<script src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>

</body>
</html>
