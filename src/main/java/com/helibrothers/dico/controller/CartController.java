package com.helibrothers.dico.controller;

import com.helibrothers.dico.core.service.CartService;
import com.helibrothers.dico.domain.Cart;
import com.helibrothers.dico.domain.SessionConstant;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by LeeDaebeom-Mac on 2016. 9. 20..
 */
@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/api/cart", method = RequestMethod.POST)
    public Cart putInCart(@RequestBody Map<String, Object> bodyMap, HttpServletRequest request) {

        String userId = MapUtils.getString(bodyMap, "userId");
        Long itemId = MapUtils.getLong(bodyMap, "itemId");
        Integer amount = MapUtils.getInteger(bodyMap, "amount");

        Cart userCart = (Cart) request.getSession().getAttribute(SessionConstant.getCartSessionConstant(userId));

        userCart = cartService.putInCart(userCart, userId, itemId, amount);

        request.getSession().setAttribute(SessionConstant.getCartSessionConstant(userId), userCart);

        return userCart;
    }

    @RequestMapping(value = "/api/cart/", method = RequestMethod.PUT)
    public void updateCart(@RequestBody Map<String, Object> bodyMap, HttpServletRequest request) {


    }

}
