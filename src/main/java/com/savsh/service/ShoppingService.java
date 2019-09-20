package com.savsh.service;

import com.savsh.dao.*;
import com.savsh.entity.Customer;
import com.savsh.entity.Item;
import com.savsh.entity.Order;
import com.savsh.entity.OrderDetails;
import com.savsh.utils.IdGeneratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

import static com.savsh.utils.IdGeneratorUtils.nextId;

@Service
public class ShoppingService {

    @Autowired
    private FavoriteDao favoriteDao;

    @Autowired
    private BusketDao busketDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderDetailsDao orderDetailsDao;

    @Autowired
    private ItemDao itemDao;

    public void addFavoriteForUser(long itemId, long customerId) {
        favoriteDao.addItemForUser(itemId, customerId);
    }

    public void addItemInBusket(long itemId, long customerId) {
        busketDao.addItemForUser(itemId, customerId);
    }

    public void buyOrder(long customerId, long itemId) {
        Item item = itemDao.getById(itemId);
        Order order = new Order();
        order.setId(nextId());
        order.setItems(Collections.singletonList(item));
        order.setTotalCost(item.getCost().add(item.getShippingCost()));

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setId(nextId());
        Customer customer = customerDao.getById(customerId);
        orderDetails.setCustomer(customer);
        orderDetails.setOrder(order);

        orderDao.save(order);
        orderDetailsDao.save(orderDetails);
    }
}
