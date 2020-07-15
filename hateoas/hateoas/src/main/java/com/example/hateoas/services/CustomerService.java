package com.example.hateoas.services;

import com.example.hateoas.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private static List<Customer> LIST_OF_CUSTOMERS = new ArrayList<>();

    public CustomerService(){
        LIST_OF_CUSTOMERS.add(new Customer(1, "Imie1","Firma1"));
        LIST_OF_CUSTOMERS.add(new Customer(2, "Imie2","Firma2"));
        LIST_OF_CUSTOMERS.add(new Customer(3, "Imie3","Firma3"));
        LIST_OF_CUSTOMERS.add(new Customer(4, "Imie4","Firma4"));
        LIST_OF_CUSTOMERS.add(new Customer(5, "Imie5","Firma5"));
        LIST_OF_CUSTOMERS.add(new Customer(6, "Imie6","Firma6"));
        LIST_OF_CUSTOMERS.add(new Customer(7, "Imie7","Firma7"));
        LIST_OF_CUSTOMERS.add(new Customer(8, "Imie8","Firma8"));
        LIST_OF_CUSTOMERS.add(new Customer(9, "Imie9","Firma9"));
    }

    public Customer findById(Integer id){
        for(Customer c : LIST_OF_CUSTOMERS){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }
    public List<Customer> findAll(){
        return LIST_OF_CUSTOMERS;
    }
}
