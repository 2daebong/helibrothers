package com.helibrothers.dico.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.helibrothers.dico.core.service.OrderService;
import com.helibrothers.dico.domain.Cart;
import com.helibrothers.dico.domain.Order;
import com.helibrothers.dico.domain.SessionConstant;
import com.helibrothers.dico.domain.enums.OrderStatusCd;
import com.helibrothers.dico.domain.response.ResultCd;
import com.helibrothers.dico.exception.NotRegistUserInfoException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by LeeDaebeom-Mac on 2016. 10. 2..
 */
@RestController
public class OrderController {

    private final static Log LOG = LogFactory.getLog(OrderController.class);

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/api/order/{id}", method = RequestMethod.GET)
    public Order getOrder(@PathVariable Long id) {
        return orderService.findOne(id);
    }

    @RequestMapping(value = "/api/order/{id}", method = RequestMethod.PUT)
    public void updateOrder(@PathVariable Long id, @RequestBody String orderStatus) {
        Order order = orderService.findOne(id);

        if(order != null) {
            order.setStatus(OrderStatusCd.valueOf(orderStatus));
            orderService.update(order);
        }
    }

    @RequestMapping(value = "/api/order/cart", method = RequestMethod.POST)
    public ResultCd doOrder(@RequestBody String userId, HttpServletRequest request) throws JsonProcessingException {

        ResultCd resultCd = ResultCd.ERROR;

        if(StringUtils.equals(userId, request.getSession().getAttribute(SessionConstant.USER_ID).toString()) == false) {
            return ResultCd.LOGIN_ERROR;
        }

        Cart cart = (Cart) request.getSession().getAttribute(SessionConstant.getCartSessionConstant(userId));
        Order order = null;

        if(StringUtils.equals(cart.getUserId(), userId)) {

            try {
                order = orderService.doOrderUsingCart(cart);
                resultCd = ResultCd.SUCCESS;
            } catch (NotRegistUserInfoException e) { // 주소, 전화번호 등록되지 않음
                resultCd = ResultCd.NEED_USERINFO;
            } catch (Exception e) {
                resultCd = ResultCd.ERROR;
                LOG.error(e);
            }

            if(order != null) {
                request.getSession().removeAttribute(SessionConstant.getCartSessionConstant(userId));
            }
        }

        return resultCd;
    }
}
