package com.example.demo.controller;

import com.example.demo.model.Vendor;
import com.example.demo.service.impl.VendorServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
@CrossOrigin(origins = "*") // ✅ helps Swagger
public class VendorController {

    private final VendorServiceImpl vendorService;

    public VendorController(VendorServiceImpl vendorService) {
        this.vendorService = vendorService;
    }

    // ✅ GET all vendors
    @GetMapping(produces = "application/json")
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    // ✅ CREATE vendor (POST must include body!)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorService.createVendor(vendor);
    }
}
