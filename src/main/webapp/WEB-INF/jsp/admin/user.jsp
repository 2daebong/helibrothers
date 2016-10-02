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
        <table class="table table-hover" style="margin-top: 30px">
            <tr>
                <td>네이버ID</td>
                <td>별명</td>
                <td>주소</td>
                <td>전화번호</td>
                <td>가입일자</td>
                <td>수정일자</td>
                <td> </td>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr class="clickable-row">
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.userInfo.address}</td>
                    <td>${user.userInfo.phoneNumber}</td>
                    <td>${user.registYmdt}</td>
                    <td>${user.updateYmdt}</td>
                    <td> </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="/lib/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
