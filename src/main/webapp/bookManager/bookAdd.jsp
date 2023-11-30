<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/book-manager" method="post">
    <label for="classType">classType</label>
    <select name="classType" id="classType">
        <option value="Book">Book</option>
        <option value="Ebook">Ebook</option>
        <option value="AudioBook">AudioBook</option>
    </select><br>
    <label for="id">ID</label>
    <input type="text" name="id" id="id"><br>
    <label for="name">NAME</label>
    <input type="text" name="name" id="name"><br>
    <label for="author">AUTHOR</label>
    <input type="text" name="author" id="author"><br>
    <label for="isbn">ISBN</label>
    <input type="text" name="isbn" id="isbn"><br>
    <label for="publishDate">PUBLISH DATE</label>
    <input type="date" name="publishDate" id="publishDate"><br>
    <label for="size">SIZE</label>
    <input type="text" name="size" id="size"><br>
    <label for="lang">LANGUAGE</label>
    <input type="text" name="lang" id="lang"><br>
    <label for="len">LENGTH</label>
    <input type="text" name="len" id="len"><br>
    <input type="submit" name="feature" value="addBook">
</form>
</body>
</html>
