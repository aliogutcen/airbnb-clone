package com.ogutcenali.dto.request;

import lombok.*;

import javax.validation.constraints.Email;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegisterRequest {


    private String email;
    private String password;
}
