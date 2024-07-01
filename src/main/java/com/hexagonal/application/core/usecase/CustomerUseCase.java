package com.hexagonal.application.core.usecase;

import com.hexagonal.application.core.domain.Customer;
import com.hexagonal.application.ports.in.CustomerInputPort;
import com.hexagonal.application.ports.out.AddressOutputPort;
import com.hexagonal.application.ports.out.CustomerOutputPort;
import com.hexagonal.application.ports.out.SendCpfValidationOutputPort;

public class CustomerUseCase implements CustomerInputPort {

    private final AddressOutputPort addressOutputPort;

    private final CustomerOutputPort customerOutputPort;

    private final SendCpfValidationOutputPort sendCpfValidationOutputPort;

    public CustomerUseCase(AddressOutputPort addressOutputPort, CustomerOutputPort customerOutputPort, SendCpfValidationOutputPort sendCpfValidationOutputPort) {
        this.addressOutputPort = addressOutputPort;
        this.customerOutputPort = customerOutputPort;
        this.sendCpfValidationOutputPort = sendCpfValidationOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = addressOutputPort.findAddressByZipCode(zipCode);
        customer.setAddress(address);
        customerOutputPort.insertCustomer(customer);
        sendCpfValidationOutputPort.send(customer.getCpf());
    }

    @Override
    public Customer findById(String id) {
        return customerOutputPort.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @Override
    public void update(Customer customer, String zipCode) {
        findById(customer.getId());
        var address = addressOutputPort.findAddressByZipCode(zipCode);
        customer.setAddress(address);
        customerOutputPort.update(customer);
    }

    @Override
    public void delete(String id) {
        findById(id);
        customerOutputPort.delete(id);
    }

}
