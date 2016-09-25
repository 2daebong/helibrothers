package com.helibrothers.dico.controller;

import com.helibrothers.dico.core.service.LoginService;
import com.helibrothers.dico.core.service.UserService;
import com.helibrothers.dico.domain.User;
import com.helibrothers.dico.domain.embeddable.UserInfo;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by LeeDaebeom-Mac on 2016. 9. 3..
 */
@Controller
public class WebController {
    final Logger logger = LoggerFactory.getLogger(WebController.class);
    private final String SESSION_IS_LOGIN = "IS_LOGIN";
    private final String SESSION_USER_EMAIL = "USER_EMAIL";

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mweb/index");

        return mv;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpSession session) {
        ModelAndView mv = new ModelAndView();

        if (session.getAttribute(SESSION_IS_LOGIN) != null) {
            logger.info("User Alread login : {}", session.getAttribute(SESSION_USER_EMAIL).toString());

            // Make a redirect
            mv.setViewName("redirect:/");

            return mv;
        }

        logger.info("User is not logged");

        mv.setViewName("mweb/login");

        return mv;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        unRegisterLoginSession(session);

        return "redirect:/";
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
    public String naverOauth(HttpSession session) {
        logger.debug("naverOauthRedirect");

        // For verification
        String state = loginService.generateState();
        session.setAttribute("state", state);

        return "redirect:" + loginService.getReqeustForAuthUrl(state);
    }

    @RequestMapping(value = "/naverOauthCallback", method = RequestMethod.GET)
    public ModelAndView naverOauthCallback(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession();

        String processViewName = "mweb/naverOauthFailed";
        String sessionState = request.getSession().getAttribute("state").toString();
        String responseState = request.getParameter("state");
        String code = request.getParameter("code");
        String accessToken;

        boolean isVerified = loginService.verifyResponseState(sessionState, responseState);

        JSONObject responseObject;
        JSONObject userProfileObject;

        if (isVerified) {
            accessToken = loginService.exchangeCodeToToken(responseState, code);

            if (accessToken == null) {
                logger.error("Need to new login flow");

                mv.setViewName(processViewName);

                return mv;
            }

            responseObject = loginService.getUserProfile(accessToken);

            //TODO If access token has been expired, Need to get a new access token through refresh token

            if (responseObject.get("message").toString().equals("success")) {
                userProfileObject = (JSONObject) responseObject.get("response");

                String userEmail = userProfileObject.get("email").toString();

                if (userService.findOne(userEmail) == null) {
                    User user = new User();
                    UserInfo userInfo = new UserInfo();

                    userInfo.setAddress("");
                    userInfo.setPhoneNumber("");

                    user.setUserInfo(userInfo);
                    user.setId(userEmail);
                    user.setName(userProfileObject.get("nickname").toString());

                    String savedUserEmail = userService.join(user);

                    logger.info("Saved User Email : {}", savedUserEmail);

                } else {
                    logger.info("Already User Email is existing");
                }

                // Register login info into session
                registerLoginSession(session, userEmail);

                processViewName = "mweb/naverOauthSuccess";
            }
        }

        mv.setViewName(processViewName);

        return mv;
    }

    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public ModelAndView join() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mweb/join");

        return mv;
    }

    private void registerLoginSession(HttpSession session, String userEmail) {
        session.setAttribute(SESSION_IS_LOGIN, "login");
        session.setAttribute(SESSION_USER_EMAIL, userEmail);
    }

    private void unRegisterLoginSession(HttpSession session) {
        session.setAttribute(SESSION_IS_LOGIN, null);
        session.setAttribute(SESSION_USER_EMAIL, null);
    }

}
