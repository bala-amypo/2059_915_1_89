package com.example.demo.controller;

import com.example.demo.model.Vendor;
import com.example.demo.service.impl.VendorServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
@CrossOrigin(origins = "*") // ✅ FIX: allows Swagger & browser calls
public class VendorController {

    private final VendorServiceImpl vendorService;

    public VendorController(VendorServiceImpl vendorService) {
        this.vendorService = vendorService;
    }

    // ✅ POST - create vendor
    @PostMapping
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorService.createVendor(vendor);
    }

    // ✅ GET - fetch all vendors (Swagger needs this)
    @GetMapping
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }
}
