<jsp:include page="common/header.jsp"/>

    <div class="container-fluid common">
        <div class="row">
            <p align=center>야채사요 로그인</p>
        </div>
        <div class="form-group">
            <input type="text" class="form-control" id="usr" placeholder="Email">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" id="pwd" placeholder="Password">
        </div>
        <div class="row">
            <div class="btn btn-lg btn-common">로그인</div>
        </div>
        <div class="row login-options">
            <label for="save-id">
                <input type="checkbox" id="save-id">아이디 저장</label>
            <label for="auto-login">
                <input type="checkbox" id="auto-login">자동 로그인</label>
        </div>
        <div class="row social-logins">
            <div class="row mg-15">
                <a class="btn btn-lg btn-social btn-naver">
                    <img src="/images/social/naver_login.png" width="20" height="20"><span class="btn-divider"></span> 네이버로 로그인
                </a>
            </div>
            <div class="row mg-15">
                <a class="btn btn-lg btn-social btn-kakao">
                    <img src="/images/social/kakao_login.png" width="20" height="20"><span class="btn-divider"></span> 카카오로 로그인
                </a>
            </div>
        </div>
        <div class="row login-options center-text">
            <label>회원가입 <span style="padding:0 5px">|</span> 비밀번호 찾기</label>
        </div>
    </div>

<jsp:include page="common/footer.jsp"/>