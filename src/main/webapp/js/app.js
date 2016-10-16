/**
 * Created by 2016. 08.16
 */
"use strict";

var app = null;

(function() {

    app = {

        init: function() {
            var self = this;
            self.bindingEvents();
        },

        isLogin: function() {

            if($('#isLogin')[0].value) {
                return true;
            };

            return false;
        },

        getUserId: function() {
            return $('#userId')[0].value;
        },

        bindingEvents: function() {
            $(document).on('click', '.add-to-cart', function() {
                var self = $(this);
                app.showCartModal(self.attr("idx"));
            });
            $(document).on('click', '.btn-cart-add', function() {
                app.addToCart();
            });
            $(document).on('click', '#order', function() {
                app.doOrder();
            });
        },

        showCartModal: function(orderIndex) {
            app.showModalPopupForOrder(orderIndex);
        },

        showToast: function(message) {
            var toast = $('#alert');
            toast.html(message);
            toast.fadeIn(500);
        },

        hideToast: function() {
            var toast = $('#alert');
            toast.fadeOut(500);
        },

        showModalPopupForOrder: function(orderIndex) {
            var modal = $('#itemModal');
            modal.find('.modal-title').html('상품 주문 번호 : ' + orderIndex);
            modal.find('#cart-modal-item-id')[0].value = orderIndex;
            modal.modal("show");
        },

        hideModalPopupForOrder: function() {
            var modal = $('#itemModal');
            modal.modal('hide');
        },
        
        addToCart: function() {
            if(false == app.isLogin()) {
                location.href = '/login';
                return;
            }

            var modal = $('#itemModal');
            var itemId = modal.find('#cart-modal-item-id')[0].value;
            var amount = modal.find('#cart-modal-item-amount')[0].value;
            var userId = app.getUserId();


            var cartItem = {
                'userId' : userId,
                'itemId' : itemId,
                'amount' : amount
            }

            console.log('상품 카트 담기 시도. ' + JSON.stringify(cartItem));

            $.ajax({
                type: "POST",
                url: "/api/cart/",
                data: JSON.stringify(cartItem),
                dataType: "json",
                contentType : "application/json; charset=utf-8",
                success: function(){
                    location.href = "/cartList/" + userId;
                },
                error : app.ajaxError
            });
        },

        doOrder: function() {
            var userId = app.getUserId();

            $.ajax({
                type: "POST",
                url : "/api/order/cart",
                data: userId,
                dataType: "json",
                contentType : "application/json; charset=utf-8",
                success: function(result) {
                    if(result == 'SUCCESS') {
                        alert('주문이 완료되었습니다.');
                    } else if(result == 'NEED_USERINFO') {
                        location.href = "/modifyUserInfo";
                        return
                    } else if(result == 'ERROR') {
                        alert(result)
                    }
                },
                error: app.ajaxError
            });
        },

        saveUserInfo: function(address, phoneNumber) {
            var userInfo = {
                'userId': app.getUserId(),
                'address': address,
                'phoneNumber': phoneNumber
            };

            $.ajax({
                type: 'POST',
                url : '/saveUserInfo',
                data: JSON.stringify(userInfo),
                dataType: 'json',
                contentType: 'application/json; charset=uti-8',
                success: function(result) {
                    if (result.status === 'SUCCESS') {
                        alert("업데이트 성공!");
                        window.location.href = "/modifyUserInfo"
                    } else {
                        console.log("업데이트에 실패하였습니다.");
                    }
                },
                error: app.ajaxError
            })
        },

        ajaxError: function(request, status, error) {
            alert("fail. code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
    }

    app.init();

})();