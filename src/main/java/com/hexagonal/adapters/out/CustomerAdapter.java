package com.hexagonal.adapters.out;

import com.hexagonal.adapters.out.repository.CustomerRepository;
import com.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.hexagonal.application.core.domain.Customer;
import com.hexagonal.application.ports.out.CustomerOutputPort;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class CustomerAdapter implements CustomerOutputPort {

    private final CustomerRepository customerRepository;

    private final ModelMapper modelMapper;

    @Override
    public void insertCustomer(Customer customer) {
        var customerEntity = modelMapper.map(customer, CustomerEntity.class);
        customerRepository.save(customerEntity);
    }

    @Override
    public Optional<Customer> findById(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> modelMapper.map(entity, Customer.class));
    }

    @Override
    public void update(Customer customer) {
        var customerEntity = modelMapper.map(customer, CustomerEntity.class);
        customerRepository.save(customerEntity);
    }

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
