<%@ page import="bookManager.BookManager" %>
<%@ page import="bookManager.BM" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    BM bm = (BookManager)application.getAttribute("BM");
    application.setAttribute("remove","true");
    String print = bm.printBook(request);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%=print%>
</body>
</html>
