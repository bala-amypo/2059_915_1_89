package com.example.demo.util;

import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Invoice;

import java.util.List;

public class InvoiceCategorizationEngine {

    // ⭐ REQUIRED BY TESTS
    public String determineCategory(
            Invoice invoice,
            List<CategorizationRule> rules
    ) {
        if (invoice == null || invoice.getDescription() == null) {
            return null;
        }

        String description = invoice.getDescription().toLowerCase();

        for (CategorizationRule rule : rules) {
            if (rule.getKeyword() != null &&
                description.contains(rule.getKeyword().toLowerCase())) {

                if (rule.getCategory() != null) {
                    return rule.getCategory().getCategoryName();
                }
            }
        }

        return null;
    }
}
