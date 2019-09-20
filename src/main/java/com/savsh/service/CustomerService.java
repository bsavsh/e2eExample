package com.savsh.service;

import com.savsh.dao.CustomerDao;
import com.savsh.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public Customer getById(long id) {
        return customerDao.getById(id);
    }

    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }

    public Customer createCustomer(Customer customer) {
        return customerDao.createCustomer(customer);
    }
}
