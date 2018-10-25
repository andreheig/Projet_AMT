<%--
  Created by IntelliJ IDEA.
  User: Andre
  Date: 25.10.2018
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">

    <title>Changement de Password</title>
</head>
<body>
<div class="changePass">
    <h1>Changement de Password</h1><br>
    <form method="POST" action="changePass">
        <label for="password">Mot de passe <span class="requis">*</span></label>
        <input type="password" id="password" name="password" value="${developper.password}" size="20" maxlength="60" />
        <c:if test="${passwordNull}">
            <c:out> ${passwordNull}</c:out>
        </c:if>
        <br />

        <label for="passwordCheck">Retappez le mot de passe <span class="requis">*</span></label>
        <input type="password" id="passwordCheck" name="passwordCheck" value="" size="20" maxlength="60" />
        <c:choose>
            <c:when test="${password2Null}">
                <c:out> ${password2Null}</c:out>
            </c:when>
            <c:otherwise test="${password2NotMatch}">
                <c:out> ${password2NotMatch}</c:out>
            </c:otherwise>
        </c:choose>
        <br />
        <input type="submit" name="changePass" class="changePass changePass-submit" value="Mise a jour">
    </form>
</div>
</body>
</html>
