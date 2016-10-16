package com.helibrothers.dico.domain;

/**
 * Created by LeeDaebeom-Mac on 2016. 10. 16..
 */
public final class SessionConstant {
    public static final String IS_LOGIN = "IS_LOGIN";
    public static final String USER_ID = "USER_ID";
    public static final String CART_PREFIX = "CART_";

    public static String getCartSessionConstant(String userId) {
        return CART_PREFIX + userId;
    }

}
