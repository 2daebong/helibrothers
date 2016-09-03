package com.helibrothers.dico.core.service;

import com.helibrothers.dico.core.repository.ItemRepository;
import com.helibrothers.dico.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by LeeDaebeom-Mac on 2016. 8. 31..
 */
@Service
@Transactional
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }

    public List<Item> findByName(String name) {
        return itemRepository.findByname(name);
    }
}
