<%@ page import="bookManager.BM" %>
<%@ page import="bookManager.BookManager" %>
<%@ page import="bookManager.book.Book" %>
<%@ page import="bookManager.book.Ebook" %>
<%@ page import="bookManager.book.AudioBook" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    BM bm = (BookManager)application.getAttribute("BM");
    Book book = bm.getBook(request.getParameter("id"));
    application.setAttribute("Book",book);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    ID: <%=book.getId()%><br>
    NAME: <%=book.getName()%><br>
    AUTHOR: <%=book.getAuthor()%><br>
    ISBN: <%=book.getIsbn()%><br>
    PUBLISH DATE: <%=book.getPublishDate()%><br>
</p>
<p>
    <%
        if(!book.getClassType().equals("Book")){
            response.getWriter().println("SIZE: " + ((Ebook)book).getSize() + "<br>");
            if(book.getClassType().equals("AudioBook")){
                response.getWriter().println("LANGUAGE: " + ((AudioBook)book).getLang() + "<br>");
                response.getWriter().println("LENGTH: " + ((AudioBook)book).getLen() + "<br>");
            }
        }
    %>
</p>
<form action="/book-manager">
    <input type="text" style="display: none" name="ids" value=<%=book.getId()%>>
    <input type="submit" name="feature" value="removeBook">
</form>
<form action="/bookManager/bookMain.jsp">
    <input type="submit" value="목록으로">
</form>
<form action="/bookManager/bookEdit.jsp">
    <input type="submit" name="sel" value="editBook">
</form>
</body>
</html>
