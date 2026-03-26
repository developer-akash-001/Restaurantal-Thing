package com.example.FoodApplicationBackend.auth.controller;


import com.example.FoodApplicationBackend.auth.dto.AuthResponse;
import com.example.FoodApplicationBackend.auth.dto.LoginRequest;
import com.example.FoodApplicationBackend.auth.dto.OtpVerifyRequest;
import com.example.FoodApplicationBackend.auth.dto.RegisterRequest;
import com.example.FoodApplicationBackend.auth.service.AuthService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Data
@RequestMapping("/auth")
public class AuthController {

    private  final AuthService authService;

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
        String toekn = authService.verifyOtp(request);
        return new AuthResponse(toekn);
    }
}
