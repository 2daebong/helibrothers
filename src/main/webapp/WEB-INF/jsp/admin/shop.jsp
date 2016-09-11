<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/css/header.css" rel="stylesheet">
    <link href="/css/shop.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container">
    <div class="main_text">
        <button class="btn btn-success btn_register_shop" data-toggle="modal" data-target="#regist_modal">신규 Shop 등록</button>
        <c:forEach var="shop" items="${shopList}">
            <div class="list-group">
                <a href="#" class="list-group-item">
                    <h4 class="list-group-item-heading">${shop.shopName}</h4>
                    <button data-toggle="modal" data-target="#detail_modal" class="btn btn-info" data-shopno="${shop.shopNo}">상세보기</button>
                    <button data-toggle="modal" data-target="#orderList_modal" class="btn btn-primary" data-shopno="${shop.shopNo}">주문현황</button>
                </a>
            </div>
        </c:forEach>

        <!-- 샵 등록 Modal -->
        <div id="regist_modal" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">신규 SHOP 등록</h4>
                    </div>
                    <div class="modal-body">
                        <form id="register_shop_form">
                            <div class="form-group">
                                <label for="shopName">ShopName</label>
                                <input type="string" class="form-control" id="shopName" placeholder="SHOP 이름">
                            </div>
                            <div class="form-group">
                                <label for="adminUser">Admin User</label>
                                <input type="string" class="form-control" id="adminUser" placeholder="관리자 ID">
                            </div>
                            <div class="form-group">
                                <label for="address">Address</label>
                                <input type="string" class="form-control" id="address" placeholder="주소">
                            </div>
                            <div class="form-group">
                                <label for="phoneNumber">Phone Number</label>
                                <input type="string" class="form-control" id="phoneNumber" placeholder="전화번호">
                            </div>
                            <div class="checkbox">
                                <label>
                                    등록할 SHOP 정보를 정확하게 기입해 주세요.
                                </label>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" form="register_shop_form" class="btn btn-default">Submit</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- 상세정보 Modal -->
        <div id="detail_modal" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">SHOP 상세 정보</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="shopNo">SHOP 번호</label>
                            <input readonly type="text" class="form-control modal-shopNo" id="shopNo" >
                        </div>
                        <div class="form-group">
                            <label for="shopNameDetail">SHOP 이름</label>
                            <input type="text" class="form-control modal-shopName" id="shopNameDetail">
                        </div>
                        <div class="form-group">
                            <label for="adminUserDetail">관리자 ID</label>
                            <input type="text" class="form-control modal-adminUser" id="adminUserDetail">
                        </div>
                        <div class="form-group">
                            <label for="addressDetail">주소</label>
                            <input type="text" class="form-control modal-address" id="addressDetail">
                        </div>
                        <div class="form-group">
                            <label for="phoneNumberDetail">전화번호</label>
                            <input type="text" class="form-control modal-phoneNumber" id="phoneNumberDetail">
                        </div>
                        <div class="form-group">
                            <label for="registYmdtDetail">등록일자</label>
                            <input readonly type="text" class="form-control modal-registYmdt" id="registYmdtDetail">
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="submit" form="register_shop_form" class="btn btn-default">수정</button>
                    </div>
                </div>
        </div>
    </div>
</div>

<script src="/lib/jquery/jquery-1.12.2.min.js"></script>
<script src="/lib/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">


    $('#register_shop_form').submit(function() {

        var data = {
            shopName : $('#shopName').val(),
            address : $('#address').val(),
            adminUser : $('#adminUser').val(),
            phoneNumber : $('#phoneNumber').val()
        }

        $.ajax({
            type: "POST",
            url: "/api/shop",
            data: JSON.stringify(data),
            success: function(data){
                alert("등록 되었습니다.");
                //추가된 항목을 리스트에 추가하기 위해 reload
                location.reload(true);

            },
            error : function(request,status,error){
                alert("fail. code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
            },
            dataType: "json",
            contentType : "application/json; charset=utf-8"
        });
    });

    $('#detail_modal').on('show.bs.modal', function (event) { // myModal 윈도우가 오픈할때 아래의 옵션을 적용
        var button = $(event.relatedTarget); // 모달 윈도우를 오픈하는 버튼
        var selectedShopNo = button.data('shopno'); // 버튼에서 data-title 값을 titleTxt 변수에 저장

        $.ajax({
            type: "GET",
            url: "/shop/" + selectedShopNo,
            contentType : "application/json; charset=utf-8",
            success : function(data){
                var shop = data;
                $('.modal-shopNo').val(shop.shopNo);
                $('.modal-shopName').val(shop.shopName);
                $('.modal-address').val(shop.address);
                $('.modal-adminUser').val(shop.adminUser);
                $('.modal-phoneNumber').val(shop.phoneNumber);
                $('.modal-registYmdt').val(shop.registYmdtStr);
            }
        })
    })
</script>
</body>
</html>
