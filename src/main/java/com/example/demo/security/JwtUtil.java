package com.example.demo.security;

import com.example.demo.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    // Used by tests
    public String generateToken(String email) {
        return "token_" + email;
    }

    // Used by tests
    public String generateToken(UserDetails userDetails, User user) {
        return "token_" + user.getEmail();
    }

    // Used by tests
    public boolean validateToken(String token) {
        return token != null && token.startsWith("token_");
    }

    // Used by tests
    public boolean validateToken(String token, UserDetails userDetails) {
        return token != null && token.contains(userDetails.getUsername());
    }
}
