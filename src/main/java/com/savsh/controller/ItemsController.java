package com.savsh.controller;

import com.savsh.entity.Item;
import com.savsh.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/product")
public class ItemsController {
    private static final Logger LOGGER = Logger.getLogger(ItemsController.class.getSimpleName());


    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Item getItem(@PathVariable("id") long id) {
        return itemService.getById(id);
    }

    @RequestMapping(value = "bysku/{sku}", method = RequestMethod.GET)
    public Item getItemBySku(@PathVariable("sku") String sku) {
        return itemService.getBySku(sku);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Item> getItems() {
        LOGGER.log(Level.INFO, "get all products");
        return itemService.getItems();
    }

}
