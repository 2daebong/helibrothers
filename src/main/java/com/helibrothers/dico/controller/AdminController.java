package com.helibrothers.dico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by LeeDaebeom-Mac on 2016. 8. 25..
 */
@Controller
public class AdminController {

    @RequestMapping(value = "/admin/index", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("admin/index");

        return mv;
    }

}
