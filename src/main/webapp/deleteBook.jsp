<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Book</title>
</head>
<body>
<form action="delete" method="post">
    <table>
        <tr><td>ID:</td><td><input type="text" name="id"/></td></tr>
        <tr><td colspan="2"><input type="submit" value="Delete book"/></td></tr>
        <input type="hidden" name="type" value="book"/>
    </table>
</form>
<tr><td><form action="/lab4"><input type ="submit" value="Back to the main page"></form></tr></td>
</body>
</html>
