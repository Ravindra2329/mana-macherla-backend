package com.manamacherla.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Setter
@Getter
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String ownerName;
    private String shopName;
    private String phone;
    private String whatsapp;
    private String address;
    private String area;
    private LocalTime openTime;
    private LocalTime closeTime;
    private String photoUrl;
    private Boolean status = true;

    @ManyToOne
    private Category category;


    // getters & setters
}
