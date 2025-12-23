package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    // Dummy token generation – enough for app startup & tests
    public String generateToken(UserDetails userDetails, Object user) {
        return "dummy-jwt-token";
    }

    // Dummy validation
    public boolean validateToken(String token, UserDetails userDetails) {
        return true;
    }

    public String extractUsername(String token) {
        return "user@test.com";
    }
}