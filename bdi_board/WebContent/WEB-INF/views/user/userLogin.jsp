<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
<c:if test="${!empty msg}">
	<script>
		alert("${msg}");
		location.href="/";
	</script>
</c:if>

<c:if test="${!empty err}">
	<script>
		alert("${err}");
	</script>
</c:if>
		<article class="container">
            <div class="page-header">
                <div class="col-md-6 col-md-offset-3">
                <h3>로그인</h3>
                </div>
            </div>
            <div class="col-sm-6 col-md-offset-3">
                <form role="form" action="/user/userLogin" method="post">
                    <div class="form-group">
                        <label for="InputEmail">아이디*</label>
                        <input type="text" class="form-control" name="uiid" id="uiid" required placeholder="이메일 주소를 입력해주세요">
                    </div>
                    <div class="form-group">
                        <label for="inputPassword">비밀번호*</label>
                        <input type="password" class="form-control" name="uipwd" id="uipwd" required placeholder="비밀번호를 입력해주세요">
                    </div>
                    <div class="form-group text-center">
                        <button type="summit" id="join-submit" class="btn btn-primary">
                            로그인<i class="fa fa-check spaceLeft"></i>
                        </button>
                        <button data-page="/views/user/userJoin" class="btn btn-warning">
                            취소<i class="fa fa-times spaceLeft"></i>
                        </button>
                        
                    </div>
                </form>
            </div>

        </article>

<div><a href="/user/userJoin">회원가입</a></div>
