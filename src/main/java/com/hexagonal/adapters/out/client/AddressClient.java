package com.hexagonal.adapters.out.client;

import com.hexagonal.adapters.out.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "AddressClient", url = "${client.address.url}")
public interface AddressClient {

    @GetMapping("/{zipCode}")
    AddressResponse findAddress(@PathVariable("zipCode") String zipCode);

}
