package com.helibrothers.dico.domain.response;

import com.helibrothers.dico.domain.Order;

/**
 * Created by LeeDaebeom-Mac on 2016. 10. 3..
 */
public class OrderResponse {

    private Order order;

    private ResultCd resultCd;

    private String msg;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ResultCd getResultCd() {
        return resultCd;
    }

    public void setResultCd(ResultCd resultCd) {
        this.resultCd = resultCd;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
