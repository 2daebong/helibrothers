package com.helibrothers.dico.core.repository;

import com.helibrothers.dico.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by LeeDaebeom-Mac on 2016. 8. 31..
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
