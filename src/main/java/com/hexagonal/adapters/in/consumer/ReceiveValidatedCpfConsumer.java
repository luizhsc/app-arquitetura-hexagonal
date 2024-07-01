package com.hexagonal.adapters.in.consumer;

import com.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.hexagonal.application.core.domain.Customer;
import com.hexagonal.application.ports.in.CustomerInputPort;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReceiveValidatedCpfConsumer {

    private final CustomerInputPort customerInputPort;

    private ModelMapper modelMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "hexagonal")
    public void receive(CustomerMessage customerMessage) {
        var customer = modelMapper.map(customerMessage, Customer.class);
        customerInputPort.update(customer, customerMessage.getZipCode());
    }
}
