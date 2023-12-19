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
<div class="head-container">
    <div class="head-box">
        <h1 class="head-box">도서관리프로그램</h1>
    </div>
</div>
<div class="title-container">
    <div style="background: gray; height: 100%; width: 70vw; display: flex; align-items: center; justify-content: center">
        <h1 style="font-size: 5vw; letter-spacing: 3vw">도서관리프로그램</h1>
    </div>
</div>
<div style="height: 50vh; display:flex; justify-content: center">
    <div style="width: 20vw; box-shadow: 0 0 0 1vh gray inset; display:flex; justify-content: center; align-items: center">
        <form action="/main">
            <input type="submit" name="page" value="대출도서반납" style="background: gray; border : none; width: 15vw; height: 40vh; font-size: 2vw">
        </form>
    </div>
    <div style="width: 5vw"></div>
    <div style="width: 20vw; box-shadow: 0 0 0 1vh gray inset; display:flex; justify-content: center; align-items: center">
        <form action="/main">
            <input type="submit" name="page" value="도서관리" style="background: gray; border : none; width: 15vw; height: 40vh; font-size: 2vw">
        </form>
    </div>
    <div style="width: 5vw"></div>
    <div style="width: 20vw; box-shadow: 0 0 0 1vh gray inset; display:flex; justify-content: center; align-items: center">
        <form action="/main">
            <input type="submit" name="page" value="회원관리" style="background: gray; border : none; width: 15vw; height: 40vh; font-size: 2vw">
        </form>
    </div>
</div>
</body>
<style>
    .head-container{
        background: gray;
        height: 5vh;
        padding: 1vh;
    }
    .head-box{
        background: white;
        width: 20vw;
        height: 5vh;
        display: flex;
        align-items: center;
        justify-content: center
    }
    h1.head-box{
        font-size: 2vw;
    }

    .title-container{
        height: 16vh;
        text-align: center;
        margin-top: 7vh;
        margin-bottom: 7vh;
        display:flex;
        justify-content: center;
        align-items: center
    }


</style>
</html>