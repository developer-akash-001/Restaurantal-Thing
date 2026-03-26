package com.example.FoodApplicationBackend.auth.service;

import com.example.FoodApplicationBackend.auth.config.JwtUtil;
import com.example.FoodApplicationBackend.auth.dto.LoginRequest;
import com.example.FoodApplicationBackend.auth.dto.OtpVerifyRequest;
import com.example.FoodApplicationBackend.auth.dto.RegisterRequest;
import com.example.FoodApplicationBackend.auth.entity.User;
import com.example.FoodApplicationBackend.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final OtpService otpService;
    private final UserRepository userRepository;  // ✅ FIXED
    private final JwtUtil jwtUtil;

    public void register(RegisterRequest request){
        User user = new User();
        user.setUsername(request.getName());
        user.setMobile(request.getMobile());
        user.setRole(request.getRole());
        user.setVerified(false);

        userRepository.save(user);   // ✅ WORKING
    }

    public void sendOtp(LoginRequest request){
        otpService.generateOtp(request.getMobile());
    }

    public String verifyOtp(OtpVerifyRequest request){

        User user = userRepository.findByMobile(request.getMobile())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(!otpService.verifyOtp(request.getMobile(), request.getOtp())){
            throw new RuntimeException("Invalid OTP");
        }

        user.setVerified(true);
        userRepository.save(user);

        return jwtUtil.generateToken(user.getMobile(), user.getRole().name());
    }
}