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
    private ItemRepository itemRepository;

    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }

    public Item findByName(String name) {
        return itemRepository.findByName(name);
    }

    public void removeItem(Long itemId) {
        itemRepository.delete(itemId);
    }
}
