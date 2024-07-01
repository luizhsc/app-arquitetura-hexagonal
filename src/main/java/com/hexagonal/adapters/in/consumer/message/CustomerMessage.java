package com.hexagonal.adapters.in.consumer.message;

import com.hexagonal.application.core.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerMessage {

    private String id;

    private String name;

    private String zipCode;

    private Address address;

    private String cpf;

    private Boolean isValidCpf;

}
