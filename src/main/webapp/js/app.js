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

        bindingEvents: function() {
            $(document).on('click', '.add-to-cart', function() {
                var self = $(this);
                app.showCartModal(self.attr("idx"));
            });
            $(document).on('click', '.btn-cart-add', function() {
                app.addToCart();
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
            var modal = $('#itemModal');
            var itemId = modal.find('#cart-modal-item-id')[0].value;
            var amount = modal.find('#cart-modal-item-amount')[0].value;
            console.log('상품 카트 담기 시도. ' + itemId + ' : ' + amount + '개');
        }
    }

    app.init();

})();