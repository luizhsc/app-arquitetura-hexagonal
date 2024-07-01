package com.hexagonal.adapters.out;

import com.hexagonal.adapters.out.client.AddressClient;
import com.hexagonal.application.core.domain.Address;
import com.hexagonal.application.ports.out.AddressOutputPort;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddressAdapter implements AddressOutputPort {

    private final AddressClient addressClient;

    private final ModelMapper modelMapper;

    @Override
    public Address findAddressByZipCode(String zipCode) {
        var addressResponse = addressClient.findAddress(zipCode);
        return modelMapper.map(addressResponse, Address.class);
    }

}
