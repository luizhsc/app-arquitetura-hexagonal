package com.hexagonal.adapters.out;

import com.hexagonal.application.ports.out.SendCpfValidationOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SendCpfValidationAdapter implements SendCpfValidationOutputPort {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String cpf) {
        kafkaTemplate.send("tp-cpf-validation", cpf);
    }
}
