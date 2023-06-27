package com.ogutcenali.rabbitmq.producer;

import com.ogutcenali.rabbitmq.model.CreateCustomer;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthProducer {

    private final RabbitTemplate rabbitTemplate;

    public void createCustomer(CreateCustomer customer) {
        rabbitTemplate.convertAndSend("exchange-auth-customer", "key-auth-customer", customer);
    }
}
