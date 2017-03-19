<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show books</title>
</head>
<body>

<table width="100%">
    <tr><th>ID</th><th>Name</th><th>Author</th><th>Genre</th></tr>
    <c:forEach var="book" items="${books}">

    <tr><th>${book.id}</th><th>${book.name}</th><th>${book.author}</th><th>${book.genre}</th><th>
        <form action="editBook.jsp" method="post">
            <input type="hidden" name="id" value=${book.id}>
            <input type="hidden" name="name" value="${book.name}">
            <input type="hidden" name="author" value="${book.author}">
            <input type="hidden" name="genre" value="${book.genre}">
        <input type="submit" value="Edit"></form>
    </th></tr>

    </c:forEach>
</table>

<form action="show" method="get">
    <input type="hidden" name="type" value="author" />
    <input type="submit" value="Authors">
</form>
<form action="deleteBook.jsp"><input type ="submit" value="Delete book"></form>
<form action="/lab4"><input type ="submit" value="Back to the main page"></form>

</body>
</html>
