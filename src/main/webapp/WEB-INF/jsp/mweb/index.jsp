<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/css/mweb/header.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js" charset="utf-8"></script>
</head>
<body>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no" />
    <jsp:include page="header.jsp"/>

    <div class="container">

    </div>

<script src="/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        var naver_id_login = new naver_id_login("A4ss6_xU5SH1KaSgBFpP", "http://dicoadmin.com/mweb/home");
        naver_id_login.setDomain("dicoadmin.com"); //상태 토큰 비교를 위한 domain 설정

        function naverSignInCallback() {
            // naver_id_login.getProfileData('프로필항목명');
            // 프로필 항목은 개발가이드를 참고하시기 바랍니다.
            alert(naver_id_login.getProfileData('email'));
            alert(naver_id_login.getProfileData('nickname'));
            alert(naver_id_login.getProfileData('age'));
        }

        // 네이버 사용자 프로필 조회
        naver_id_login.get_naver_userprofile("naverSignInCallback()");
    </script>
</body>
</html>
