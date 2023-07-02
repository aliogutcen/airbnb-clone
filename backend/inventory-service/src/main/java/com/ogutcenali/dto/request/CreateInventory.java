package com.ogutcenali.dto.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateInventory {

    private Long authId;
    private Long categoryId;

    private String location;

    private Integer guestCount;

    private Integer roomCount;

    private Integer bathroomCount;

    private String imageSrc;

    private Double price;

    private String title;

    private String desc;
}
