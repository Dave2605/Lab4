<%@ page import="java.util.List" %>
<%@ page import="java.util.*" %>
<%@ page import="model.Author" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show Authors</title>
</head>
<body>

<table width="100%">
    <tr><th>ID</th><th>Name</th><th>Birth place</th></tr>
    <c:forEach var="author" items="${authors}">

        <tr><th>${author.id}</th><th>${author.name}</th><th>${author.birth_place}</th><th>
            <form action="editAuthor.jsp" method="post">
                <input type="hidden" name="id" value="${author.id}">
                <input type="hidden" name="name" value="${author.name}">
                <input type="hidden" name="author" value="${author.birth_place}">
                <input type="submit" value="Edit"></form>
        </th></tr>

    </c:forEach>
</table>

<form action="deleteAuthor.jsp"><input type ="submit" value="Delete author"></form>
<form action="/lab4"><input type ="submit" value="Back to the main page"></form>

</body>
</html>
