package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
    uniqueConstraints = @UniqueConstraint(columnNames = {"vendor_id", "invoiceNumber"})
)
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String invoiceNumber;
    private Double amount;
    private String description;
    private LocalDate invoiceDate;
    private LocalDateTime uploadedAt;

    @ManyToOne
    private Vendor vendor;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User uploadedBy;

    @PrePersist
    public void prePersist() {
        uploadedAt = LocalDateTime.now();
    }

    // getters & setters
    public Long getId() { return id; }
    public String getInvoiceNumber() { return invoiceNumber; }
    public Double getAmount() { return amount; }
    public String getDescription() { return description; }
    public LocalDate getInvoiceDate() { return invoiceDate; }
    public Vendor getVendor() { return vendor; }
    public Category getCategory() { return category; }
    public User getUploadedBy() { return uploadedBy; }
    public LocalDateTime getUploadedAt() { return uploadedAt; }

    public void setId(Long id) { this.id = id; }
    public void setInvoiceNumber(String invoiceNumber) { this.invoiceNumber = invoiceNumber; }
    public void setAmount(Double amount) { this.amount = amount; }
    public void setDescription(String description) { this.description = description; }
    public void setInvoiceDate(LocalDate invoiceDate) { this.invoiceDate = invoiceDate; }
    public void setVendor(Vendor vendor) { this.vendor = vendor; }
    public void setCategory(Category category) { this.category = category; }
    public void setUploadedBy(User uploadedBy) { this.uploadedBy = uploadedBy; }
}
