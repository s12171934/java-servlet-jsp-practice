<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link href="/view/css/main.css" rel="stylesheet">
</head>
<body>
    <header class="d-flex justify-content-between">
        <div class="d-flex">
            <div>
                <a class="logo" href="/board/list"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtjBjQdSHP4pkwsq4kMJgu_Ft4nVxbVmIo6A&usqp=CAU"></a>
            </div>
            <nav>
                <ul class="nav-items d-flex">
                    <li ><a href="/board/list">게시글목록</a></li>
                    <li ><a href="/view/member/join.jsp">회원가입</a></li>
                    <li ><a href="/view/member/registration.jsp">회원정보수정</a></li>
                    <li ><a href="/view/member/login.jsp">로그인</a></li>
                </ul>
            </nav>
        </div>
        <form class="d-flex align-items-center w-50 me-5" action="/board/list">
            <select name="dateType" class="form-control text-center me-2 col-2">
                <%
                    String dateType = request.getParameter("dateType");
                    if(dateType == null) dateType = "all";
                %>
                <option value="all" <%if(dateType.equals("all")){%>selected<%}%>>기간 전체</option>
                <option value="day" <%if(dateType.equals("day")){%>selected<%}%>>1일</option>
                <option value="week" <%if(dateType.equals("week")){%>selected<%}%>>1주</option>
                <option value="month" <%if(dateType.equals("month")){%>selected<%}%>>1개월</option>
                <option value="year" <%if(dateType.equals("year")){%>selected<%}%>>1년</option>
            </select>
            <select name="type" class="form-control text-center me-2 col-2">
                <%
                    String type = request.getParameter("type");
                    if(type == null) type = "title";
                %>
                <option value="title" <%if(type.equals("title")){%>selected<%}%>>제목</option>
                <option value="writer" <%if(type.equals("writer")){%>selected<%}%>>작성자</option>
            </select>
            <input class="form-control me-2 col-6" type="search" name="search" value="${param.search}" placeholder="검색어를 입력하세요.">
            <button class="btn btn-secondary btn-block me-2 col-2" type="submit">검색</button>
        </form>
    </header>
</body>
</html>
