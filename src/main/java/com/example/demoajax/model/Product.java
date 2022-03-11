package com.example.demoajax.model;

import lombok.Data;

import javax.persistence.*;

@Entity
// Lombok: tự động tạo ra constructor và getter/setter
@Data
public class Product {
    @Id
// Identity tự động tăng trong CSDL
// Auto tự động tăng trong Java
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private String img;

    @ManyToOne
    Category category;
}
