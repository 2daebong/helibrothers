package com.helibrothers.dico.domain;

import com.helibrothers.dico.domain.enums.OrderStatusCd;

/**
 * Created by LeeDaebeom-Mac on 2016. 8. 31..
 */
public class OrderSearch {

    private String userName;
    private OrderStatusCd orderStatusCd;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public OrderStatusCd getOrderStatusCd() {
        return orderStatusCd;
    }

    public void setOrderStatusCd(OrderStatusCd orderStatusCd) {
        this.orderStatusCd = orderStatusCd;
    }
}
