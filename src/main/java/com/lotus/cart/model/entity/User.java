package com.lotus.cart.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 5, max = 16, message = "User name must be between 5 and 16 characters long")
    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String email;

    @Builder.Default
    @Column
    private Date createdAt = Date.from(Instant.now());

    @Builder.Default
    @OneToMany(fetch = FetchType.EAGER)
    private List<Product> products = new ArrayList<>();

}
