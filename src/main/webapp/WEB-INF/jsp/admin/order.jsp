<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/css/header.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp" flush="false"/>

<div class="container">
    <div class="main_text">

        <ul class="nav nav-pills">
            <li class="active"><a href="#item1">처리리스트</a></li>
            <li><a href="#item2">완료리스트</a></li>
            <li><a href="#item3">취소리스트</a></li>
        </ul>

        <div class="tab-content">
            <div id="item1" class="tab-pane fade in active">
                <h2>처리 목록</h2>
                <br>
                <h4>배송 전</h4>
                <table id="del-before" class="table table-hover" style="margin-top: 30px">
                    <tr>
                        <td>주문번호</td>
                        <td>사용자ID</td>
                        <td>주문시간</td>
                        <td>주소</td>
                        <td>전화번호</td>
                        <td>금액</td>
                        <td>배송수단</td>
                        <td>주문상태</td>
                    </tr>
                    <c:forEach items="${orders}" var="order">
                        <c:if test="${order.status eq 'WAIT'}">
                            <tr class="clickable-row" style="background-color: gold" onclick="detailView(${order.id})">
                                <td>${order.id}</td>
                                <td>${order.user.id}</td>
                                <td>${order.orderDate}</td>
                                <td>${order.user.userInfo.address}</td>
                                <td>${order.user.userInfo.phoneNumber}</td>
                                <td><fmt:formatNumber>${order.totalPrice}</fmt:formatNumber></td>
                                <td>${order.deliveryStatusKr}</td>
                                <td>
                                    <select class="orderStatus form-control" data-id="${order.id}">
                                        <option value="${order.status}">${order.orderStatusKr}</option>
                                        <c:forEach items="${orderStatusEnums}" var="orderStatus">
                                            <c:if test="${orderStatus ne order.status}">
                                                <option value="${orderStatus}">${orderStatus.nameKr}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </table>
                <br>
                <h4>배송 중</h4>
                <table id="del-ing" class="table table-hover" style="margin-top: 30px">
                    <tr>
                        <td>주문번호</td>
                        <td>사용자ID</td>
                        <td>주문시간</td>
                        <td>주소</td>
                        <td>전화번호</td>
                        <td>금액</td>
                        <td>배송수단</td>
                        <td>주문상태</td>
                    </tr>
                    <c:forEach items="${orders}" var="order">
                        <c:if test="${order.status eq 'ING'}">
                            <tr class="clickable-row" style="background-color: palevioletred"
                                onclick="detailView(${order.id})">
                                <td>${order.id}</td>
                                <td>${order.user.id}</td>
                                <td>${order.orderDate}</td>
                                <td>${order.user.userInfo.address}</td>
                                <td>${order.user.userInfo.phoneNumber}</td>
                                <td><fmt:formatNumber>${order.totalPrice}</fmt:formatNumber></td>
                                <td>${order.deliveryStatusKr}</td>
                                <td>
                                    <select class="orderStatus form-control" data-id="${order.id}">
                                        <option value="${order.status}">${order.orderStatusKr}</option>
                                        <c:forEach items="${orderStatusEnums}" var="orderStatus">
                                            <c:if test="${orderStatus ne order.status}">
                                                <option value="${orderStatus}">${orderStatus.nameKr}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </table>
            </div>
            <div id="item2" class="tab-pane fade">
                <br>
                <h2>배송완료</h2>
                <table id="del-complete" class="table table-hover" style="margin-top: 30px">
                    <tr>
                        <td>주문번호</td>
                        <td>사용자ID</td>
                        <td>주문시간</td>
                        <td>주소</td>
                        <td>전화번호</td>
                        <td>금액</td>
                        <td>배송수단</td>
                        <td>주문상태</td>
                    </tr>
                    <c:forEach items="${orders}" var="order">
                        <c:if test="${order.status eq 'COMPLETE'}">
                            <tr class="clickable-row" style="background-color: darkgray"
                                onclick="detailView(${order.id})">
                                <td>${order.id}</td>
                                <td>${order.user.id}</td>
                                <td>${order.orderDate}</td>
                                <td>${order.user.userInfo.address}</td>
                                <td>${order.user.userInfo.phoneNumber}</td>
                                <td><fmt:formatNumber>${order.totalPrice}</fmt:formatNumber></td>
                                <td>${order.deliveryStatusKr}</td>
                                <td>
                                    <select class="orderStatus form-control" data-id="${order.id}">
                                        <option value="${order.status}">${order.orderStatusKr}</option>
                                        <c:forEach items="${orderStatusEnums}" var="orderStatus">
                                            <c:if test="${orderStatus ne order.status}">
                                                <option value="${orderStatus}">${orderStatus.nameKr}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </table>
            </div>
            <div id="item3" class="tab-pane fade">
                <br>
                <h2>취소 목록</h2>
                <table id="del-cancel" class="table table-hover" style="margin-top: 30px">
                    <tr>
                        <td>주문번호</td>
                        <td>사용자ID</td>
                        <td>주문시간</td>
                        <td>주소</td>
                        <td>전화번호</td>
                        <td>금액</td>
                        <td>배송수단</td>
                        <td>주문상태</td>
                    </tr>
                    <c:forEach items="${orders}" var="order">
                        <c:if test="${order.status eq 'CANCEL'}">
                            <tr class="clickable-row" onclick="detailView(${order.id})">
                                <td>${order.id}</td>
                                <td>${order.user.id}</td>
                                <td>${order.orderDate}</td>
                                <td>${order.user.userInfo.address}</td>
                                <td>${order.user.userInfo.phoneNumber}</td>
                                <td><fmt:formatNumber>${order.totalPrice}</fmt:formatNumber></td>
                                <td>${order.deliveryStatusKr}</td>
                                <td>
                                    <select class="orderStatus form-control" data-id="${order.id}">
                                        <option value="${order.status}">${order.orderStatusKr}</option>
                                        <c:forEach items="${orderStatusEnums}" var="orderStatus">
                                            <c:if test="${orderStatus ne order.status}">
                                                <option value="${orderStatus}">${orderStatus.nameKr}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>

    <%--<!-- Trigger the modal with a button -->--%>
    <%--<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>--%>

    <!-- Modal -->
    <div id="detailModal" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">주문 상세 정보</h4>
                </div>
                <div class="modal-body">
                    <p id="detail_orderInfo"></p>
                    <table class="table table-hover" style="margin-top: 20px">
                        <tr>
                            <td>사진</td>
                            <td>상품명</td>
                            <td>갯수</td>
                            <td>가격</td>
                        </tr>
                        <tbody id="detailModal_row">

                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    총 금액 : <p id="totalPrice"></p>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="/lib/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">
    $('.orderStatus').click(function (e) {
        e.stopPropagation();
    });

    $('.orderStatus').change(function () {
        console.log($(this).data('id'), this.value);

        var id = $(this).data('id');
        var orderStatus = this.value;

        $.ajax({
            url: "/api/order/" + id,
            type: 'PUT',
            data: orderStatus,
            contentType: "application/json; charset=utf-8",
            success: function (order) {
                location.reload();
            }
        });
    });

    function detailView(id) {
        $('#detailModal_row').html('');

        $.ajax({
            url: "/api/order/" + id,
            type: 'GET',
            contentType: "application/json; charset=utf-8",
            success: function (order) {
                var orderItems = order.orderItems;
                var html = "";
                var allItemTotalPrice = 0;
                for (var i = 0; i < orderItems.length; i++) {
                    var orderItem = orderItems[i];
                    html += "\<tr\>" +
                            "\<td\>\<img src\=\"" + orderItem.item.imageUrl + "\" width\=\"80px\" height\=\"80px\"\>\<\/td\>" +
                            "\<td\>" + orderItem.item.name + "\<\/td\>" +
                            "\<td\>" + orderItem.count + "\<\/td\>" +
                            "\<td\>" + orderItem.totalPrice + "\<\/td\>" +
                            "\<\/tr\>";
                    allItemTotalPrice += orderItem.totalPrice;
                }
                $('#detail_orderInfo').html('사용자ID : ' + order.user.id + " <br> 주문번호 : " + order.id);
                $('#detailModal_row').html(html);
                $('#totalPrice').html(allItemTotalPrice);
                $('#detailModal').modal();
            },
            error: function (request, status, error) {
                console.log("fail. code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
                alert("fail. code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
            }
        });
    }

    // Main Tab Event
    var navPills = $(".nav-pills a");
    if (navPills) {
        navPills.click(function () {
            $(this).tab('show');
        });
    }
</script>
</body>
</html>
