package com.helibrothers.dico.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LeeDaebeom-Mac on 2016. 9. 21..
 */
public class Cart {

    private String userId;

    Map<Long, CartItem> cartItemMap;

    public Cart() {
    }

    public Cart(String userId, CartItem item) {
        this.userId = userId;
        cartItemMap = new HashMap<Long, CartItem>();
        cartItemMap.put(item.getItem().getId(), item);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<Long, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<Long, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Collection<CartItem> getCartItemList() {
        return this.cartItemMap.values();
    }
}
