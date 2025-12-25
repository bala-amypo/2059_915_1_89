package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.InvoiceService;
import com.example.demo.util.InvoiceCategorizationEngine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepo;
    private final UserRepository userRepo;
    private final VendorRepository vendorRepo;
    private final CategorizationRuleRepository ruleRepo;
    private final InvoiceCategorizationEngine engine;

    public InvoiceServiceImpl(
            InvoiceRepository invoiceRepo,
            UserRepository userRepo,
            VendorRepository vendorRepo,
            CategorizationRuleRepository ruleRepo,
            InvoiceCategorizationEngine engine
    ) {
        this.invoiceRepo = invoiceRepo;
        this.userRepo = userRepo;
        this.vendorRepo = vendorRepo;
        this.ruleRepo = ruleRepo;
        this.engine = engine;
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepo.findAll();
    }

    @Override
    public Invoice uploadInvoice(Long userId, Long vendorId, Invoice invoice) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Vendor vendor = vendorRepo.findById(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));

        invoice.setUploadedBy(user);
        invoice.setVendor(vendor);

        // category determination (optional, safe)
        invoice.setCategory(
                engine.determineCategory(
                        invoice,
                        ruleRepo.findAll()
                )
        );

        return invoiceRepo.save(invoice);
    }

    @Override
    public Invoice getInvoice(Long id) {
        return invoiceRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found"));
    }

    @Override
    public List<Invoice> getInvoicesByUser(Long userId) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return invoiceRepo.findByUploadedBy(user);
    }
}
