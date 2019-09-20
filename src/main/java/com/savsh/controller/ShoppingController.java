package com.savsh.controller;

import com.savsh.entity.Busket;
import com.savsh.entity.Order;
import com.savsh.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {

    @Autowired
    private ShoppingService shoppingService;

    @RequestMapping(value = "/favorite/user/{customerId}/item/{itemId}", method = RequestMethod.POST)
    public void putItemInFavorite(@PathVariable long customerId, @PathVariable long itemId) {
        shoppingService.addFavoriteForUser(itemId, customerId);
    }

    @RequestMapping(value = "/busket/user/{customerId}/item/{itemId}", method = RequestMethod.POST)
    public void putItemInBusket(@PathVariable long customerId, @PathVariable long itemId) {
        shoppingService.addItemInBusket(itemId, customerId);
    }

    @RequestMapping(value = "/user/{customerId}/item/{itemId}/order", method = RequestMethod.POST)
    public void buyOrder(@PathVariable long customerId, @PathVariable long itemId) {
        shoppingService.buyOrder(customerId, itemId);
    }

}
