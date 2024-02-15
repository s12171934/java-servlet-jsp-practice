<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user-manager" method="post">
    <label for="id">ID</label>
    <input type="text" name="id" id="id"><br>
    <label for="pw">PW</label>
    <input type="text" name="pw" id="pw"><br>
    <label for="pw_check">PW-CHECK</label>
    <input type="text" name="pw_check" id="pw_check"><br>
    <label for="name">NAME</label>
    <input type="text" name="name" id="name"><br>
    <label for="sex">SEX</label>
    <select name="sex" id="sex">
        <option value="male">남</option>
        <option value="female">여</option>
    </select><br>
    <label for="phoneNum">PHONE NUMBER</label>
    <input type="text" name="phoneNum" id="phoneNum"><br>
    <input type="submit" name="feature" value="addUser">
</form>
</body>
</html>
