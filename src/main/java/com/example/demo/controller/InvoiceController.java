package com.example.demo.controller;

import com.example.demo.model.Invoice;
import com.example.demo.service.impl.InvoiceServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
@CrossOrigin
public class InvoiceController {

    private final InvoiceServiceImpl invoiceService;

    public InvoiceController(InvoiceServiceImpl invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/upload")
    public Invoice uploadInvoice(
            @RequestParam Long userId,
            @RequestParam Long vendorId,
            @RequestBody Invoice invoice
    ) {
        return invoiceService.uploadInvoice(userId, vendorId, invoice);
    }

    @GetMapping("/{id}")
    public Invoice getInvoice(@PathVariable Long id) {
        return invoiceService.getInvoice(id);
    }

    @GetMapping("/user/{userId}")
    public List<Invoice> getInvoicesByUser(@PathVariable Long userId) {
        return invoiceService.getInvoicesByUser(userId);
    }
}
