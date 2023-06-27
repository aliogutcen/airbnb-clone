package com.ogutcenali.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    private String exchangeAuthCustomer = "exchange-auth-customer";
    private String keyAuthCustomer = "key-auth-customer";
    private String quequeAuthCustomer = "queque-auth-customer";


    @Bean
    DirectExchange directExchangeAuthCustomer() {
        return new DirectExchange(exchangeAuthCustomer);
    }

    @Bean
    Queue queueAuthCustomer() {
        return new Queue(quequeAuthCustomer);
    }

    @Bean
    Binding bindingAuthCustomer(DirectExchange directExchangeAuthCustomer, Queue queueAuthCustomer) {
        return BindingBuilder.bind(queueAuthCustomer).to(directExchangeAuthCustomer).with(keyAuthCustomer);
    }
}
