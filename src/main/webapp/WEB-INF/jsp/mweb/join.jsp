<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="row mg-15" id="naver_id_login">
        </div>
    </div>
    <div class="row login-options center-text">
        <label>회원가입 <span style="padding:0 5px">|</span> 비밀번호 찾기</label>
    </div>
</div>
<script type="text/javascript" src="/lib/social-auth/naverLogin_implicit-1.0.2-min.js" charset="utf-8"></script>
<script type="text/javascript">
    var naver_id_login = new naver_id_login("CH1s15EkwPutdRu7tvjl", "http://localhost:8080/naverOauth");
    var state = naver_id_login.getUniqState();
    naver_id_login.setState(state);
    naver_id_login.init_naver_id_login();
</script>

<jsp:include page="common/footer.jsp"/>