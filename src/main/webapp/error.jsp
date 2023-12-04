<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String url = String.valueOf(application.getAttribute("error"));
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>ERROR!</h1>
<form method="post" action=<%=url%>>
    <input type="submit" value="돌아가기">
</form>
</body>
</html>
