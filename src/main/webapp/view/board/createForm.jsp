<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>게시글 등록 - Bootstrap</title>

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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
  <div class="container">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-3"><b>게시물 등록</b></h4>
        <hr>
        <br>
        <form class="validation-form" action="/board/create" method="post" novalidate>

          <div class="mb-3">
            <label for="title">제목</label>
            <input type="text" class="form-control" id="title" name ="title" placeholder="제목을 입력해주세요" required>
            <div class="invalid-feedback">
              제목을 입력해주세요.
            </div>
          </div>

          <div class="mb-3">
            <label for="writer">작성자</label>
            <input type="text" class="form-control" id="writer" name="writer" required>
            <div class="invalid-feedback">
              작성자를 입력해주세요.
            </div>
          </div>
          <div class="mb-3">
            <label for="contents" class="form-label">내용</label>
            <textarea name="contents" class="form-control" id="contents" cols="30" rows="5" placeholder="내용을 입력해주세요"></textarea>
          </div>
          <br>
          <div class="row">
            <div class="col-md-6 mb-3">
              <button class="btn btn-secondary btn-block" type="submit">게시물 등록하기</button>
            </div>
            <div class="col-md-6 mb-3">
              <a href="/board/list"><button class="btn btn-secondary btn-block">취소</button></a>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
  <div class="p-2">
    <div class="footer">
      <footer>
        <span class="text-muted d-flex justify-content-center">Copyright &copy; 2024 Bootstrap board</span>
      </footer>
    </div>
  </div>
  </div>
  <script>
    window.addEventListener('load', () => {
      const forms = document.getElementsByClassName('validation-form');

      Array.prototype.filter.call(forms, (form) => {
        form.addEventListener('submit', function (event) {
          if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
          }

          form.classList.add('was-validated');
        }, false);
      });
    }, false);
  </script>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3b"></script>