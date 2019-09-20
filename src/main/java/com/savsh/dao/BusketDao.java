package com.savsh.dao;

import com.savsh.entity.Busket;
import com.savsh.entity.Customer;
import com.savsh.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class BusketDao {
    private static final Logger LOGGER = Logger.getLogger(BusketDao.class.getSimpleName());

    private static List<Busket> buskets = new ArrayList<>();

    public static Busket getBusket() {
        Busket busket = new Busket();
        buskets.add(busket);
        return busket;
    }

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private ItemDao itemDao;

    public void addItemForUser(long itemId, long customerId) {
        Customer customer = customerDao.getById(customerId);
        Item item = itemDao.getById(itemId);
        customer.getBusket().addItem(item);
        LOGGER.log(Level.INFO, "add to busket item: " + itemId + " to customer: " + customerId);
    }
}
