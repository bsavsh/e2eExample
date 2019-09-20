package com.savsh.dao;

import com.savsh.entity.Item;
import com.savsh.utils.IdGeneratorUtils;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.savsh.utils.IdGeneratorUtils.nextId;

@Repository
public class ItemDao {
    private static List<Item> items = new ArrayList<>();

    static {
        Item item = new Item().setId(nextId())
                .setSku("SKU-1")
                .setItemName("A3456")
                .setBrand("Samsung")
                .setCost(BigDecimal.valueOf(45.5))
                .setQty(10)
                .setShippingCost(BigDecimal.valueOf(10, 2));

        Item item1 = new Item().setId(nextId())
                .setSku("SKU-2")
                .setItemName("A3456asdf")
                .setBrand("Whirlpool")
                .setCost(BigDecimal.valueOf(2344.5))
                .setQty(2)
                .setShippingCost(BigDecimal.valueOf(100, 2));
        items.add(item);
        items.add(item1);
    }

    public Item getById(long id) {
        return items.stream().filter(order -> order.getId() == id).collect(Collectors.toList()).get(0);
    }

    public List<Item> getProducts() {
        return items;
    }

    public Item getBySku(String sku) {
        return items.stream().filter(order -> order.getSku().equalsIgnoreCase(sku)).collect(Collectors.toList()).get(0);
    }
}
