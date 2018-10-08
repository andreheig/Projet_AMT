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
    <title>login</title>
</head>
<body>
<form method="POST" action="form">
    <fieldset>
        <legend>Informations</legend>
        <label for="firstName">Prénom <span class="requis">*</span></label>
        <input type="text" id="firstName" name="firstName" value="${people.firstName}" size="20" maxlength="20" />
        <c:if test="${not empty error}">
            <c:if test="${empty people.firstName}">
                <p>Prénom manquant</p>
            </c:if>
        </c:if>
        <br />

        <label for="lastName">Nom <span class="requis">*</span></label>
        <input type="text" id="lastName" name="lastName" value="${people.lastName}" size="20" maxlength="20" />
        <c:if test="${not empty error}">
            <c:if test="${empty people.lastName}">
                <p>Nom manquant</p>
            </c:if>
        </c:if>
        <br />

        <label for="email">Adresse email <span class="requis">*</span></label>
        <input type="email" id="email" name="email" value="${people.email}" size="20" maxlength="60" />
        <c:if test="${not empty error}">
            <c:if test="${empty people.email}">
                <p>email manquant ou format éronné (toto@gmail.com)</p>
            </c:if>
        </c:if>
        <br />

        <label for="password">Mot de passe <span class="requis">*</span></label>
        <input type="password" id="password" name="password" value="${people.password}" size="20" maxlength="60" />
        <c:if test="${not empty error}">
            <c:if test="${empty people.password}">
                <p>le mot de passe ne peut-être vide</p>
            </c:if>
        </c:if>
        <br />

        <label for="password2">Retappez le mot de passe <span class="requis">*</span></label>
        <input type="password" id="password2" name="password2" value="${people.password2}" size="20" maxlength="60" />
        <c:if test="${not empty error}">
            <c:if test="${empty people.password}">
                <p>le mot de passe ne peut-être vide</p>
            </c:if>
        </c:if>
        <br />


    </fieldset>
    <input type="submit" value="Valider"  />
    <br />
</form>
</body>
</html>
