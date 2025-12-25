package com.example.demo.service.impl;

import com.example.demo.model.Invoice;
import com.example.demo.model.User;
import com.example.demo.model.Vendor;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepo;
    private final UserRepository userRepo;
    private final VendorRepository vendorRepo;

    // ✅ REQUIRED BY TESTS
    public InvoiceServiceImpl(
            InvoiceRepository invoiceRepo,
            UserRepository userRepo,
            VendorRepository vendorRepo
    ) {
        this.invoiceRepo = invoiceRepo;
        this.userRepo = userRepo;
        this.vendorRepo = vendorRepo;
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepo.findAll();
    }

    @Override
    public Invoice uploadInvoice(Long userId, Long vendorId, Invoice invoice) {
        User user = userRepo.findById(userId).orElseThrow();
        Vendor vendor = vendorRepo.findById(vendorId).orElseThrow();

        invoice.setUploadedBy(user);
        invoice.setVendor(vendor);

        return invoiceRepo.save(invoice);
    }

    @Override
    public Invoice getInvoice(Long id) {
        return invoiceRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Invoice> getInvoicesByUser(Long userId) {
        User user = userRepo.findById(userId).orElseThrow();
        return invoiceRepo.findByUploadedBy(user);
    }
}
