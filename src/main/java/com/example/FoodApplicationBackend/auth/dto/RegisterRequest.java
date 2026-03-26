package com.example.FoodApplicationBackend.auth.dto;

import com.example.FoodApplicationBackend.auth.entity.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String mobile;
    private Role role;
}
