<%--
  Created by IntelliJ IDEA.
  User: Andre
  Date: 08.10.2018
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inscription</title>
<%--
<link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>

<link rel="stylesheet" href="static/css/register.css" media="screen" type="text/css" />
--%>
</head>
<body>
<div class="register-card">
<form method="POST" action="register">

        <legend>Informations</legend>
        <label for="registerFirstName">Prénom <span class="requis">*</span></label>
        <input type="text" id="registerFirstName" name="firstName" placeholder="Prénom" value="${developper.firstName}" size="20" maxlength="20" />
        <c:if test="${not empty firstNameNull}">
            <c:out> ${firstNameNull}</c:out>
        </c:if>
        <br />

        <label for="registerLastName">Nom <span class="requis">*</span></label>
        <input type="text" id="registerLastName" name="lastName" placeholder="Nom" value="${developper.lastName}" size="20" maxlength="20" />
        <c:if test="${empty lastNameNull}">
            <c:out> ${lastNameNull}</c:out>
        </c:if>
        <br />

        <label for="registerEmail">Adresse email <span class="requis">*</span></label>
        <input type="email" id="registerEmail" name="email" placeholder="E-mail" value="${developper.email}" size="20" maxlength="60" />
        <c:choose>
        <c:when test="${emailNull}">
            <c:out> ${emailNull}</c:out>
        </c:when>
        <c:otherwise test="${emailInccorect}">
            <c:out> ${emailInccorect}</c:out>
        </c:otherwise>
        </c:choose>
        <br />

        <label for="registerPassword">Mot de passe <span class="requis">*</span></label>
        <input type="password" id="registerPassword" name="password" placeholder="Password" value="${developper.password}" size="20" maxlength="60" />
        <c:if test="${passwordNull}">
            <c:out> ${passwordNull}</c:out>
        </c:if>
        <br />

        <label for="registerPassword2">Retappez le mot de passe <span class="requis">*</span></label>
        <input type="password" id="registerPassword2" name="password2" placeholder="Password" value="" size="20" maxlength="60" />
        <c:choose>
        <c:when test="${password2Null}">
            <c:out> ${password2Null}</c:out>
        </c:when>
        <c:otherwise test="${password2NotMatch}">
            <c:out> ${password2NotMatch}</c:out>
        </c:otherwise>
        </c:choose>
        <br />


    <input type="submit" id="registerSubmit" class="registry registry-submit" value="Valider"> </input>
    <br />
</form>
</div>
</body>
</html>
