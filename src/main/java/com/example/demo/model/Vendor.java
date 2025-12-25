package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
    name = "vendors",
    uniqueConstraints = @UniqueConstraint(columnNames = "vendorName")
)
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vendorName;
    private String contactEmail;
    private String address;
    private LocalDateTime createdAt;

    @ManyToMany(mappedBy = "favoriteVendors")
    private Set<User> users = new HashSet<>();

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    // getters & setters
}
