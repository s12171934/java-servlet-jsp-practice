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
<form action="/check-out-in" method="post">
    <label for="id">ID</label>
    <input type="text" name="id" id="id"><br>
    <label for="pw">PW</label>
    <input type="text" name="pw" id="pw"><br>
    <input type="submit" name="feature" value="checkOut">
</form>
<form action="/checkOut/checkOutInfo.jsp" method="post">
    <label for="ids">ID</label>
    <input type="text" name="id" id="ids"><br>
    <label for="pws">PW</label>
    <input type="text" name="pw" id="pws"><br>
    <input type="submit" name="feature" value="checkIn">
</form>
</body>
</html>
