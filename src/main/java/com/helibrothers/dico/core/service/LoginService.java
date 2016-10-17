package com.helibrothers.dico.core.service;

import com.helibrothers.dico.controller.WebController;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.json.simple.*;
import sun.net.www.http.HttpClient;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by jason on 9/20/16.
 * @remark : Please refer to below Naver's reference
 * https://developers.naver.com/docs/login/web
 */
@Service
@Transactional
public class LoginService {
    private final String NAVER_OAUTH_AUTHORIZE_URL = "https://nid.naver.com/oauth2.0/authorize";
    private final String NAVER_OAUTH_TOKEN_URL = "https://nid.naver.com/oauth2.0/token";
    private final String NAVER_OAUTH_PROFILE_URL = "https://openapi.naver.com/v1/nid/me";

    @Value("#{properties['naver.redirectURL']}")
    private String naverOauthRedirectUrl;

    @Value("#{properties['naver.clientId']}")
    private String naverClientId;

    @Value("#{properties['naver.clientSecret']}")
    private String naverClientSecret;

    final Logger logger = LoggerFactory.getLogger(WebController.class);

    public String generateState() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }

    public String getReqeustForAuthUrl(String state) {
        StringBuffer buffer = new StringBuffer();

        buffer.append(NAVER_OAUTH_AUTHORIZE_URL);
        buffer.append("?client_id=");
        buffer.append(naverClientId);
        buffer.append("&response_type=code&redirect_uri=");
        buffer.append(naverOauthRedirectUrl);
        buffer.append("&state=");
        buffer.append(state);

        return buffer.toString();
    }

    private String getReqeustTokenUrl(String state, String code) {
        StringBuffer buffer = new StringBuffer();

        buffer.append(NAVER_OAUTH_TOKEN_URL);
        buffer.append("?client_id=");
        buffer.append(naverClientId);
        buffer.append("&client_secret=");
        buffer.append(naverClientSecret);
        buffer.append("&grant_type=authorization_code");
        buffer.append("&state=");
        buffer.append(state);
        buffer.append("&code=");
        buffer.append(code);

        return buffer.toString();
    }

    private String getRequestRefreshTokenUrl(String refreshToken) {
        StringBuffer buffer = new StringBuffer();

        buffer.append(NAVER_OAUTH_TOKEN_URL);
        buffer.append("?client_id=");
        buffer.append(naverClientId);
        buffer.append("&client_secret=");
        buffer.append(naverClientSecret);
        buffer.append("&grant_type=refresh_token");
        buffer.append("&refresh_token=");
        buffer.append(refreshToken);

        return buffer.toString();
    }

    private String getRequestUserProfileUrl() {
        return NAVER_OAUTH_PROFILE_URL;
    }

    public boolean verifyResponseState(String sessionState, String responseState) {
        if (sessionState.equals(responseState)) {
            return true;
        }
        return false;
    }

    public String exchangeCodeToToken(String state, String code) {
        RestTemplate restTemplate = new RestTemplate();

        String requestTokenUrl = getReqeustTokenUrl(state, code);
        String responseString = restTemplate.getForObject(requestTokenUrl, String.class);

        logger.info("response : {}", responseString);

        JSONParser jsonParser = new JSONParser();
        JSONObject responseObject;

        String accessToken = "";
        String refreshToken = "";
        String tokenType = "";
        String expiresIn = "";

        try {
            responseObject = (JSONObject) jsonParser.parse(responseString);

            if (responseObject.get("error") != null) {
                logger.error("auth request error : {}", responseObject.get("error").toString());
                logger.error("auth request error description : {}", responseObject.get("error_description").toString());

                return null;
            } else {
                accessToken = responseObject.get("access_token").toString();
                refreshToken = responseObject.get("refresh_token").toString();
                tokenType = responseObject.get("token_type").toString();
                expiresIn = responseObject.get("expires_in").toString();
            }

        } catch (ParseException e) {
            logger.error(e.toString());
        }

        return accessToken;
    }

    public JSONObject getUserProfile(String accessToken) {
        RestTemplate restTemplate = new RestTemplate();

        String requestUserProfileUrl = getRequestUserProfileUrl();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken);

        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<String> response = restTemplate.exchange(requestUserProfileUrl,
                HttpMethod.GET, entity, String.class);

        String responseString = response.getBody();

        logger.info("userProfile : {}", responseString);

        JSONParser parser = new JSONParser();
        JSONObject responseObject = null;

        try {
            responseObject = (JSONObject) parser.parse(responseString);
        } catch (ParseException e) {
            logger.error(e.toString());
        }

        return responseObject;
    }

}
