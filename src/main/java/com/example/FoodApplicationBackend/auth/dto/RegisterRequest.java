package com.example.FoodApplicationBackend.auth.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String mobile;
    private String role;
}