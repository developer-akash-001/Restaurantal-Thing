package com.example.FoodApplicationBackend.auth.controller;

import com.example.FoodApplicationBackend.auth.dto.*;
import com.example.FoodApplicationBackend.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request){
        authService.register(request);
        return "Register Successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){
        authService.sendOtp(request);
        return "OTP Sent";
    }

    @PostMapping("/verify")
    public AuthResponse verify(@RequestBody OtpVerifyRequest request){
        String token = authService.verifyOtp(request);
        return new AuthResponse(token);
    }
}