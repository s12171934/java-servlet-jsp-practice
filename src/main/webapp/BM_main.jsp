<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>도서관리 프로그램</title>
</head>
<body>
<div class="container" style="height: 30vh; margin-top: 5vh">
    <h1>도서관리프로그램</h1>
</div>
<div class="container" style="height: 40vh">
    <div class="container" style="width: 20vw">
        <form action="/main">
            <input type="submit" name="page" value="CheckOut">
    </div>
    <div class="container" style="width: 20vw">
            <input type="submit" name="page" value="BookManager">
    </div>
    <div class="container" style="width: 20vw">
            <input type="submit" name="page" value="UserManager">
        </form>
    </div>
</div>
</body>
</html>