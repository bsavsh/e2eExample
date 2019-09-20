package com.savsh.service;

import com.savsh.dao.OrderDetailsDao;
import com.savsh.entity.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailsService {

    @Autowired
    private OrderDetailsDao orderDetailsDao;

    public List<OrderDetails> getOrderDetailsByCustomerId(long customerId) {
        System.out.println("hello");
        return orderDetailsDao.getAll()
                .stream()
                .filter(orderDetails -> orderDetails.getCustomer().getId() == customerId)
                .collect(Collectors.toList());
    }
}
