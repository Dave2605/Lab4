<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new book</title>
</head>
<body>
<form action="add" method="post">
    <table>
        <tr><td>Name:</td><td><input type="text" name="name"/></td></tr>
        <tr><td>Author:</td><td><input type="text" name="author"/></td></tr>
        <tr><td>
            <select name="genre" style="width:150px">
                <option>adventure</option>
                <option>novel</option>
                <option>fiction</option>
            </select>
        </td></tr>
        <input type="hidden" name="type" value="book"/>
        <tr><td colspan="2"><input type="submit" value="Add book"/></td></tr>
    </table>
</form>
<tr><td><form action="/lab4"><input type ="submit" value="Back to the main page"></form></tr></td>
</body>
</html>
