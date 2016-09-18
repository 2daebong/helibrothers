<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="common/header.jsp"/>
<div id="naver_id_login">
    <script type="text/javascript" src="/lib/social-auth/naverLogin_implicit-1.0.2-min.js" charset="utf-8"></script>
    <script type="text/javascript">
        var naver_id_login = new naver_id_login("CH1s15EkwPutdRu7tvjl", "http://localhost:8080/naverOauth");
        var state = naver_id_login.getUniqState();
        naver_id_login.setState(state);
        naver_id_login.setPopup();
        naver_id_login.init_naver_id_login();

        // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
        function naverSignInCallback() {
            // naver_id_login.getProfileData('프로필항목명');
            // 프로필 항목은 개발가이드를 참고하시기 바랍니다.
            alert(naver_id_login.getProfileData('email'));
            alert(naver_id_login.getProfileData('nickname'));
        }

        // 네이버 사용자 프로필 조회
        naver_id_login.get_naver_userprofile("naverSignInCallback()");
    </script>
<jsp:include page="common/footer.jsp"/>