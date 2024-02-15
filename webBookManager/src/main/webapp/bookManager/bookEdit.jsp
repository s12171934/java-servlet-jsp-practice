<%@ page import="bookManager.book.Book" %>
<%@ page import="bookManager.book.Ebook" %>
<%@ page import="bookManager.book.AudioBook" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    Book book = (Book)application.getAttribute("Book");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/book-manager" method="post">
    <label for="classType">classType</label>
    <input type="text" name="classType" id="classType" value=<%=book.getClassType()%> readOnly><br>
    <label for="id">ID</label>
    <input type="text" name="id" id="id" value=<%=book.getId()%> readOnly><br>
    <label for="name">NAME</label>
    <input type="text" name="name" id="name" value=<%=book.getName()%>><br>
    <label for="author">AUTHOR</label>
    <input type="text" name="author" id="author" value=<%=book.getAuthor()%>><br>
    <label for="isbn">ISBN</label>
    <input type="text" name="isbn" id="isbn" value=<%=book.getIsbn()%> readOnly><br>
    <label for="publishDate">PUBLISH DATE</label>
    <input type="date" name="publishDate" id="publishDate" value=<%=book.getPublishDate()%>><br>
    <label for="size">SIZE</label>
    <input type="text" name="size" id="size" value=<%=!book.getClassType().equals("Book")?((Ebook)book).getSize():"-"%>><br>
    <label for="lang">LANGUAGE</label>
    <input type="text" name="lang" id="lang" value=<%=book.getClassType().equals("AudioBook")?((AudioBook)book).getLang():"-"%>><br>
    <label for="len">LENGTH</label>
    <input type="text" name="len" id="len" value=<%=book.getClassType().equals("AudioBook")?((AudioBook)book).getLen():"-"%>><br>
    <input type="submit" name="feature" value="editBook">
</form>
</body>
</html>
