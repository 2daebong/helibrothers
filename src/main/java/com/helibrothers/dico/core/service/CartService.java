package com.helibrothers.dico.core.service;

import com.helibrothers.dico.domain.Cart;
import com.helibrothers.dico.domain.CartItem;
import com.helibrothers.dico.domain.Item;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

/**
 * Created by LeeDaebeom-Mac on 2016. 9. 20..
 */
@Service
public class CartService {

    private final static Log LOG = LogFactory.getLog(CartService.class);

    @Autowired
    private ItemService itemService;

    public Cart putInCart(Cart userCart, String userId, Long itemId, Integer amount) {

        if(this.isInvalidParams(userId, itemId, amount)) {
            LOG.error("put in Cart Error, invalid Cart item. userId = " + userId + "  itemId = " + itemId + "  amount = " + amount);
            throw new InvalidParameterException();
        }

        Item newItem = itemService.findOne(itemId);
        CartItem newCartItem = new CartItem(newItem, amount);

        if(userCart == null) {
            userCart = new Cart(userId, newCartItem);
            return userCart;
        }

        CartItem oldCartItem = userCart.getCartItemMap().get(itemId);

        if(oldCartItem != null) {
            newCartItem.addAmount(oldCartItem.getAmount());
        }

        userCart.getCartItemMap().put(itemId, newCartItem);

        return userCart;
    }

    private boolean isInvalidParams(String userId, Long itemId, Integer amount) {
        return StringUtils.isEmpty(userId) || itemId == null || amount == null || amount < 1;
    }

}
