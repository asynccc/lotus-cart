package com.lotus.cart.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Product name cannot be null")
    @Column
    private String name;

    @NotNull(message = "Product name cannot be null")
    @NotBlank(message = "Product description cannot be blank")
    @Column
    private String description;

    @NotNull(message = "Product price cannot be null")
    private double price;

    @ManyToOne
    private User creator;
}
