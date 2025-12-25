package com.example.demo.model;

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

    private String fullName;

    @Column(nullable = false)
    private String email;

    private String password;

    private String role = "USER";

    private LocalDateTime createdAt;

    @ManyToMany
    @JoinTable(
        name = "user_favorite_vendors",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "vendor_id")
    )
    private Set<Vendor> favoriteVendors = new HashSet<>();

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    // getters & setters
}
