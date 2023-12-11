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
<div style="background: gray; height: 5vh"></div>
<div style="height: 15vh; text-align: center">
    <div style="height: 100%; width: 70vw">도서관리프로그램</div>
</div>
<div style="background: gray; height: 1vh"></div>
<div style="height: 75vh; display:flex">
    <div style="padding-top: 1vh;padding-right: 1vw">
        <form action="/user-manager">
            <select name="type">
                <option value="id">ID</option>
                <option value="name">NAME</option>
            </select>
            <select name="asc">
                <option value="true">오름차순</option>
                <option value="false">내림차순</option>
            </select>
            <br>
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
            <br>
            <input type="submit" name ="feature" value="search">
            <input type="submit" name ="feature" value="resetSearch">
        </form>
        <form action="/userManager/userAdd.jsp">
            <input type="submit" name ="sel" value="addUser">
        </form>
    </div>
    <div style="background: gray; width: 0.5vw"></div>
    <div style="padding-top: 1vh;padding-left: 1vw">
        <%=print%>
    </div>
</div>
</body>
</html>
