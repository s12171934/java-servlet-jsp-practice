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
<form action="/bookManager/bookAdd.jsp">
    <input type="submit" name ="sel" value="addBook">
</form>
<br>
<form action="/book-manager">
    <select name="type">
        <option value="id">ID</option>
        <option value="name">NAME</option>
        <option value="author">AUTHOR</option>
        <option value="isbn">ISBN</option>
        <option value="publishDate">PUBLISH DATE</option>
        <option value="size">SIZE</option>
        <option value="lang">LANGUAGE</option>
        <option value="len">LENGTH</option>
    </select>
    <select name="asc">
        <option value="true">오름차순</option>
        <option value="false">내림차순</option>
    </select>
    <input type="submit" name ="feature" value="sort">
</form>
<form action="/book-manager">
    <select name="type">
        <option value="id">ID</option>
        <option value="name">NAME</option>
        <option value="author">AUTHOR</option>
        <option value="isbn">ISBN</option>
        <option value="publishDate">PUBLISH DATE</option>
        <option value="size">SIZE</option>
        <option value="lang">LANGUAGE</option>
        <option value="len">LENGTH</option>
    </select>
    <input type="text" name="search">
    <input type="date" name="searchStartTime">
    <input type="date" name="searchEndTime">
    <input type="submit" name ="feature" value="search">
    <input type="submit" name ="feature" value="resetSearch">
</form>
<form action="/bookManager/bookRemove.jsp">
    <input type="submit" value="remove">
</form>
<%
        bm.printBook(request,response);
%>
</body>
</html>
