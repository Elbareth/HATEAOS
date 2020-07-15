package com.example.hateoas.contoller;

import com.example.hateoas.entity.Customer;
import com.example.hateoas.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/{id}", produces = "application/hal+json")
    public Customer findById(@PathVariable Integer id){
        Link link = linkTo(CustomerController.class).slash(id).withSelfRel();
        Customer customer = customerService.findById(id);
        customer.add(link);
        return customer;
    }
    @GetMapping(produces = "application/hal+json")
    public CollectionModel<Customer> findAll(){
        List<Customer> customers = customerService.findAll();
        Link link = linkTo(CustomerController.class).withSelfRel(); // możliwość dodania metod kontolera
        CollectionModel<Customer> cust = new CollectionModel<>(customers, link);
        return cust;
    }
}
