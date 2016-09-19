package com.helibrothers.dico.controller;

import com.helibrothers.dico.core.service.CartService;
import com.helibrothers.dico.domain.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by LeeDaebeom-Mac on 2016. 9. 20..
 */
@Controller
public class CartController {

    @Autowired
    private CartService cartService;

//    @RequestMapping(value = "/api/cart", method = RequestMethod.POST)
//    public OrderItem carting(@RequestBody OrderItem orderItem) {
//    }

}
