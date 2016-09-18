<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no" />
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/admin/index">DICO ADMIN</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/admin/index">Home</a></li>
                <%--<li><a href="/admin/shop">매장</a></li>--%>
                <li><a href="/admin/product">상품</a></li>
                <li><a href="/admin/user">사용자</a></li>
                <li><a href="/admin/order">주문</a></li>
                <li><a href="/admin/test">실험실</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript">
    $('.nav li').click(function(e) {
        $('.active').removeClass('active');
        $(this).addClass('active');
    });
</script>