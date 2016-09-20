package com.helibrothers.dico.core.service;

import com.helibrothers.dico.domain.Cart;
import com.helibrothers.dico.domain.CartItem;
import com.helibrothers.dico.domain.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by LeeDaebeom-Mac on 2016. 9. 21..
 */
@RunWith(MockitoJUnitRunner.class)
public class CartServiceTest {

    private static final String TEST_USER_ID = "testID";
    private static final long TEST_ITEM_ID = 1L;
    public static final long ANOTHER_TEST_ITEM_ID = 2L;

    @InjectMocks
    private CartService cartService;

    @Mock
    private ItemService itemService;

    @Test
    public void putInCart_사용자카트_없음() throws Exception {

        Cart cart = null;

        Item item = new Item();
        item.setId(TEST_ITEM_ID);

        when(itemService.findOne(TEST_ITEM_ID)).thenReturn(item);

        Cart resultCart = cartService.putInCart(cart, TEST_USER_ID, TEST_ITEM_ID, 5);

        assertEquals(resultCart.getCartItemMap().get(TEST_ITEM_ID).getAmount(), 5);
    }

    @Test
    public void putInCart_카트는있으나_담긴_상품이없음() throws Exception {

        Item item = new Item();
        item.setId(TEST_ITEM_ID);

        Map<Long, CartItem> cartItemMap = new HashMap<Long, CartItem>();

        Cart cart = new Cart();
        cart.setUserId(TEST_USER_ID);
        cart.setCartItemMap(cartItemMap);

        when(itemService.findOne(TEST_ITEM_ID)).thenReturn(item);

        Cart resultCart = cartService.putInCart(cart, TEST_USER_ID, TEST_ITEM_ID, 3);

        assertEquals(resultCart.getCartItemMap().get(TEST_ITEM_ID).getAmount(), 3);
    }

    @Test
    public void putInCart_카트에_같은상품_존재() throws Exception {

        Item item = new Item();
        item.setId(TEST_ITEM_ID);

        CartItem oldCartItem = new CartItem(item, 5);

        Cart cart = new Cart(TEST_USER_ID, oldCartItem);

        when(itemService.findOne(TEST_ITEM_ID)).thenReturn(item);

        Cart resultCart = cartService.putInCart(cart, TEST_USER_ID, TEST_ITEM_ID, 5);

        assertEquals(resultCart.getCartItemMap().get(TEST_ITEM_ID).getAmount(), 10);
    }

    @Test
    public void putInCart_카트에_다른상품_존재() throws Exception {
        Item item = new Item();
        item.setId(ANOTHER_TEST_ITEM_ID);

        CartItem oldCartItem = new CartItem(item, 3);

        Cart cart = new Cart(TEST_USER_ID, oldCartItem);

        when(itemService.findOne(TEST_ITEM_ID)).thenReturn(item);

        Cart resultCart = cartService.putInCart(cart, TEST_USER_ID, TEST_ITEM_ID, 5);

        assertEquals(resultCart.getCartItemMap().get(TEST_ITEM_ID).getAmount(), 5);
        assertEquals(resultCart.getCartItemMap().get(ANOTHER_TEST_ITEM_ID).getAmount(), 3);
    }

    @Test(expected = InvalidParameterException.class)
    public void putInCart_예외검증_아이디() throws Exception {
        cartService.putInCart(null, null, 1L, 1);
    }

    @Test(expected = InvalidParameterException.class)
    public void putInCart_예외검증_상품아이디() throws Exception {
        cartService.putInCart(null, TEST_USER_ID, null, 1);
    }

    @Test(expected = InvalidParameterException.class)
    public void putInCart_예외검증_수량null() throws Exception {
        cartService.putInCart(null, TEST_USER_ID, 1L, null);
    }

    @Test(expected = InvalidParameterException.class)
    public void putInCart_예외검증_수량() throws Exception {
        cartService.putInCart(null, TEST_USER_ID, 1L, 0);
    }

}