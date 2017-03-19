<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new author</title>
</head>
<body>
<form action="add" method="post">
    <table>
        <tr><td>Name:</td><td><input type="text" name="name"/></td></tr>
        <tr><td>Birth place:</td><td><input type="text" name="birthPlace"/></td></tr>
        <input type="hidden" name="type" value="author"/>
        <tr><td colspan="2"><input type="submit" value="Add author"/></td></tr>
    </table>
</form>
<tr><td><form action="/lab4"><input type ="submit" value="Back to the main page"></form></tr></td>
</body>
</html>
