package com.example.demo.util;

import com.example.demo.model.Invoice;
import com.example.demo.model.CategorizationRule;

import java.util.List;

public class InvoiceCategorizationEngine {

    /**
     * THIS method is REQUIRED by tests
     */
    public String determineCategory(
            Invoice invoice,
            List<CategorizationRule> rules
    ) {
        if (invoice == null || rules == null) {
            return "Uncategorized";
        }

        String description = invoice.getDescription();
        if (description == null) {
            return "Uncategorized";
        }

        for (CategorizationRule rule : rules) {
            if (rule.getKeyword() != null &&
                description.toLowerCase().contains(rule.getKeyword().toLowerCase())) {
                return rule.getCategory();
            }
        }

        return "Uncategorized";
    }
}
