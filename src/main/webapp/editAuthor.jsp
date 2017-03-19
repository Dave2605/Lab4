<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>

<%String id = request.getParameter("id");%>
<%String name = request.getParameter("name");%>
<%String birthPlace = request.getParameter("birthPlace");%>

<form action="edit" method="post">
    <table>
        <tr><td>ID:</td><td><input type="text" name="id" readonly value="<%=id%>"/></td></tr>
        <tr><td>Name:</td><td><input type="text" name="name" value="<%=name%>"/></td></tr>
        <tr><td>BirthPlace:</td><td><input type="text" name="birthPlace" value="<%=birthPlace%>"/></td></tr>
        <input type="hidden", name="type", value="author"/>
        </td></tr>
        <tr><td colspan="2"><input type="submit" value="Edit"/></td></tr>
    </table>
</form>
<tr><td><form action="/lab4"><input type ="submit" value="Back to the main page"></form></tr></td>
</body>
</html>
