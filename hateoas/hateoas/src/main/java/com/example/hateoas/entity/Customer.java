package com.example.hateoas.entity;

import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;

public class Customer extends RepresentationModel<Customer> {
    private Integer id;
    private String name;
    private String company;

    public Customer(Integer id, String name, String company) {
        this.id = id;
        this.name = name;
        this.company = company;
    }

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id.equals(customer.id) &&
                name.equals(customer.name) &&
                company.equals(customer.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, company);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
