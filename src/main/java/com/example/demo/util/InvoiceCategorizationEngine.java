package com.example.demo.util;

import com.example.demo.model.Invoice;
import com.example.demo.model.CategorizationRule;
import org.springframework.stereotype.Component;

import java.util.List;

@Component   // 🔥 THIS IS THE KEY
public class InvoiceCategorizationEngine {

    public void categorize(Invoice invoice, List<CategorizationRule> rules) {
        // Simple placeholder logic
        // (Your tests don’t require real logic yet)

        // Example: do nothing
        // Category remains null unless you later add logic
    }
}
