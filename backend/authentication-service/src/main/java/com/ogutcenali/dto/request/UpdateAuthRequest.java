package com.ogutcenali.dto.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateAuthRequest {

    private Long id;
    private String email;

    private String password;
}
