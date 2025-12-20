package com.example.demo.service;

import com.example.demo.model.Invoice;

import java.util.List;

public interface InvoiceService {

    // Upload invoice
    Invoice uploadInvoice(Long userId, Long vendorId, Invoice invoice);

    // Get invoice by id
    Invoice getInvoice(Long invoiceId);

    // Get invoices by user
    List<Invoice> getInvoicesByUser(Long userId);
}
