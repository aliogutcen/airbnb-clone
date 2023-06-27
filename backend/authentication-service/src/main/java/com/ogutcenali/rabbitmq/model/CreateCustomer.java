package com.ogutcenali.rabbitmq.model;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateCustomer implements Serializable {

    private Long authId;
    private String email;
}
