<%@ page import="bookManager.BookManager" %>
<%@ page import="bookManager.BM" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    BM bm = (BookManager)application.getAttribute("BM");

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    bm.printBook(request,response);
%>
<form action="/book-manager">
    <input type="submit" value="removeBook">
</form>
</body>
</html>
