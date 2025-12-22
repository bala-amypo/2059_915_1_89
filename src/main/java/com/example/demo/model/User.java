package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
    name = "users",
    uniqueConstraints = @UniqueConstraint(columnNames = "email")
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    // 🔒 NEVER expose password in API response
    @JsonIgnore
    private String password;

    private String role;

    private LocalDateTime createdAt;

    // 🚫 FIX lazy loading JSON error
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Vendor> favoriteVendors = new HashSet<>();

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // -------- Getters & Setters --------

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    // password getter optional (used internally only)
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // 🚫 Do NOT serialize favoriteVendors
    public Set<Vendor> getFavoriteVendors() {
        return favoriteVendors;
    }
}
