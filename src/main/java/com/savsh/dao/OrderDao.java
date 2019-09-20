package com.savsh.dao;

import com.savsh.entity.Order;
import com.savsh.entity.OrderDetails;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderDao {

    private static List<Order> orders = new ArrayList<>();

    static {
        Order order = new Order();
        orders.add(order);
    }

    public Order getById(long id) {
        return orders.stream().filter(order -> order.getId() == id).collect(Collectors.toList()).get(0);
    }


    public void save(Order order) {
        orders.add(order);
    }

    public List<Order> getAll() {
        return orders;
    }
}
