package com.helibrothers.dico.core.repository;

import com.helibrothers.dico.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by LeeDaebeom-Mac on 2016. 8. 31..
 */
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findByName(String name);
}
