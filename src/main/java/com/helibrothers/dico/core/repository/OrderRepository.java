package com.helibrothers.dico.core.repository;

import com.helibrothers.dico.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by LeeDaebeom-Mac on 2016. 8. 31..
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
