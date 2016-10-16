<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="common/header.jsp"/>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="/images/home-bg.jpg" alt="Chania">
            <div class="header-text">
                <div class="col-md-12 text-center">
                    <h3>
                        <span>Welcome to <strong>야채사요</strong></span>
                    </h3>
                    <h4>
                        <span>Lorem ipsum dolor sit amet <spring:eval expression="@properties['phase']"/> </span>
                    </h4>
                </div>
            </div>
        </div>
        <div class="item">
            <img src="/images/home-bg.jpg" alt="Chania">
            <div class="header-text">
                <div class="col-md-12 text-center">
                    <h3>
                        <span>Welcome to <strong>야채사요</strong></span>
                    </h3>
                    <h4>
                        <span>Lorem ipsum dolor sit amet</span>
                    </h4>
                </div>
            </div>
        </div>
        <div class="item">
            <img src="/images/home-bg.jpg" alt="Chania">
            <div class="header-text">
                <div class="col-md-12 text-center">
                    <h3>
                        <span>Welcome to <strong>야채사요</strong></span>
                    </h3>
                    <h4>
                        <span>Lorem ipsum dolor sit amet</span>
                    </h4>
                </div>
            </div>
        </div>
    </div>
    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<!--
<div class="row main-banner-area">
<div class="col-xs-12 main-banner-text">
<div class="col-xs-3 text-center"><a><strong>이벤트</strong></a></div>
<div class="col-xs-3 text-center"><a><strong>신상품</strong></a></div>
<div class="col-xs-3 text-center"><a><strong>이벤트</strong></a></div>
<div class="col-xs-3 text-center"><a><strong>신상품</strong></a></div>
</div>
</div>
<hr/>
-->
<!-- Main Content -->
<div class="container-fluid main-contents-area">
    <!-- section 1 Event -->
    <%--<div class="row section">--%>
        <%--<div class="row title">--%>
            <%--<p><strong>이벤트</strong></p>--%>
        <%--</div>--%>
        <%--<div class="row contents">--%>
            <%--<div class="col-sm-6">--%>
                <%--<div class="col-xs-6 text-center">--%>
                    <%--<div class="card-container">--%>
                        <%--<img src="/images/banana.png" width="100%" />--%>
                        <%--<div class="info">--%>
                            <%--<p><strong>바나나</strong></p>--%>
                            <%--<p>1,000원</p>--%>
                            <%--<button class="btn add-to-cart" data-toggle="modal" idx="1">담기</button>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="col-xs-6 text-center">--%>
                    <%--<div class="card-container">--%>
                        <%--<img src="/images/banana.png" width="100%" />--%>
                        <%--<div class="info">--%>
                            <%--<p><strong>바나나</strong></p>--%>
                            <%--<p>1,000원</p>--%>
                            <%--<button class="btn add-to-cart" data-toggle="modal" idx="2">담기</button>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="clear"></div>--%>
            <%--</div>--%>
            <%--<div class="col-sm-6">--%>
                <%--<div class="col-xs-6 text-center">--%>
                    <%--<div class="card-container">--%>
                        <%--<img src="/images/banana.png" width="100%" />--%>
                        <%--<div class="info">--%>
                            <%--<p><strong>바나나</strong></p>--%>
                            <%--<p>1,000원</p>--%>
                            <%--<button class="btn add-to-cart" data-toggle="modal" idx="3">담기</button>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="col-xs-6 text-center">--%>
                    <%--<div class="card-container">--%>
                        <%--<img src="/images/banana.png" width="100%" />--%>
                        <%--<div class="info">--%>
                            <%--<p><strong>바나나</strong></p>--%>
                            <%--<p>1,000원</p>--%>
                            <%--<button class="btn add-to-cart" data-toggle="modal" idx="4">담기</button>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="clear"></div>--%>
            <%--</div>--%>
            <%--<div class="clear"></div>--%>
        <%--</div>--%>
    <%--</div>--%>
    <!-- end of section 1 -->
    <!-- section 2 -->
    <div class="row section">
        <div class="row title">
            <p><strong>전체상품</strong></p>
        </div>
        <!-- Tab title area -->
        <ul class="nav nav-pills">
            <li class="active"><a href="#item1">신선식품</a></li>
            <li><a href="#item2">축산/달걀</a></li>
            <li><a href="#item3">가공식품</a></li>
            <li><a href="#item4">양념/반찬</a></li>
            <li><a href="#item5">기타</a></li>
        </ul>
        <!-- End of Tab area -->
        <!-- Tab contents area -->
        <div class="tab-content">
            <div id="item1" class="tab-pane fade in active">
                <div class="row contents">
                    <div class="col-sm-6">
                        <c:forEach var="item" items="${items}">
                            <c:if test="${item.category eq 'FRESH'}">
                            <div class="col-xs-6 text-center">
                                <div class="card-container">
                                    <img src=${item.imageUrl} width="100%" />
                                    <div class="info">
                                        <p><strong>${item.name}</strong></p>
                                        <p>${item.price}원 / ${item.stockUnitCd.nameKr}</p>
                                        <button class="btn add-to-cart" data-toggle="modal" idx="${item.id}">담기</button>
                                    </div>
                                </div>
                            </div>
                            </c:if>
                        </c:forEach>
                        <div class="clear"></div>
                    </div>
                </div>
            </div>
            <div id="item2" class="tab-pane fade">
                <div class="row contents">
                    <div class="col-sm-6">
                        <c:forEach var="item" items="${items}">
                            <c:if test="${item.category eq 'MEAT'}">
                            <div class="col-xs-6 text-center">
                                <div class="card-container">
                                    <img src=${item.imageUrl} width="100%" />
                                    <div class="info">
                                        <p><strong>${item.name}</strong></p>
                                        <p>${item.price}원 / ${item.stockUnitCd.nameKr}</p>
                                        <button class="btn add-to-cart" data-toggle="modal" idx="${item.id}">담기</button>
                                    </div>
                                </div>
                            </div>
                            </c:if>
                        </c:forEach>
                        <div class="clear"></div>
                    </div>
                </div>
            </div>
            <div id="item3" class="tab-pane fade">
                <div class="row contents">
                    <div class="col-sm-6">
                        <c:forEach var="item" items="${items}">
                            <c:if test="${item.category eq 'INSTANT'}">
                            <div class="col-xs-6 text-center">
                                <div class="card-container">
                                    <img src=${item.imageUrl} width="100%" />
                                    <div class="info">
                                        <p><strong>${item.name}</strong></p>
                                        <p>${item.price}원 / ${item.stockUnitCd.nameKr}</p>
                                        <button class="btn add-to-cart" data-toggle="modal" idx="${item.id}">담기</button>
                                    </div>
                                </div>
                            </div>
                            </c:if>
                        </c:forEach>
                        <div class="clear"></div>
                    </div>
                </div>
            </div>
            <div id="item4" class="tab-pane fade">
                <div class="row contents">
                    <div class="col-sm-6">
                        <c:forEach var="item" items="${items}">
                            <c:if test="${item.category eq 'SIDE'}">
                            <div class="col-xs-6 text-center">
                                <div class="card-container">
                                    <img src=${item.imageUrl} width="100%" />
                                    <div class="info">
                                        <p><strong>${item.name}</strong></p>
                                        <p>${item.price}원 / ${item.stockUnitCd.nameKr}</p>
                                        <button class="btn add-to-cart" data-toggle="modal" idx="${item.id}">담기</button>
                                    </div>
                                </div>
                            </div>
                            </c:if>
                        </c:forEach>
                        <div class="clear"></div>
                    </div>
                </div>
            </div>
            <div id="item5" class="tab-pane fade">
                <div class="row contents">
                    <div class="col-sm-6">
                        <c:forEach var="item" items="${items}">
                            <c:if test="${item.category eq 'ETC'}">
                            <div class="col-xs-6 text-center">
                                <div class="card-container">
                                    <img src=${item.imageUrl} width="100%" />
                                    <div class="info">
                                        <p><strong>${item.name}</strong></p>
                                        <p>${item.price}원 / ${item.stockUnitCd.nameKr}</p>
                                        <button class="btn add-to-cart" data-toggle="modal" idx="${item.id}">담기</button>
                                    </div>
                                </div>
                            </div>
                            </c:if>
                        </c:forEach>
                        <div class="clear">
                    </div>
                </div>
            </div>
        </div>
        <!-- end of tab contetns area -->
        <div class="clear"></div>
    </div>
</div>
<!-- end of section 2 -->
</div>

<!-- Modal -->
<div class="modal fade" id="itemModal" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">상품 주문</h4>
                <input id="cart-modal-item-id" type="hidden">
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="cart-modal-item-amount">수량을 선택하세요.</label>
                    <select class="form-control" id="cart-modal-item-amount">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                        <option>6</option>
                        <option>7</option>
                        <option>8</option>
                        <option>9</option>
                        <option>10</option>
                    </select>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default btn-cart-add">카트에 담기</button>
                <button type="button" class="btn btn-default btn-cart-cancel" data-dismiss="modal">취소하기</button>
            </div>
        </div>
    </div>
</div>
<jsp:include page="common/footer.jsp"/>