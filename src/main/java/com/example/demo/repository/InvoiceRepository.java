package com.example.demo.repository;

import com.example.demo.entity.Invoice;
import java.util.List;

public interface InvoiceRepository {
    Invoice save(Invoice invoice);
    Invoice findById(Long id);
    List<Invoice> findAll();
}
