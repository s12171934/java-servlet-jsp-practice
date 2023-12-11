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
<div style="background: gray; height: 5vh"></div>
<div style="height: 16vh; text-align: center; margin-top: 7vh;margin-bottom: 7vh; display:flex; justify-content: center; align-items: center">
    <div style="background: gray; height: 100%; width: 70vw">도서관리프로그램</div>
</div>
<div style="height: 50vh; display:flex; justify-content: center">
    <div style="width: 20vw; box-shadow: 0 0 0 10px gray inset; display:flex; justify-content: center; align-items: center">
        <form action="/main">
            <input type="submit" name="page" value="RentManager" style="width: 15vw; height: 40vh">
        </form>
    </div>
    <div style="width: 5vw"></div>
    <div style="width: 20vw; box-shadow: 0 0 0 10px gray inset; display:flex; justify-content: center; align-items: center">
        <form action="/main">
            <input type="submit" name="page" value="BookManager" style="width: 15vw; height: 40vh">
        </form>
    </div>
    <div style="width: 5vw"></div>
    <div style="width: 20vw; box-shadow: 0 0 0 10px gray inset; display:flex; justify-content: center; align-items: center">
        <form action="/main">
            <input type="submit" name="page" value="UserManager" style="width: 15vw; height: 40vh">
        </form>
    </div>
</div>
</body>
</html>