<%@ page import="java.util.ArrayList" %>
<%@ page import="com.kitri.myservletboard.data.Board" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="com.kitri.myservletboard.data.Pagination" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
  String dateType = (String)request.getAttribute("dateType");
  String type = (String)request.getAttribute("type");
  String search = (String)request.getAttribute("search");
%>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="/view/common/head.jsp">
  <jsp:param name="title" value="게시물 목록"/>
</jsp:include>
<body>
<jsp:include page="/view/common/header.jsp">
  <jsp:param name="dateType" value="<%=dateType%>"/>
  <jsp:param name="type" value="<%=type%>"/>
  <jsp:param name="search" value="<%=search%>"/>
</jsp:include>

  <div>
    <h2 style="text-align: center; margin-top: 100px;"><b>게시판 목록</b></h2>
  </div>
  <div class="container class=d-flex justify-content-center">
    <div class="p-2 border-primary mb-3">
      <table class="table align-middle table-hover text-center">
        <thead class="table-dark">
          <tr>
            <th class="col-1" scope="col">번호</th>
            <th class="col-5" scope="col">제목</th>
            <th class="col-2" scope="col">작성자</th>
            <th class="col-2" scope="col">날짜</th>
            <th class="col-1" scope="col">조회수</th>
            <th class="col-1" scope="col">댓글수</th>
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
            <td class="text-start"><a href="/board/detail?id=<%=board.getId()%>" class="text-dark text-decoration-none"><%=board.getTitle()%></a></td>
            <td class="text-start"><%=board.getWriter()%></td>
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
          String searchQuery = "";
          if(!search.isEmpty() || !dateType.isEmpty()){
            searchQuery = "&dateType=" + dateType + "&type=" + type + "&search=" + search;
          }
        %>
        <ul class="pagination pagination-sm">
          <li class="page-item <%=pagination.isPrev()?"disabled":""%>">
            <a class="page-link" href="/board/list?page=<%=pagination.getStartInGroup() - 1%><%=searchQuery%>" tabindex="-1" aria-disabled="true">&laquo;</a>
          </li>
          <%for(int i = pagination.getStartInGroup(); i <= pagination.getEndInGroup(); i++){%>
          <li class="page-item"><a class="page-link <%=pagination.getPage()==i?"active":""%>" href="/board/list?page=<%=i%><%=searchQuery%>"><%=i%></a></li>
          <%}%>
          <li class="page-item <%=pagination.isNext()?"disabled":""%>">
            <a class="page-link" href="/board/list?page=<%=pagination.getEndInGroup() + 1%><%=searchQuery%>">&raquo;</a>
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