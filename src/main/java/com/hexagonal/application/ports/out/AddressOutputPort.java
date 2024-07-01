package com.hexagonal.application.ports.out;

import com.hexagonal.application.core.domain.Address;

public interface AddressOutputPort {

    Address findAddressByZipCode(String zipCode);

}
