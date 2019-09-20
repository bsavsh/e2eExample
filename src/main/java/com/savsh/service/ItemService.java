package com.savsh.service;

import com.savsh.dao.ItemDao;
import com.savsh.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemDao itemDao;

    public Item getById(long id) {
        return itemDao.getById(id);
    }

    public List<Item> getItems() {
        return itemDao.getProducts();
    }

    public Item getBySku(String sku) {
        return itemDao.getBySku(sku);
    }
}
