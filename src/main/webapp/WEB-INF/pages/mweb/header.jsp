<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<nav class="navbar navbar-default navbar-static-top">
    <div class="container">
        <div class="headerbar navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/mweb/home">야채사요</a>
            <a href="#" class="btn_basket">
                <span>장바구니</span>
            </a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/mweb/home">Home</a></li>
                <li><a href="/mweb/login">로그인</a></li>
                <li><a href="#">내정보</a></li>
                <li><a href="#">주문정보</a></li>
                <li><a href="#">야채사요에 대하여</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<script type="text/javascript">
    $('.nav li').click(function(e) {
        $('.active').removeClass('active');
        $(this).addClass('active');
    });
</script>