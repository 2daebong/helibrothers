package com.helibrothers.dico.core.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.helibrothers.dico.core.repository.OrderRepository;
import com.helibrothers.dico.domain.*;
import com.helibrothers.dico.domain.embeddable.UserInfo;
import com.helibrothers.dico.domain.enums.OrderStatusCd;
import com.helibrothers.dico.exception.NotEnoughStockException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by LeeDaebeom-Mac on 2016. 8. 31..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appConfig.xml")
@Transactional
public class OrderServiceTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;

    @Test
    public void 상품주문() throws Exception {

        // Given
        User user = createUser();
        Item item = createItem("APPLE", 990, 10);
        int orderCount = 2;

        // When
        Long orderId = orderService.order(user.getId(), item.getId(), orderCount);

        // Then
        Order getOrder = orderRepository.findOne(orderId);

        assertEquals("상품 주문시 상태는 ORDER", OrderStatusCd.WAIT, getOrder.getStatus());
        assertEquals("주문한 상품 종류 수가 정확해야 한다.", 1, getOrder.getOrderItems().size());
        assertEquals("주문 가격은 가격*수량 이다.", 990*2, getOrder.getTotalPrice());
        assertEquals("주문 수량만큼 재고가 줄어야 한다", 8, item.getStockQuantity());
    }

    @Test
    public void 상품주문_카트로() throws Exception {

        Cart cart = new Cart();
        cart.setUserId("2daebong");
        Map<Long, CartItem> cartItemMap = new HashMap<Long, CartItem>();
        Item item = new Item();
        item.setId(1l);
        item.setPrice(100);
        item.setStockQuantity(10);
        cartItemMap.put(1l, new CartItem(item, 2));

        cart.setCartItemMap(cartItemMap);

        Order oldOrder = orderService.doOrderUsingCart(cart);

        Order order = orderRepository.findOne(oldOrder.getId());

        assertEquals(100*2, order.getTotalPrice());
        assertEquals(8, order.getOrderItems().get(0).getItem().getStockQuantity());
    }

    @Test(expected = NotEnoughStockException.class)
    public void 상품주문_재고수량초과() throws Exception {
        // Given
        User user = createUser();
        Item item = createItem("APPLE", 990, 10);
        int orderCount = 11; // 재고보다 많은 수량

        // When
        orderService.order(user.getId(), item.getId(), orderCount);

        // Then
        fail("재고 수량 부족 예외가 발생해야 한다.");
    }

    @Test
    public void 주문취소() {
        // Given
        User user = createUser();
        Item item = createItem("APPLE", 990, 10);
        int orderCount = 2;

        Long orderId = orderService.order(user.getId(), item.getId(), orderCount);

        // When
        orderService.cancelOrder(orderId);

        // Then
        Order getOrder = orderRepository.findOne(orderId);

        assertEquals("주문 취소시 상태는 CANCEL 이다.", OrderStatusCd.CANCEL, getOrder.getStatus());
        assertEquals("주문이 취소된 상품은 그만큼 재고가 증가해야 한다.", 10, item.getStockQuantity());
    }

    private User createUser() {
        User user = new User();
        user.setId("2daebong");
        user.setName("이대범");
        user.setUserInfo(new UserInfo("경기도 용인시 기흥구 보정동 1191-10번지 201호", "010-2949-7507"));
        em.persist(user);
        return user;
    }

    private Item createItem(String name, int price, int stockQuantity) {
        Item item = new Item();
        item.setName(name);
        item.setStockQuantity(stockQuantity);
        item.setPrice(price);
        em.persist(item);
        return item;
    }
}