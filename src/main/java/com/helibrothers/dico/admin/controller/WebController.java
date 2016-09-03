package com.helibrothers.dico.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by LeeDaebeom-Mac on 2016. 9. 3..
 */
@Controller
public class WebController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("mweb/index");

        return mv;
    }
}
