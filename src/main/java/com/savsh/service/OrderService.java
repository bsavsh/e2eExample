package com.savsh.service;

import com.savsh.dao.OrderDao;
import com.savsh.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    public Order getById(long id) {
        return orderDao.getById(id);
    }

    public List<Order> getAll() {
        return orderDao.getAll();
    }
}
