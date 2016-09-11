<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="common/header.jsp"/>

    <div class="container-fluid common main-contents-area">
        <div class="row">
            <p align=center>장바구니</p>
        </div>
        <div class="row cart-list-items">
            <div class="card-container" idx="1">
                <div class="item">
                    <div class="img-area">
                        <img src="/images/banana.png" width="100%" />
                    </div>
                    <div class="info-area">
                        <div>바나나</div>
                        <div>1,000원</div>
                        <div class="sub-title">
                            신선한 몽키몽키 바나나를 먹어요 :D
                        </div>
                    </div>
                    <div class="count-area">
                        <select class="count-select">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                        </select>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="amount">
                    <div class="left">
                        <input type="checkbox" name="item-check" />
                        <span>주문금액</span>
                        <span>(1개)</span>
                    </div>
                    <div class="right">
                        <span>1,000</span>
                        <span>원</span>
                    </div>
                    <div class="clear">
                    </div>
                </div>
            </div>
            <div class="card-container" idx="2">
                <div class="item">
                    <div class="img-area">
                        <img src="/images/banana.png" width="100%" />
                    </div>
                    <div class="info-area">
                        <div>바나나</div>
                        <div>1,000원</div>
                        <div class="sub-title">
                            신선한 몽키몽키 바나나를 먹어요 :D
                        </div>
                    </div>
                    <div class="count-area">
                        <select class="count-select">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                        </select>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="amount">
                    <div class="left">
                        <input type="checkbox" name="item-check" />
                        <span>주문금액</span>
                        <span>(1개)</span>
                    </div>
                    <div class="right">
                        <span>1,000</span>
                        <span>원</span>
                    </div>
                    <div class="clear">
                    </div>
                </div>
            </div>
            <div class="card-container" idx="3">
                <div class="item">
                    <div class="img-area">
                        <img src="/images/banana.png" width="100%" />
                    </div>
                    <div class="info-area">
                        <div>바나나</div>
                        <div>1,000원</div>
                        <div class="sub-title">
                            신선한 몽키몽키 바나나를 먹어요 :D
                        </div>
                    </div>
                    <div class="count-area">
                        <select class="count-select">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                        </select>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="amount">
                    <div class="left">
                        <input type="checkbox" name="item-check" />
                        <span>주문금액</span>
                        <span>(1개)</span>
                    </div>
                    <div class="right">
                        <span>1,000</span>
                        <span>원</span>
                    </div>
                    <div class="clear">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="cart-list-total">
        <div class="row cart-list-sum">
            <div>총 주문금액(3개)</div>
            <div>3,000원</div>
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

<jsp:include page="common/footer.jsp"/>