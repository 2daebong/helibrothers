package com.helibrothers.dico.controller;

import com.helibrothers.dico.core.service.ItemService;
import com.helibrothers.dico.core.service.LoginService;
import com.helibrothers.dico.core.service.UserService;
import com.helibrothers.dico.domain.SessionConstant;
import com.helibrothers.dico.domain.User;
import com.helibrothers.dico.domain.embeddable.UserInfo;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by LeeDaebeom-Mac on 2016. 9. 3..
 */
@Controller
public class WebController {
    final Logger logger = LoggerFactory.getLogger(WebController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mweb/index");

        mv.addObject("items", itemService.findItems());

        return mv;
    }

    @RequestMapping(value = "/cartList", method = RequestMethod.GET)
    public ModelAndView cartList() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("mweb/login");
        return mv;
    }

    @RequestMapping(value = "/cartList/{userId}", method = RequestMethod.GET)
    public ModelAndView cartListByUser(@PathVariable String userId, HttpSession session) {
        ModelAndView mv = new ModelAndView();

        if (isLogin(session) == false) {
            mv.setViewName("mweb/login");
            return mv;
        }

        // 로그인 아이디 검증
        if (StringUtils.equals(userId, session.getAttribute(SessionConstant.USER_ID).toString()) == false) {
            mv.setViewName("mweb/login");
            return mv;
        }

        mv.setViewName("mweb/cartList");

        mv.addObject("cart", session.getAttribute(SessionConstant.getCartSessionConstant(userId)));

        return mv;
    }

    @RequestMapping(value = "/orderList", method = RequestMethod.GET)
    public ModelAndView orderList(HttpSession session) {
        ModelAndView mv = new ModelAndView();

        if (isLogin(session) == false) {
            mv.setViewName("redirect:/login");
            return mv;
        }

        mv.setViewName("mweb/orderList");

        String userId = session.getAttribute(SessionConstant.USER_ID).toString();

        User user = userService.findOne(userId);

        if (user != null) {
            mv.addObject("userName", user.getName());
            mv.addObject("userAddress", user.getUserInfo().getAddress());
            mv.addObject("phoneNumber", user.getUserInfo().getPhoneNumber());
        }

        return mv;
    }

    @RequestMapping(value = "/modifyUserInfo", method = RequestMethod.GET)
    public ModelAndView modifyUserInfo(HttpSession session) {
        ModelAndView mv = new ModelAndView();

        if (isLogin(session) == false) {
            mv.setViewName("mweb/login");
            return mv;
        }

        mv.setViewName("mweb/userInfo");

        String userId = session.getAttribute(SessionConstant.USER_ID).toString();

        User user = userService.findOne(userId);

        if (user != null) {
            mv.addObject("userName", user.getName());
            mv.addObject("userAddress", user.getUserInfo().getAddress());
            mv.addObject("phoneNumber", user.getUserInfo().getPhoneNumber());
        }

        return mv;
    }

    @RequestMapping(value = "/saveUserInfo", method = RequestMethod.POST)
    public @ResponseBody JSONObject saveUserInfo(@RequestBody Map<String, Object> bodyMap, HttpSession session) {
        JSONObject returnObj = new JSONObject();
        returnObj.put("status", "ERROR");

        String userId = session.getAttribute(SessionConstant.USER_ID).toString();
        String address = MapUtils.getString(bodyMap, "address");
        String phoneNumber = MapUtils.getString(bodyMap, "phoneNumber");

        logger.info("userid {}, address:{}, phon:{}", userId, address, phoneNumber);

        if (userId == null || address == null || phoneNumber == null) {
            returnObj.put("status", "ERROR");
        } else {
            User user = userService.findOne(userId);

            if (user != null) {
                UserInfo userInfo = user.getUserInfo();
                userInfo.setAddress(address);
                userInfo.setPhoneNumber(phoneNumber);

                user.setUserInfo(userInfo);

                String savedUserId = userService.join(user);

                if (savedUserId.equals(userId)) {
                    returnObj.put("status", "SUCCESS");
                }
            }
        }

        return returnObj;
    }

    private boolean isLogin(HttpSession session) {
        return session.getAttribute(SessionConstant.IS_LOGIN) != null;
    }
}
