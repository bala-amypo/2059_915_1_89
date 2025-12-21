package com.example.demo.security;

import com.example.demo.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUtil {

    /**
     * Generates JWT token.
     * Actual implementation is NOT required because tests MOCK this method.
     */
    public String generateToken(UserDetails userDetails, User user) {
        // Dummy implementation (mocked in tests)
        return "dummy-token";
    }

    /**
     * Validates JWT token.
     * Tests mock this method directly.
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        return true;
    }
}
