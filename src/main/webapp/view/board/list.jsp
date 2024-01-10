<%@ page import="java.util.ArrayList" %>
<%@ page import="com.kitri.myservletboard.data.Board" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="com.kitri.myservletboard.data.Pagination" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>게시판목록</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
  <link href="/view/css/main.css" rel="stylesheet">
</head>
<body>
  <header>
    <a class="logo" href="/board/list"><img src="https://poiemaweb.com/img/logo.png"></a>
    <nav>
      <ul class="nav-items">
        <li><a href="/board/list">게시글목록</a></li>
        <li><a href="/board/createForm">게시글등록</a></li>
        <li><a href="/board/updateForm">게시글수정</a></li>
        <li><a href="/view/member/join.jsp">회원가입</a></li>
        <li><a href="/view/member/registration.jsp">회원정보수정</a></li>
        <li><a href="/view/member/login.jsp">로그인</a></li>
      </ul>
    </nav>
  </header>

  <div>
    <h2 style="text-align: center; margin-top: 100px;"><b>게시판 목록</b></h2>
  </div>
  <div class="container class=d-flex justify-content-center">
    <div class="p-2 border-primary mb-3">
      <table class="table align-middle table-hover">
        <thead class="table-dark">
          <tr>
            <th scope="col">번호</th>
            <th scope="col">제목</th>
            <th scope="col">작성자</th>
            <th scope="col">날짜</th>
            <th scope="col">조회수</th>
            <th scope="col">댓글수</th>
          </tr>
        </thead>
        <%
          ArrayList<Board> boards = (ArrayList<Board>)request.getAttribute("boards");
        %>
        <tbody class="table-group-divider">
        <%
          for(Board board : boards){
        %>
          <tr>
            <th scope="row"><%=board.getId()%></th>
            <td><a href="/board/detail?id=<%=board.getId()%>"><%=board.getTitle()%></a></td>
            <td><%=board.getWriter()%></td>
            <td><%=board.getCreatedAt().format(DateTimeFormatter.ofPattern("YYYY/MM/DD - HH:mm"))%></td>
            <td><%=board.getViewCount()%></td>
            <td><%=board.getCommentCount()%></td>
          </tr>
        </tbody>
        <%
          }
        %>
      </table>
      <div>
        <a href="/board/createForm" role="button" class="btn btn-outline-dark">글쓰기</a>
      </div>
      <div class="d-flex justify-content-center">
      <nav aria-label="Page navigation example">
        <%
          Pagination pagination = (Pagination)request.getAttribute("pagination");
        %>
        <ul class="pagination pagination-sm">
          <li class="page-item <%=pagination.isPrev()?"":"disabled"%>">
            <a class="page-link" href="/board/list?page=<%=pagination.getStartInGroup() - 1%>" tabindex="-1" aria-disabled="true">&laquo;</a>
          </li>
          <%for(int i = pagination.getStartInGroup(); i <= pagination.getEndInGroup(); i++){%>
          <li class="page-item"><a class="page-link <%=pagination.getPage()==i?"active":""%>" href="/board/list?page=<%=i%>"><%=i%></a></li>
          <%}%>
          <li class="page-item <%=pagination.isNext()?"":"disabled"%>">
            <a class="page-link" href="/board/list?page=<%=pagination.getEndInGroup() + 1%>">&raquo;</a>
          </li>
        </ul>
      </nav>
    </div>
    </div>
  </div>
  </div>
  <div class="p-2">
    <div class="container d-flex justify-content-center">
      <footer>
        <span class="text-muted">&copy; Company's Bootstrap-board</span>
      </footer>
    </div>
  </div>


</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
  integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

</html>