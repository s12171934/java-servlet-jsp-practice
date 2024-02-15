<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%Object result = application.getAttribute("result");%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>스마트 계산기</title>
</head>
<body>
<div id="container">
    <h3>Smart Calculator</h3>
    <form action="calc" method="get">
        <div>
            <input type="text" name="exp">
        </div>
        <div>
            <input type="submit" value="=">&nbsp;<%=result != null ? result:""%>
        </div>
    </form>
</div>
</body>
<style>
    html {
        height: 100%;
    }
    body {
        box-sizing: border-box;
        display: flex;
        align-items: center;
        justify-content: center;
        height: 60%;
    }
    h3 {
        margin-top: 0;
        padding-top: 0;
    }
    #container {
        border-style: solid;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        width: 300px;
        height: 150px;
    }
    input[type="text"] {
        width: 200px;
        margin-bottom: 10px;
    }
</style>
</html>