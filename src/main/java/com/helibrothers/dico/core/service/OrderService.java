package com.helibrothers.dico.core.service;

import com.helibrothers.dico.core.repository.OrderRepository;
import com.helibrothers.dico.domain.*;
import com.helibrothers.dico.domain.embeddable.UserInfo;
import com.helibrothers.dico.exception.NotRegistUserInfoException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LeeDaebeom-Mac on 2016. 8. 31..
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;

    public Long order(String userId, Long itemId, int count) {
        User user = userService.findOne(userId);
        Item item = itemService.findOne(itemId);

        Delivery delivery = new Delivery(user.getUserInfo());
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        orderItems.add(orderItem);
        Order order = Order.createOrder(user, delivery, orderItems);

        orderRepository.save(order);
        return order.getId();
    }

    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findOne(orderId);
        order.cancel();
    }

    @Transactional
    public Order doOrderUsingCart(Cart cart) throws NotRegistUserInfoException {
        User user = userService.findOne(cart.getUserId());

        if(isInvalidUserInfo(user.getUserInfo())) {
            throw new NotRegistUserInfoException();
        }

        List<CartItem> cartItems = cart.getCartItemList();
        List<OrderItem> orderItems = new ArrayList<OrderItem>();

        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = OrderItem.createOrderItem(cartItem.getItem(), cartItem.getItem().getPrice(), cartItem.getAmount());
            orderItems.add(orderItem);
            // TODO : Item 수량 update가 되지 않아 임시로 update query 날림. 추후 릴레이션 update 로 처리하도록 수정 필요.
            itemService.updateItem(orderItem.getItem());
        }

        Delivery delivery = new Delivery(user.getUserInfo());
        Order order = Order.createOrder(user, delivery, orderItems);

        orderRepository.save(order);

        return order;
    }

    private boolean isInvalidUserInfo(UserInfo userInfo) {
        return StringUtils.isEmpty(userInfo.getAddress()) || StringUtils.isEmpty(userInfo.getPhoneNumber());
    }

    public List<Order> findByUserId(String userId) {
        User user = userService.findOne(userId);
        List<Order> orders = orderRepository.findByUser(user);
        return orders;
    }

    public Order findOne(Long orderId) {
        return orderRepository.findOne(orderId);
    }
}
