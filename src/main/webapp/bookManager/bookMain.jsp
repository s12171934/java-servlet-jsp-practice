<%@ page import="bookManager.BookManager" %>
<%@ page import="bookManager.BM" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    BM bm = (BookManager)request.getAttribute("BM");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/bookManager/bookEdit.jsp">
    <input type="submit" value="등록하기">
</form>
<%
    try{
        bm.printBook(response);
    } catch (Exception e){
        response.getWriter().println("책없음");
    }
%>
</body>
</html>
