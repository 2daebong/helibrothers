package com.helibrothers.dico.core.service;

import com.helibrothers.dico.core.repository.ItemRepository;
import com.helibrothers.dico.domain.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by LeeDaebeom-Mac on 2016. 8. 31..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appConfig.xml")
@Transactional
public class ItemServiceTest {

    @Autowired
    ItemService itemService;
    @Autowired
    ItemRepository itemRepository;

    @Test
    public void 아이템_저장() {
        Item item = new Item();
        item.setName("apple");

        itemService.saveItem(item);

        assertEquals(item, itemService.findByName("apple"));
    }
}