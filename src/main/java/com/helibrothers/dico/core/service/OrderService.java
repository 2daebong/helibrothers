package com.helibrothers.dico.core.service;

import com.helibrothers.dico.core.repository.OrderRepository;
import com.helibrothers.dico.core.repository.UserRepository;
import com.helibrothers.dico.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LeeDaebeom-Mac on 2016. 8. 31..
 */
@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ItemService itemService;

    public Long order(String userId, Long itemId, int count) {
        User user = userRepository.findOne(userId);
        Item item = itemService.findOne(itemId);

        Delivery delivery = new Delivery(user.getUserInfo());
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
        Order order = Order.createOrder(user, delivery, orderItem);

        orderRepository.save(order);
        return order.getId();
    }

    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findOne(orderId);
        order.cancel();
    }

    public List<Order> findOrders(OrderSearch orderSearch) {
        return orderRepository.findAll(orderSearch);
    }
}
