<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
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


        <div class="login-form">
            <form>
                <h2><b>Bootstrap</b></h2>
                <hr>
                <br>
                <input type="text" name="userId" class="text-field" placeholder="아이디를 입력해주세요">
                <input type="password" name="userPassword" class="text-field" placeholder="비밀번호를 입력해주세요">
                <input type="submit" value="로그인" class="submit-btn btn btn-secondary btn-block">
            </form>

            <div class="links">
                <a href="#">비밀번호를 잊어버리셨나요?</a>
            </div>
        </div>

        <div class="p-2">
            <div class="footer">
                <footer>
                    <span class="text-muted d-flex justify-content-center">Copyright &copy; 2024 Bootstrap board</span>
                </footer>
            </div>
        </div>

    </body>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
    crossorigin="anonymous"></script>

</html>