package com.example.FoodApplicationBackend.auth.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    @ManyToOne
    private User user;

    @ManyToOne
    private MenuItem menuItem;
}
