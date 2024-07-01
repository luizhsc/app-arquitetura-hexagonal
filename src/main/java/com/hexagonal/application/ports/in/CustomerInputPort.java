package com.hexagonal.application.ports.in;

import com.hexagonal.application.core.domain.Customer;

public interface CustomerInputPort {

    void insert(Customer customer, String zipCode);

    Customer findById(String id);

    void update(Customer customer, String zipCode);

    void delete(String id);

}
