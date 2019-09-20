package com.savsh.dao;

import com.savsh.entity.Favorite;
import com.savsh.entity.OrderDetails;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDetailsDao {
    private static List<OrderDetails> orderDetails = new ArrayList<>();

    public void save(OrderDetails orderDetails) {
        OrderDetailsDao.orderDetails.add(orderDetails);
    }

    public List<OrderDetails> getAll() {
        return orderDetails;
    }
}
