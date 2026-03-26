package com.example.FoodApplicationBackend.auth.util;

import java.util.Random;

public class OtpGenerator {
    public static String generateOtp() {
       return String.valueOf(new Random().nextInt(900000) + 100000); // Generates a 6-digit OTP
    }
}
