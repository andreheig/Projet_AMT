<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 23.10.2018
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Applications</title>
</head>
<body>

<jsp:include page="header.jsp" />

    <h1>Applications</h1>
    <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
        </tr>
    <c:forEach items="${applications}" var="appli">
        <tr>
            <td>${appli.id}</td>
            <td>${appli.name}</td>
            <td>${appli.description}</td>
        </tr>
    </c:forEach>
</table>

<%--For displaying Previous link except for the 1st page --%>
<c:if test="${page != 1}">
    <td><a href="dev?page=${page - 1}">Previous</a></td>
</c:if>

<%--For displaying Previous link except for the 1st page --%>
<c:if test="${page != 1}">
    <td><a href="dev?page=${page - 1}">Previous</a></td>
</c:if>

<%--For displaying Page numbers.
The when condition does not display a link for the current page--%>
<table border="1" cellpadding="5" cellspacing="5">
    <tr>
        <c:forEach begin="1" end="${nbPage}" var="i">
            <c:choose>
                <c:when test="${page eq i}">
                    <td>${i}</td>
                </c:when>
                <c:otherwise>
                    <td><a href="dev?page=${i}">${i}</a></td>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </tr>
</table>

<%--For displaying Next link --%>
<c:if test="${page lt nbPage}">
    <td><a href="dev?page=${page + 1}">Next</a></td>
</c:if>
</body>
</html>
