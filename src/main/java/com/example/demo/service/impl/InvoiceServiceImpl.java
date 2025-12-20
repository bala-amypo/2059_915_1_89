package com.example.demo.service.impl;

import com.example.demo.entity.Invoice;
import com.example.demo.entity.User;
import com.example.demo.entity.Vendor;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.repository.CategorizationRuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl {

    private final InvoiceRepository invoiceRepository;
    private final UserRepository userRepository;
    private final VendorRepository vendorRepository;
    private final CategorizationRuleRepository ruleRepository;

    public InvoiceServiceImpl(
            InvoiceRepository invoiceRepository,
            UserRepository userRepository,
            VendorRepository vendorRepository,
            CategorizationRuleRepository ruleRepository) {

        this.invoiceRepository = invoiceRepository;
        this.userRepository = userRepository;
        this.vendorRepository = vendorRepository;
        this.ruleRepository = ruleRepository;
    }

    public Invoice createInvoice(Long userId, Long vendorId, Invoice invoice) {

        User user = userRepository.findById(userId);
        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        }

        Vendor vendor = vendorRepository.findById(vendorId);
        if (vendor == null) {
            throw new ResourceNotFoundException("Vendor not found");
        }

        return invoiceRepository.save(invoice);
    }

    public Invoice getInvoice(Long id) {
        Invoice invoice = invoiceRepository.findById(id);
        if (invoice == null) {
            throw new ResourceNotFoundException("Invoice not found");
        }
        return invoice;
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }
}
