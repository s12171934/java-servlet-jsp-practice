<%@ page import="java.util.ArrayList" %>
<%@ page import="com.kitri.myservletboard.data.Board" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="com.kitri.myservletboard.data.Pagination" %>
<%@ page import="com.kitri.myservletboard.data.SearchBoard" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
  SearchBoard searchBoard = (SearchBoard) request.getAttribute("searchBoard");
  ArrayList<Board> boards = (ArrayList<Board>)request.getAttribute("boards");
  Pagination pagination = (Pagination)request.getAttribute("pagination");
  String orderBy = searchBoard.getOrderBy();
  int rows = (int)request.getAttribute("rows");
  String searchQuery = "";
  if(!searchBoard.getSearchText().isEmpty() || !searchBoard.getPeriod().equals("all")){
    searchQuery = "&period=" + searchBoard.getPeriod() + "&type=" + searchBoard.getType() + "&searchText=" + searchBoard.getSearchText();
  }
%>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="/view/common/head.jsp">
  <jsp:param name="title" value="게시물 목록"/>
</jsp:include>
<body>
<jsp:include page="/view/common/header.jsp">
  <jsp:param name="period" value="<%=searchBoard.getPeriod()%>"/>
  <jsp:param name="type" value="<%=searchBoard.getType()%>"/>
  <jsp:param name="searchText" value="<%=searchBoard.getSearchText()%>"/>
</jsp:include>


  <div class="container">
    <div class="row">
      <div class="col-3"></div>
      <div class="col-6">
        <h2 style="text-align: center; margin-top: 100px;"><b>게시판 목록</b></h2>
      </div>
      <form action="/board/list" class="d-flex align-items-end col-3" method="post">
        <input type="text" name="period" value="<%=searchBoard.getPeriod()%>" hidden="hidden">
        <input type="text" name="type" value="<%=searchBoard.getType()%>" hidden="hidden">
        <input type="text" name="searchText" value="<%=searchBoard.getSearchText()%>" hidden="hidden">
        <select name="orderBy" class="form-control text-center me-2" onchange="this.form.submit()">
          <option value="createAt DESC" <%if(orderBy.equals("createAt DESC")){%>selected<%}%>>최신순</option>
          <option value="createAt" <%if(orderBy.equals("createAt")){%>selected<%}%>>오래된순</option>
          <option value="viewCount" <%if(orderBy.equals("viewCount")){%>selected<%}%>>조회순</option>
          <option value="title" <%if(orderBy.equals("title")){%>selected<%}%>
                  <%if(searchBoard.getSearchText().isEmpty()){%>disabled<%}%>>정확도순</option>
        </select>
        <select name="rows" class="form-control text-center me-2" onchange="this.form.submit()">
          <option value="5" <%if(rows == 5){%>selected<%}%>>5개씩 보기</option>
          <option value="10" <%if(rows == 10){%>selected<%}%>>10개씩 보기</option>
          <option value="15" <%if(rows == 15){%>selected<%}%>>15개씩 보기</option>
          <option value="20" <%if(rows == 20){%>selected<%}%>>20개씩 보기</option>
          <option value="25" <%if(rows == 25){%>selected<%}%>>25개씩 보기</option>
          <option value="30" <%if(rows == 30){%>selected<%}%>>30개씩 보기</option>
        </select>
      </form>
    </div>
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