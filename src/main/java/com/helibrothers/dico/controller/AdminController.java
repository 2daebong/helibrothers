package com.helibrothers.dico.controller;

import com.helibrothers.dico.core.service.ItemService;
import com.helibrothers.dico.domain.enums.ItemCategory;
import com.helibrothers.dico.domain.enums.StockUnitCd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by LeeDaebeom-Mac on 2016. 8. 25..
 */
@Controller
public class AdminController {

    @Autowired
    private ItemService itemService;

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

    @RequestMapping(value = "/admin/order", method = RequestMethod.GET)
    public ModelAndView order() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("admin/order");

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
