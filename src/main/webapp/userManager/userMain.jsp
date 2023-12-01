<%@ page import="userManager.UserManager" %>
<%@ page import="userManager.UM" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UM um = (UserManager)application.getAttribute("UM");
    String print = um.printUser(request);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/userManager/userAdd.jsp">
    <input type="submit" name ="sel" value="addUser">
</form>
<br>
<form action="/user-manager">
    <select name="type">
        <option value="id">ID</option>
        <option value="name">NAME</option>
    </select>
    <select name="asc">
        <option value="true">오름차순</option>
        <option value="false">내림차순</option>
    </select>
    <input type="submit" name ="feature" value="sort">
</form>
<form action="/user-manager">
    <select name="type">
        <option value="id">ID</option>
        <option value="name">NAME</option>
        <option value="sex">SEX</option>
        <option value="phoneNum">PHONE NUMBER</option>
    </select>
    <input type="text" name="search">
    <input type="submit" name ="feature" value="search">
    <input type="submit" name ="feature" value="resetSearch">
</form>
<%=print%>
</body>
</html>
