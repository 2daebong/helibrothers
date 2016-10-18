package com.helibrothers.dico.controller;

import com.helibrothers.dico.core.service.ItemService;
import com.helibrothers.dico.core.service.OrderService;
import com.helibrothers.dico.core.service.UserService;
import com.helibrothers.dico.domain.User;
import com.helibrothers.dico.domain.enums.ItemCategory;
import com.helibrothers.dico.domain.enums.OrderStatusCd;
import com.helibrothers.dico.domain.enums.StockUnitCd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by LeeDaebeom-Mac on 2016. 8. 25..
 */
@Controller
public class AdminController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin/index", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("admin/index");

        return mv;
    }

    @RequestMapping(value = "/admin/shop", method = RequestMethod.GET)
    public ModelAndView shop() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("admin/shop");

        return mv;
    }

    @RequestMapping(value = "/admin/order/{userId}", method = RequestMethod.GET)
    public ModelAndView order(@PathVariable String userId) {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("admin/order");
        mv.addObject("orders", orderService.findByUserId(userId));
        mv.addObject("orderStatusEnums", OrderStatusCd.values());

        return mv;
    }

    @RequestMapping(value = "/admin/order", method = RequestMethod.GET)
    public ModelAndView orderPrepare() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("admin/order");
        mv.addObject("orders", orderService.findAll());
        mv.addObject("orderStatusEnums", OrderStatusCd.values());

        return mv;
    }

    @RequestMapping(value = "/admin/product", method = RequestMethod.GET)
    public ModelAndView product() {
        ModelAndView mv = new ModelAndView();

        mv.addObject("items", itemService.findItems());
        mv.addObject("categories", ItemCategory.values());
        mv.addObject("stockUnitCds", StockUnitCd.values());

        mv.setViewName("admin/product");

        return mv;
    }

    @RequestMapping(value = "/admin/user", method = RequestMethod.GET)
    public ModelAndView user() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("admin/user");
        List<User> users = userService.findUsers();
        mv.addObject("users", users);

        return mv;
    }

    @RequestMapping(value = "/admin/test", method = RequestMethod.GET)
    public ModelAndView test() {
        ModelAndView mv = new ModelAndView();

        mv.addObject("items", itemService.findItems());

        mv.setViewName("admin/test");

        return mv;
    }

}
