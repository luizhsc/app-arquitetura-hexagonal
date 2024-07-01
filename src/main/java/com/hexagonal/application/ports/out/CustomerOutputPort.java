package com.hexagonal.application.ports.out;

import com.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface CustomerOutputPort {

    void insertCustomer(Customer customer);

    Optional<Customer> findById(String id);

    void update(Customer customer);

    void delete(String id);

}
