<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/css/header.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container">
    <div class="main_text">

    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="/lib/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
       var userId = prompt("주문내역을 확인할 사용자ID를 입력해주세요.");

        location.href = "/admin/order/" + userId;
    });
</script>
</body>
</html>
