<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
        <button class="btn btn-success btn_register_shop" onclick="registNewProduct();" data-toggle="modal" data-target="#regist_modal">신규 Product
            등록
        </button>

        <table class="table table-hover" style="margin-top: 30px">
            <tr>
                <td>No</td>
                <td>사진</td>
                <td>카테고리</td>
                <td>상품명</td>
                <td>등록일시</td>
                <td>가격</td>
                <td>재고</td>
                <td> </td>
            </tr>
            <c:forEach var="item" items="${items}">
                <tr class="clickable-row" onclick="detailView(${item.id})">
                    <td>${item.id}</td>
                    <td><img src="${item.imageUrl}" width="140px" height="140px"></td>
                    <td>${item.category.nameKr}</td>
                    <td>${item.name}</td>
                    <td>${item.registYmdt}</td>
                    <td><input style="width:70px" value="${item.price}" class="form-control">원</td>
                    <td><input style="width:60px" value="${item.stockQuantity}" class="form-control">${item.stockUnitCd.nameKr}</td>
                    <td><button class="form-control btn_del" data-id="${item.id}">삭제</button></td>
                </tr>
            </c:forEach>
        </table>

    </div>

    <!-- Product 등록 Modal -->
    <div id="regist_modal" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">상품</h4>
                </div>
                <div class="modal-body">
                    <form id="register_product_form">
                        <div class="form-group">
                            <form>
                                <input hidden="true" id="itemId">
                                <div class="form-group">
                                    <img src="" width="215px", height="215px" id="preview_image">
                                    <label for="imageFileInput">상품 사진 <br>215x215 사이즈에 최적화 되어 있습니다.</label>
                                    <input type="file" id="imageFileInput">
                                    <p id="status" class="help-block">상품 이미지 파일을 업로드 해주세요.</p>
                                </div>
                                <div class="form-group">
                                    <label for="category">카테고리</label>
                                    <select id="category" class="form-control">
                                        <option value="-1">카테고리</option>
                                        <c:forEach items="${categories}" var="category">
                                            <option value="${category}">${category.nameKr}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label class="control-label" for="name">상품명</label>
                                    <input type="text" class="form-control" id="name" placeholder="상품명">
                                </div>
                                <div>
                                    <label for="stockQuantity">재고</label>
                                    <input type="text" id="stockQuantity">
                                </div>
                                <div>
                                    <label for="price">가격</label>
                                    <input type="text" id="price">
                                </div>
                                <div class="form-group">
                                    <label for="stockUnitCd">단위</label>
                                    <select id="stockUnitCd" class="form-control">
                                        <option value="-1">단위</option>
                                        <c:forEach items="${stockUnitCds}" var="unitCd">
                                            <option value="${unitCd}">${unitCd.nameKr}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div>
                                    <label for="itemDesc">상품 설명</label>
                                    <textarea id="itemDesc" class="form-control" rows="3"></textarea>
                                </div>
                            </form>
                        </div>

                    </form>
                </div>
                <div class="modal-footer">
                    <button type="submit" form="register_product_form" class="btn btn-default" id="submitBtn">추가</button>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="/lib/jquery/jquery-1.12.2.min.js"></script>
<script src="/lib/bootstrap/js/bootstrap.min.js"></script>
<script src="/lib/social-auth/loginFB.js"></script>
<script src="https://sdk.amazonaws.com/js/aws-sdk-2.3.11.min.js"></script>

