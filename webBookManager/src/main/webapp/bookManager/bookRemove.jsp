<%@ page import="bookManager.BookManager" %>
<%@ page import="bookManager.BM" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    BM bm = (BookManager)application.getAttribute("BM");
    application.setAttribute("removeBook","true");
    String print = bm.printBook(request);
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
    <div style="padding-top: 1vh">
        <%=print%>
    </div>
</div>
</body>
</html>
