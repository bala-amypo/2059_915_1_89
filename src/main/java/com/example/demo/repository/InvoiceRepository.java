package com.example.demo.repository;

import com.example.demo.model.Invoice;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    List<Invoice> findByUploadedBy(User user);

    // HQL-based method (mocked in tests, no implementation needed)
    List<Invoice> findByAmountGreaterThanHql(Double amount);
}
