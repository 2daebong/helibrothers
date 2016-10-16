<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="common/header.jsp"/>
<div class="container-fluid common">
    <div class="row">
        <p align=center>야채사요 로그인</p>
    </div>

    <div class="row social-logins">
        <div class="row mg-15" id="naver-login">
            <a class="btn btn-lg btn-social btn-naver">
                <img src="/images/social/naver_login.png" width="20" height="20">
                <span class="btn-divider"></span> 네이버로 로그인
            </a>
        </div>
    </div>
    <div class="row login-options center-text">
        <label>회원가입 <span style="padding:0 5px">|</span> 비밀번호 찾기</label>
    </div>
</div>
<script>
    var loginBtn = document.querySelector("#naver-login");
    loginBtn.onclick = function() {
        window.location.href = "/naverOauthRedirect";
    }
</script>
<jsp:include page="common/footer.jsp"/>