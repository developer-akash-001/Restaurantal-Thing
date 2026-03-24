package com.example.FoodApplicationBackend.auth.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Column(unique = true)
    private String mobile;
    @Enumerated(EnumType.STRING)
    private Role role;
    private boolean verified;
}
