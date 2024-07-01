package com.hexagonal.config;

import com.hexagonal.adapters.out.AddressAdapter;
import com.hexagonal.adapters.out.CustomerAdapter;
import com.hexagonal.adapters.out.SendCpfValidationAdapter;
import com.hexagonal.application.core.usecase.CustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Bean
    public CustomerUseCase customerUseCase(AddressAdapter addressAdapter, CustomerAdapter customerAdapter, SendCpfValidationAdapter sendCpfValidationAdapter) {
        return new CustomerUseCase(addressAdapter, customerAdapter, sendCpfValidationAdapter);
    }

}