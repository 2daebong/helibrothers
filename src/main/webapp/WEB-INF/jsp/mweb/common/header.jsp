<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/x-icon" href="/images/favicon.ico" />
    <title>Clean Blog</title>
    <!-- Bootstrap Core CSS -->
    <link href="/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Theme CSS -->
    <link href="/css/common.css" rel="stylesheet">
    <!-- 나눔바른고딕 -->
    <link href='/lib/NanumBarunGothic/nanumbarungothic.css' rel='stylesheet' type='text/css'>
    <!-- Custom Fonts -->
    <link href="/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="/lib/jquery/jquery.min.js"></script>
</head>
<body>
    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-custom navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="/">야채사요</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="/">HOME</a>
                    </li>
                    <li>
                        <a href="#about">야채사요 소개</a>
                    </li>
                    <li>
                        <a href="cartList">장바구니</a>
                    </li>
                    <li>
                        <% if (session.getAttribute("IS_LOGIN") == null) { %>
                        <a href="login">로그인</a>
                        <% } else { %>
                        <a href="logout">로그아웃</a>
                        <% } %>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>