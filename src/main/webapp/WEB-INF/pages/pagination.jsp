<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 12.11.2018
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

    <%-- Displays "Previous" link, except for first page --%>
    <c:if test="${page != 1}">
        <td><a id="Previous" href="admin?page=${page - 1}">Previous</a></td>
    </c:if>

    <%-- Displays page numbers, except for the current one --%>
    <c:forEach begin="1" end="${nbPages}" var="i">
        <c:choose>
            <c:when test="${page eq i}">
                <td>${i}</td>
            </c:when>
            <c:otherwise>
                <td><a id="pagesNumbers" href="admin?page=${i}">${i}</a></td>
            </c:otherwise>
        </c:choose>
    </c:forEach>

    <%-- Displays "next" link, except for last page --%>
    <c:if test="${page lt nbPages}">
        <%-- <td><a id="Next" href="admin?page=${page + 1}">Next</a></td> --%>
        <td><a id="Next" href=".?page=${page + 1}">Next</a></td>
    </c:if>

</body>
</html>
