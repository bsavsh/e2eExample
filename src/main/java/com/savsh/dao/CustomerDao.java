package com.savsh.dao;

import com.savsh.entity.Busket;
import com.savsh.entity.Customer;
import com.savsh.entity.Favorite;
import com.savsh.utils.IdGeneratorUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Repository
public class CustomerDao {
    private static final Logger LOGGER = Logger.getLogger(CustomerDao.class.getSimpleName());

    private static List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer());
    }

    public Customer getById(long id) {
        return customers.stream().filter(customer -> customer.getId() == id).collect(Collectors.toList()).get(0);
    }


    public List<Customer> getCustomers() {
        return customers;
    }

    public Customer createCustomer(Customer customer) {
        customer.setId(IdGeneratorUtils.nextId());
        Favorite favorite = new Favorite();
        favorite.setId(IdGeneratorUtils.nextId());
        Busket busket = new Busket();
        busket.setId(IdGeneratorUtils.nextId());
        customer.setFavorite(favorite);
        customer.setBusket(busket);
        customers.add(customer);
        LOGGER.log(Level.INFO, "Customer was added, customerId: " + customer.getId());
        return customer;
    }
}
