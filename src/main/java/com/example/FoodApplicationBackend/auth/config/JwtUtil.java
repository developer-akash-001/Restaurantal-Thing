package com.example.FoodApplicationBackend.auth.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private String SECRET = "mysecret";

    public String generateToken(String mobile, String role){
        return Jwts.builder()
                .setSubject(mobile)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 )) // Token valid for 10 hours
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }
}
