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
    <label for="name">NAME</label>
    <input type="text" name="name" id="name" value=<%=user.getName()%> readOnly><br>
    <label for="sex">SEX</label>
    <input type="text" name="sex" id="sex" value=<%=user.getSex()%> readOnly><br>
    <label for="phoneNum">PHONE NUMBER</label>
    <input type="text" name="phoneNum" id="phoneNum" value=<%=user.getPhoneNum()%>><br>
    <input type="submit" name="feature" value="editUser">
</form>
</body>
</html>
