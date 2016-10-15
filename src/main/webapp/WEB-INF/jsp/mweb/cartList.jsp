<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="common/header.jsp"/>

    <div class="container-fluid common main-contents-area">
        <div class="row">
            <p align=center>장바구니</p>
        </div>
        <div class="row cart-list-items">
            <c:forEach var="cartItem" items="${sessionScope.cart.cartItemList}">
            <div class="card-container" id="cartItem-id-${cartItem.item.id}">
                <div class="item">
                    <div class="img-area">
                        <img src="${cartItem.item.imageUrl}" width="100%" />
                    </div>
                    <div class="info-area">
                        <div>${cartItem.item.name}</div>
                        <div><fmt:formatNumber>${cartItem.item.price}</fmt:formatNumber>원</div>
                        <div class="sub-title">
                        </div>
                    </div>
                    <%-- 카트에서 수량 조절 시 --%>
                    <%--<div class="count-area">--%>
                        <%--<select class="count-select">--%>
                            <%--<option>1</option>--%>
                            <%--<option>2</option>--%>
                            <%--<option>3</option>--%>
                            <%--<option>4</option>--%>
                        <%--</select>--%>
                    <%--</div>--%>
                    <div class="clear"></div>
                </div>
                <div class="amount">
                    <div class="left">
                        <input type="checkbox" name="item-check" />
                        <span>주문금액</span>
                        <span>(${cartItem.amount}개)</span>
                    </div>
                    <div class="right">
                        <span><fmt:formatNumber>${cartItem.amount * cartItem.item.price}</fmt:formatNumber></span>
                        <span>원</span>
                    </div>
                    <div class="clear">
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
    <div class="cart-list-total">
        <div class="row cart-list-sum">
            <div>총 주문금액</div>
            <div><fmt:formatNumber>${sessionScope.cart.totalPrice}</fmt:formatNumber>원</div>
        </div>
        <div class="row cart-list-btns">
            <div class="col-xs-6">
                <div class="btn btn-lg btn-common white" id="selected-delete">선택상품 삭제</div>
            </div>
            <div class="col-xs-6">
                <div class="btn btn-lg btn-common" id="order">주문하기</div>
            </div>
        </div>
    </div>

<script type="text/javascript">
    // unescape 처리
    <c:forEach var="cartItem" items="${sessionScope.cart.cartItemList}">
    $('#cartItem-id-${cartItem.item.id}').find('.sub-title')[0].innerHTML = unescape('${cartItem.item.itemDesc}');
    </c:forEach>
</script>

<jsp:include page="common/footer.jsp"/>