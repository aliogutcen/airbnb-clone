package com.ogutcenali.rabbitmq.consumer;

import com.ogutcenali.rabbitmq.model.CreateCustomer;
import com.ogutcenali.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerConsumer {

    private final CustomerService customerService;

    @RabbitListener(queues = "queque-auth-customer")
    public void createCustomer(CreateCustomer createCustomer){
        customerService.createCustomer(createCustomer);
    }
}
