package com.example.FoodApplicationBackend.auth.service;

import com.example.FoodApplicationBackend.auth.util.OtpGenerator;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OtpService {
    private Map<String, String> otpStorage = new HashMap<>();
    public String generateOtp(String mobile) {
        String otp = OtpGenerator.generateOtp();
        otpStorage.put(mobile, otp);
        System.out.println("Generated OTP for " + mobile + ": " + otp); // Simulate sending OTP
        return otp;
    }
    public boolean verifyOtp(String mobile, String otp) {
        return otp.equals(otpStorage.get(mobile));

    }
}
