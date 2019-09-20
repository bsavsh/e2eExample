package com.savsh.controller;

import com.savsh.entity.Customer;
import com.savsh.entity.Order;
import com.savsh.entity.OrderDetails;
import com.savsh.service.CustomerService;
import com.savsh.service.OrderDetailsService;
import com.savsh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController {
    private static final Logger LOGGER = Logger.getLogger(OrderController.class.getSimpleName());

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailsService orderDetailsService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Order getOrder(@PathVariable("id") long id) {
        LOGGER.log(Level.INFO, "getting order with id: " + id);
        return orderService.getById(id);
    }

    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET)
    public List<Order> getOrderByCustomerId(@PathVariable("customerId") long customerId) {
        return orderDetailsService.getOrderDetailsByCustomerId(customerId)
                .stream()
                .map(OrderDetails::getOrder)
                .collect(Collectors.toList());
    }

}
