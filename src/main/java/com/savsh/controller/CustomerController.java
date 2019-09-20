package com.savsh.controller;

import com.savsh.entity.Customer;
import com.savsh.entity.Item;
import com.savsh.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable long id) {
        return customerService.getById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Customer getCustomers(@RequestParam String firstName, @RequestParam String lastName) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        return customerService.createCustomer(customer);
    }

    @RequestMapping(value = "/{id}/busket", method = RequestMethod.GET)
    public List<Item> getItemsFromBusket(@PathVariable("id") long id) {
        return customerService.getById(id).getBusket().getItems();
    }

    @RequestMapping(value = "/{id}/favorite", method = RequestMethod.GET)
    public List<Item> getItemsFromFavorite(@PathVariable("id") long id) {
        return customerService.getById(id).getFavorite().getItems();
    }

}
