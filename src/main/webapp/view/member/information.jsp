<%@ page import="com.kitri.myservletboard.data.Member" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<jsp:include page="/view/common/head.jsp">
    <jsp:param name="title" value="회원정보"/>
</jsp:include>
<body>
<jsp:include page="/view/common/header.jsp"/>
<%
    Member member = (Member)session.getAttribute("member");
%>

    <div class="container">
        <div class="input-form-backgroud row">
            <div class="input-form col-md-12 mx-auto">
                <h4 class="mb-3"><b>회원 정보</b></h4>
                <hr>
                <br>
                <form action="/member/delete" class="validation-form" method="post" novalidate>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="name">이름</label>
                            <input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력해주세요" value="<%=member.getName()%>" readonly>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="name">아이디</label>
                            <input type="text" class="form-control" id="userId" name="id" placeholder="아이디를 입력해주세요" value="<%=member.getId()%>" readonly>
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="email">이메일</label>
                        <input type="email" class="form-control" id="email" name="email" value="<%=member.getEmail()%>" readonly>
                    </div>

                    <hr class="mb-4">
                    <br>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <button class="btn btn-danger btn-block" type="submit" name="delete" value="yes">회원 탈퇴하기</button>
                        </div>
                        <div class="col-md-6 mb-3">
                            <button class="btn btn-secondary btn-block" type="submit" name="delete" value="no">돌아가기</button>
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