package com.example.demo.dto;

public class AuthResponse {

    private Long userId;
    private String email;
    private String role;
    private String token;

    // ✅ REQUIRED: no-args constructor
    public AuthResponse() {
    }

    // ✅ REQUIRED BY TESTS
    public AuthResponse(Long userId, String email, String role, String token) {
        this.userId = userId;
        this.email = email;
        this.role = role;
        this.token = token;
    }

    // ✅ REQUIRED GETTERS (tests call these)
    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getToken() {
        return token;
    }

    // setters (safe to keep)
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
