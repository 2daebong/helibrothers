package com.helibrothers.dico.controller;

import com.helibrothers.dico.core.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by LeeDaebeom-Mac on 2016. 9. 3..
 */
@Controller
public class WebController {
    final Logger logger = LoggerFactory.getLogger(WebController.class);

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mweb/index");

        return mv;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mweb/login");

        return mv;
    }

    @RequestMapping(value = "/cartList", method = RequestMethod.GET)
    public ModelAndView cartList() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mweb/cartList");

        return mv;
    }

    @RequestMapping(value = "/orderList", method = RequestMethod.GET)
    public ModelAndView orderList() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mweb/orderList");

        return mv;
    }

    @RequestMapping(value = "/naverOauthRedirect")
    public String naverOauth(HttpServletRequest req) {
        logger.debug("naverOauthRedirect");

        loginService.init(req);

        return "redirect:" + loginService.getReqeustForAuthUrl();
    }

    @RequestMapping(value = "/naverOauthCallback", method = RequestMethod.GET)
    public ModelAndView naverOauthCallback(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView();

        String state = req.getParameter("state");
        String code = req.getParameter("code");

        if (loginService.verifyResponseState(state)) {
            logger.debug("code : {}", code);
            mv.setViewName("mweb/naverOauthSuccess");
        } else {
            mv.setViewName("mweb/naverOauthFailed");
        }

        return mv;
    }

    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public ModelAndView join() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mweb/join");

        return mv;
    }

}