<script type="text/javascript">
    if(isNotLogin()) {
        alert('로그인이 필요합니다.');

        location.href='/';
    }

    sImageUrl = '';
    bIsUpdate = false;
    var appId = '<spring:eval expression="@properties['facebook.appId']"/>';
    var roleArn = 'arn:aws:iam::764006455036:role/adminLoginROle';
    var token = getFacebookTocken();
    var fbUserId;

    AWS.config.region = 'ap-northeast-2';
    AWS.config.credentials = new AWS.WebIdentityCredentials({
        ProviderId: 'graph.facebook.com',
        RoleArn: roleArn,
        WebIdentityToken: token
    });
    var bucket = new AWS.S3({
        params: {
            Bucket: 'dicos3'
        }
    });

    $('.dropdown-toggle').dropdown();

    $(function () {
        $('#imageFileInput').on('change', function() {
            readURL(this);
            var file = this.files[0];
            var result = document.getElementById('status');
            if (file) {
                result.innerHTML = "";
                var date = new Date();
                //TODO : 추후에 추가될 상품 ID로 변경 검토
                var fileSufix = date.getYear() + "_" +
                        date.getMonth() + "_" +
                        date.getDay() + "_" +
                        date.getHours() + "_" +
                        date.getSeconds() + "_" +
                        date.getMilliseconds();
                var objKey = 'item-img-' + fileSufix; // 중복 피하기 위해
                var params = {
                    Key: objKey, ContentType: file.type, Body: file, ACL: "public-read"
                };
                bucket.putObject(params, function (err, data) {
                    if (err) {
                        result.innerHTML = 'ERROR: ' + err;
                        alert('이미지 업로드 에러 \n ' + err);
//                        location.href = "/";
                    } else {
                        // upload success
                        sImageUrl = bucket.endpoint.href + 'dicos3' + '/' + objKey;
                        result.innerHTML = '이미지 업로드 성공, ' + sImageUrl;
                    }
                });
            } else {
                results.innerHTML = 'Nothing to upload..';
            }
        });
    });

    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#preview_image').attr('src', e.target.result);
            }

            reader.readAsDataURL(input.files[0]);
        }
    }

    $('#register_product_form').submit(function (e) {
        e.preventDefault();
        var itemDesc = escape($('#itemDesc').val());

        var data = {
            id: $('#itemId').val(),
            name: $('#name').val(),
            category: $('#category').val(),
            imageUrl: sImageUrl,
            stockQuantity: $('#stockQuantity').val(),
            price: $('#price').val(),
            itemDesc: itemDesc,
            stockUnitCd: $('#stockUnitCd').val()
        }

        var method = 'POST';

        if(bIsUpdate) {
            method = 'PUT'; // 업데이트 인 경우
        }

        $.ajax({
            url: "/api/item",
            type: method,
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json; charset=UTF-8",
            success: function (data) {
                alert("등록 되었습니다.");
                //추가된 항목을 리스트에 추가하기 위해 reload
                location.reload(true);
            },
            error: function (request, status, error) {
                alert("fail. code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
            }
        });
    });


    function detailView(itemId) {
        bIsUpdate = true;
        $('#submitBtn').text('수정');

        <c:forEach var="item" items="${items}">
        var itemDesc = unescape('${item.itemDesc}');
        if(${item.id} == itemId) {
            $('#itemId').val('${item.id}');
            $('#name').val('${item.name}');
            $("#category").val('${item.category}').attr("selected", "selected");
            $('#preview_image').attr("src", '${item.imageUrl}');
            sImageUrl = '${item.imageUrl}';
            $('#stockQuantity').val('${item.stockQuantity}');
            $('#price').val('${item.price}');
            $('#itemDesc').val(itemDesc);
            $('#stockUnitCd').val('${item.stockUnitCd}');
        }
        </c:forEach>

        $('#regist_modal').modal();
    }

    function registNewProduct() {
        bIsUpdate = false;
        $('#submitBtn').text('추가');
        $('#name').val('');
        $("#category").val('-1').attr("selected", "selected");
        $('#preview_image').attr("src", '');
        sImageUrl = '';
        $('#stockQuantity').val('');
        $('#price').val('');
        $('#itemDesc').val('');
        $('#stockUnitCd').val('');
        $('#itemId').val('');
    }


    $(function() {
        $('.btn_del').on('click', function(e){
            e.stopPropagation();

            var id = $(this).data('id');

            $.ajax({
                url: "/api/item/" + id,
                type: 'DELETE',
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    alert("삭제 되었습니다.");
                    //추가된 항목을 리스트에 추가하기 위해 reload
                    location.reload(true);
                },
                error: function (request, status, error) {
                    alert("fail. code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
                }
            });
        });
    })

</script>
</body>
</html>
