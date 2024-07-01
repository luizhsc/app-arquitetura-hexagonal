package com.hexagonal.adapters.in.controller;

import com.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.hexagonal.application.core.domain.Customer;
import com.hexagonal.application.ports.in.CustomerInputPort;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerInputPort customerInputPort;

    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest request) {
        var customer = modelMapper.map(request, Customer.class);
        customerInputPort.insert(customer, request.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerResponse> getById(@PathVariable String id) {
        var customer = customerInputPort.findById(id);
        var customerReponse = modelMapper.map(customer, CustomerResponse.class);
        return ResponseEntity.ok(customerReponse);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody CustomerRequest request) {
        var customer = modelMapper.map(request, Customer.class);
        customer.setId(id);
        customerInputPort.update(customer, request.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> delete(@PathVariable String id) {
        customerInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }

}
