package com.example.demo.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vendorName;

    @ManyToMany(mappedBy = "favoriteVendors")
    private Set<User> users = new HashSet<>();

    public Long getId() { return id; }
    public String getVendorName() { return vendorName; }
    public Set<User> getUsers() { return users; }

    public void setId(Long id) { this.id = id; }
    public void setVendorName(String vendorName) { this.vendorName = vendorName; }
}
