package com.example.demo.repository;

import com.example.demo.entity.Vendor;

public interface VendorRepository {
    Vendor findById(Long id);
    Vendor save(Vendor vendor);
}
