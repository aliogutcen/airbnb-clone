package com.ogutcenali.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tbl_inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
