<%@ page import="userManager.user.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    User user = (User)application.getAttribute("User");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user-manager" method="post">
    <label for="id">ID</label>
    <input type="text" name="id" id="id" value=<%=user.getId()%> readOnly><br>
    <label for="pw">PW</label>
    <input type="text" name="pw" id="pw"><br>
    <input type="submit" name="feature" value="removeUser">
</form>
</body>
</html>
