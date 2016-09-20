package com.helibrothers.dico.core.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by jason on 9/20/16.
 */
@Service
@Transactional
public class LoginService {
    private final String NAVER_OAUTH_AUTHORIZE_URL = "https://nid.naver.com/oauth2.0/authorize";
    private final String NAVER_OAUTH_TOKEN_URL = "https://nid.naver.com/oauth2.0/token";
    private final String NAVER_GET_USERINFO_URL = "https://apis.naver.com/nidlogin/nid/getUserProfile.xml";
    private final String NAVER_CLIENT_ID = "CH1s15EkwPutdRu7tvjl";
    private final String NAVER_REDIRECT_URL = "http://localhost:8080/naverOauthCallback";

    private HttpServletRequest request;

    public void init(HttpServletRequest request) {
        this.request = request;
        setState(request);
    }

    private String generateState() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }

    private void setState(HttpServletRequest request) {
        request.getSession().setAttribute("state", this.generateState());
    }

    private String getState() {
        return request.getSession().getAttribute("state").toString();
    }

    public String getReqeustForAuthUrl() {
        StringBuffer buffer = new StringBuffer();

        buffer.append(NAVER_OAUTH_AUTHORIZE_URL);
        buffer.append("?client_id=");
        buffer.append(NAVER_CLIENT_ID);
        buffer.append("&response_type=code&redirect_uri=");
        buffer.append(NAVER_REDIRECT_URL);
        buffer.append("&state=");
        buffer.append(getState());

        return buffer.toString();
    }

    public String getReqeustTokenUrl() {
        return null;
    }

    public boolean verifyResponseState(String responseState) {
        String sessionState = getState();

        if (sessionState.equals(responseState)) {
            return true;
        }

        return false;
    }

}
