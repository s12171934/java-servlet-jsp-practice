<%@ page import="userManager.UserManager" %>
<%@ page import="userManager.UM" %>
<%@ page import="userManager.user.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    UM um = (UserManager)application.getAttribute("UM");
    User user = um.getUser(request.getParameter("id"));
    application.setAttribute("User",user);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    ID: <%=user.getId()%><br>
    NAME: <%=user.getName()%><br>
    SEX: <%=user.getSex()%><br>
    PHONE NUMBER: <%=user.getPhoneNum()%><br>
</p>
<form action="/userManager/userRemove.jsp">
    <input type="text" style="display: none" name="ids" value=<%=user.getId()%>>
    <input type="submit" name="feature" value="removeUser">
</form>
<form action="/userManager/userMain.jsp">
    <input type="submit" value="목록으로">
</form>
<form action="/userManager/userEdit.jsp">
    <input type="submit" name="sel" value="editUser">
</form>
</body>
</html>
