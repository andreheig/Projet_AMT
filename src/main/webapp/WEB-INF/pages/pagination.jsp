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
        <%-- Page param --%>
        <c:choose>
            <%-- Replace page param in URL --%>
            <c:when test="${pageContext.request.queryString != null && pageContext.request.queryString.contains(\"page=\")}">
                <td><a id="Previous" href="${pageContext.request.pathInfo}?${pageContext.request.queryString.replaceFirst("page=[0-9]*", "page=")}${page-1}">Previous</a></td>
            </c:when>
            <%-- Add page param to URL with other params --%>
            <c:when test="${pageContext.request.queryString != null}">
                <td><a id="Previous" href="${pageContext.request.pathInfo}?${pageContext.request.queryString}&page=${page - 1}">Previous</a></td>
            </c:when>
            <%-- Add page param to URL without other params --%>
            <c:otherwise>
                <td><a id="Previous" href="${pageContext.request.pathInfo}?page=${page - 1}">Previous</a></td>
            </c:otherwise>
        </c:choose>
    </c:if>

    <%-- Displays page numbers, except for the current one --%>
    <c:forEach begin="1" end="${nbPages}" var="i">
        <c:choose>
            <c:when test="${page eq i}">
                <td>${i}</td>
            </c:when>
            <c:otherwise>
                <%-- Page param --%>
                <c:choose>
                    <%-- Replace page param in URL --%>
                    <c:when test="${pageContext.request.queryString != null && pageContext.request.queryString.contains(\"page\")}">
                        <td><a id="pagesNumbers" href="${pageContext.request.pathInfo}?${pageContext.request.queryString.replaceFirst("page=[0-9]*", "page=")}${i}">${i}</a></td>
                    </c:when>
                    <%-- Add page param to URL with other params --%>
                    <c:when test="${pageContext.request.queryString != null}">
                        <td><a id="pagesNumbers" href="${pageContext.request.pathInfo}?${pageContext.request.queryString}&page=${i}">${i}</a></td>
                    </c:when>
                    <%-- Add page param to URL without other params --%>
                    <c:otherwise>
                        <td><a id="pagesNumbers" href="${pageContext.request.pathInfo}?page=${i}">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>
    </c:forEach>

    <%-- Displays "next" link, except for last page --%>
    <c:if test="${page lt nbPages}">
        <%-- Add page param to URL --%>
        <c:choose>
            <%-- Replace page param in URL --%>
            <c:when test="${pageContext.request.queryString != null && pageContext.request.queryString.contains(\"page=\")}">
                <td><a id="Next" href="${pageContext.request.pathInfo}?${pageContext.request.queryString.replaceFirst("page=[0-9]*", "page=")}${page+1}">Next</a></td>
            </c:when>
            <%-- Add page param to URL with other params --%>
            <c:when test="${pageContext.request.queryString != null}">
                <td><a id="Next" href="${pageContext.request.pathInfo}?${pageContext.request.queryString}&page=${page + 1}">Next</a></td>
            </c:when>
            <%-- Add page param to URL without other params --%>
            <c:otherwise>
                <td><a id="Next" href="${pageContext.request.pathInfo}?page=${page + 1}">Next</a></td>
            </c:otherwise>
        </c:choose>
    </c:if>
</body>
</html>
