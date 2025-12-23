package com.example.demo.controller;

// ✅ SPRING IMPORTS
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// ✅ JAVA IMPORT
import java.util.List;

// ✅ PROJECT IMPORTS
import com.example.demo.model.Vendor;
import com.example.demo.service.impl.VendorServiceImpl;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    private final VendorServiceImpl vendorService;

    public VendorController(VendorServiceImpl vendorService) {
        this.vendorService = vendorService;
    }

    // ✅ GET all vendors
    @GetMapping
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    // ✅ Health check
    @GetMapping("/test")
    public String testVendorApi() {
        return "Vendor API is running successfully";
    }

    // ❌ POST (blocked on amypo.ai, but correct code)
    @PostMapping
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorService.createVendor(vendor);
    }

    // ✅ DEMO endpoint to simulate POST using GET
    @GetMapping("/post-test")
    public Vendor createVendorUsingGet() {
        Vendor vendor = new Vendor("Amazon");
        return vendorService.createVendor(vendor);
    }
}
