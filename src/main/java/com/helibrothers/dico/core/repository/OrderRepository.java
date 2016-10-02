package com.helibrothers.dico.core.repository;

import com.helibrothers.dico.domain.Order;
import com.helibrothers.dico.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by LeeDaebeom-Mac on 2016. 8. 31..
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}
