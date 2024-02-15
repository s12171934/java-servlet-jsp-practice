<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<form action="/book-manager" style="height: 75vh; display:flex; flex-direction: column; align-items: center" method="post">
    <div style="display:flex; height: 46vh; margin-top: 2vh; margin-bottom: 2vh; background: gray">
        <div style="padding-left: 2vw; padding-right: 2vw; padding-top: 2vh">
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
            <input type="date" name="publishDate" id="publishDate">
        </div>
        <div style="background: white; width: 0.5vw"></div>
        <div style="padding-left: 2vw; padding-right: 2vw; padding-top: 2vh">
            <label for="size">SIZE</label>
            <input type="text" name="size" id="size"><br>
            <label for="lang">LANGUAGE</label>
            <input type="text" name="lang" id="lang"><br>
            <label for="len">LENGTH</label>
            <input type="text" name="len" id="len"><br>
        </div>
    </div>
    <div>
        <input type="submit" name="feature" value="addBook">
    </div>
</form>
</body>
</html>
