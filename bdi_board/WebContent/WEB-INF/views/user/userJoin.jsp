<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
<c:if test="${cnt eq 1}">
	<script>
		alert("회원가입이 정상적으로 완료되었습니다.");
		//TODO 로그인 페이지로 이동
		
	</script>
</c:if>
${list }
        <article class="container">
            <div class="page-header">
                <div class="col-md-6 col-md-offset-3">
                <h3>회원가입 Form</h3>
                </div>
            </div>
            <div class="col-sm-6 col-md-offset-3">
                <form role="form" action="/user/userJoin" method="post">
                    <div class="form-group">
                        <label for="inputName">성명*</label>
                        <input type="text" class="form-control" name="uiname" id="uiname" required placeholder="이름을 입력해 주세요">
                    </div>
                    <div class="form-group">
                        <label for="InputEmail">아이디*</label>
                        <input type="text" class="form-control" name="uiid" id="uiid" required placeholder="이메일 주소를 입력해주세요">
                    </div>
                    <div class="form-group">
                        <label for="InputEmail">이메일 주소*</label>
                        <input type="email" class="form-control" name="uiemail" id="uiemail" required placeholder="이메일 주소를 입력해주세요">
                    </div>
                    <div class="form-group">
                        <label for="inputPassword">비밀번호*</label>
                        <input type="password" class="form-control" name="uipwd" id="uipwd" required placeholder="비밀번호를 입력해주세요">
                    </div>
                    <div class="form-group text-center">
                        <button type="summit" id="join-submit" class="btn btn-primary">
                            회원가입<i class="fa fa-check spaceLeft"></i>
                        </button>
                        <button type="button" class="btn btn-warning">
                            가입취소<i class="fa fa-times spaceLeft"></i>
                        </button>
                    </div>
                </form>
            </div>

        </article>