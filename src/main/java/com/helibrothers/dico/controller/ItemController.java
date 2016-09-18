package com.helibrothers.dico.controller;

import com.helibrothers.dico.core.service.ItemService;
import com.helibrothers.dico.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by LeeDaebeom-Mac on 2016. 9. 18..
 */
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/api/item", method = RequestMethod.POST)
    public Item addItem(@RequestBody Item item) {
        return itemService.saveItem(item);
    }

    @RequestMapping(value = "/api/item/{id}", method = RequestMethod.DELETE)
    public void removeItem(@PathVariable Long id) {
        itemService.removeItem(id);
    }

}
