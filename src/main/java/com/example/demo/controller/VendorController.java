package com.example.demo.controller;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;


import com.example.demo.model.Vendor;
import com.example.demo.service.impl.VendorServiceImpl;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    private final VendorServiceImpl vendorService;

    public VendorController(VendorServiceImpl vendorService) {
        this.vendorService = vendorService;
    }

    
    @GetMapping
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    
    @GetMapping("/test")
    public String testVendorApi() {
        return "Vendor API is running successfully";
    }

    
    @PostMapping
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorService.createVendor(vendor);
    }

    
    @GetMapping("/post-test")
    public Vendor createVendorUsingGet() {
        Vendor vendor = new Vendor("Amazon");
        return vendorService.createVendor(vendor);
    }
}
