package com.ogutcenali.dto.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateProfileRequest {

    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String governmentId;

    private String nationality;
}
