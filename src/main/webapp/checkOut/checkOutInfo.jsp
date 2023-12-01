<%@ page import="userManager.user.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="userManager.UM" %>
<%@ page import="userManager.UserManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    UM um = (UserManager)application.getAttribute("UM");
    User user = um.getUser(request.getParameter("id"));
    ArrayList<String> books = user.getCheckOutBook();

    String option = "";
    for(String book : books){
        option += "<option value=\"" + book + "\">" + book + "</option>";
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/check-out-in" method="post">
    <label for="ids">ID</label>
    <input type="text" name="id" id="ids" value=<%=request.getParameter("id")%> readOnly><br>
    <label for="pws">PW</label>
    <input type="text" name="pw" id="pws" value=<%=request.getParameter("pw")%> readOnly><br>
    <label for="book">Book</label>
    <select name="bookId" id="book">
    <%=option%>
    </select>
    <input type="submit" name="feature" value="checkIn">
</form>
</body>
</html>
