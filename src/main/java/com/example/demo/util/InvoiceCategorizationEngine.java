package com.example.demo.util;

import com.example.demo.model.Invoice;
import com.example.demo.model.CategorizationRule;

import java.util.List;

public class InvoiceCategorizationEngine {

    public String determineCategory(
            Invoice invoice,
            List<CategorizationRule> rules
    ) {
        if (rules == null || rules.isEmpty()) {
            return null;
        }

        String description = invoice.getDescription().toLowerCase();

        return rules.stream()
                .filter(r -> description.contains(r.getKeyword().toLowerCase()))
                .sorted((a, b) -> b.getPriority() - a.getPriority())
                .map(r -> r.getCategory().getCategoryName())
                .findFirst()
                .orElse(null);
    }
}
