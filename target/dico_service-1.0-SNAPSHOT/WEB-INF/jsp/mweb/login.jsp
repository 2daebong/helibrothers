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
<jsp:include page="header.jsp" />
<div class="container">
    <!-- 네이버아이디로로그인 버튼 노출 영역 -->
    <div id="naver_id_login"></div>
    <!-- //네이버아이디로로그인 버튼 노출 영역 -->

</div>

<!-- 네이버아디디로로그인 초기화 Script -->
<script type="text/javascript">
    var naver_id_login = new naver_id_login("A4ss6_xU5SH1KaSgBFpP", "http://dicoadmin.com/mweb/home");
    var state = naver_id_login.getUniqState();
    naver_id_login.setButton("white", 3,40);
    naver_id_login.setDomain(".dicoadmin.com");
    naver_id_login.setState(state);
    naver_id_login.setPopup();
    naver_id_login.init_naver_id_login();
</script>
<!-- // 네이버아이디로로그인 초기화 Script -->
<script src="/js/bootstrap.min.js"></script>
</body>
</html>
