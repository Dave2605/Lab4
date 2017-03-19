<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find Book</title>
</head>
<body>
<form action="find" method="get">
    <input type="text" name="name" value="Book name"/>
    <input type="text" name="author" value="Author name"/>
    <input type="hidden" name="type" value="book"/>
    <input type="submit" value="Find Book">
</form>
</body>
</html>
