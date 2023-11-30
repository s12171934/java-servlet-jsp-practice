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
    <label for="ids">ID</label>
    <input type="text" name="id" id="ids" value=<%=request.getParameter("id")%>><br>
    <label for="pws">PW</label>
    <input type="text" name="pw" id="pws" value=<%=request.getParameter("pw")%>><br>
    <label for="book">Book</label>
    <input type="text" name="bookId" id="book"><br>
    <input type="submit" name="feature" value="checkIn">
</form>
</body>
</html>
