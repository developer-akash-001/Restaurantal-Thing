package com.example.FoodApplicationBackend.auth.service;

import com.example.FoodApplicationBackend.auth.dto.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class AuthService {

    private final Map<String, String> otpStore = new HashMap<>();
    private final Map<String, RegisterRequest> userStore = new HashMap<>();

    // Register user
    public void register(RegisterRequest request) {
        userStore.put(request.getMobile(), request);
    }

    // Send OTP
    public void sendOtp(LoginRequest request) {
        if (!userStore.containsKey(request.getMobile())) {
            throw new RuntimeException("User not registered");
        }
        String otp = String.valueOf(new Random().nextInt(899999) + 100000); // 6-digit OTP
        otpStore.put(request.getMobile(), otp);
        System.out.println("OTP for " + request.getMobile() + " is " + otp);
    }

    // Verify OTP
    public String verifyOtp(OtpVerifyRequest request) {
        String otp = otpStore.get(request.getMobile());
        if (otp == null || !otp.equals(request.getOtp())) {
            throw new RuntimeException("Invalid OTP");
        }
        otpStore.remove(request.getMobile());
        // generate fake token
        return "token_" + request.getMobile();
    }
}