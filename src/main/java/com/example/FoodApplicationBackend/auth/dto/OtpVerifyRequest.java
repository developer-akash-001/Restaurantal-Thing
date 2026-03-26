package com.example.FoodApplicationBackend.auth.dto;

import lombok.Data;

@Data
public class OtpVerifyRequest {
    private String mobile;
    private String otp;
}
