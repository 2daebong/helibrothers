<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="common/header.jsp"/>
<style>
    .phone-field {
        border:1px solid #DCDCDC;
        width:25%;
        text-align:center;
    }

    #address {
        width:100%;
    }
</style>
<div class="container-fluid common main-contents-area">
    <div class="row">
        <p align=center>배송지 입력확인</p>
    </div>
    <div class="row user-address">
        <div class="card-container">
            <div class="title">배송지 정보</div>
            <div class="body">
                <table>
                    <colgroup>
                        <col width="70"/>
                        <col/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <td>수령인</td>
                        <td>${userName}</td>
                    </tr>
                    <tr>
                        <td>연락처</td>
                        <td>
                            <input type="text" name="phone-field" class="phone-field" id="phone-1" autofocus><span>&nbsp;
                            -</span>
                            <input type="text" name="phone-field" class="phone-field" id="phone-2"><span>&nbsp;-</span>
                            <input type="text" name="phone-field" class="phone-field" id="phone-3">
                        </td>
                    </tr>
                    <tr>
                        <td>주소지</td>
                        <td><input type="text" id="address" placeholder="주소를 입력해주세요."></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div>
            <button class="btn btn-lg btn-common" id="save-user-info">저장하기</button>
        </div>
    </div>
</div>
<script>
    $("#phone-1").on("keypress", function(e) {
        if (e.target.value.length > 1) {
            $("#phone-2").focus();
        }
    });
    $("#phone-2").on("keypress", function(e) {
        if (e.target.value.length > 2) {
            $("#phone-3").focus();
        }
    });
    $("#phone-3").on("keypress", function(e) {
        if (e.target.value.length > 2) {
            $("#address").focus();
        }
    });
</script>
<jsp:include page="common/footer.jsp"/>