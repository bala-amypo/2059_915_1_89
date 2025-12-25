package com.example.demo.util;

import com.example.demo.model.Category;
import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Invoice;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InvoiceCategorizationEngine {

    public Category determineCategory(
            Invoice invoice,
            List<CategorizationRule> rules
    ) {
        if (invoice == null || rules == null) {
            return null;
        }

        for (CategorizationRule rule : rules) {
            if (invoice.getDescription() != null &&
                rule.getKeyword() != null &&
                invoice.getDescription()
                        .toLowerCase()
                        .contains(rule.getKeyword().toLowerCase())) {

                return rule.getCategory();
            }
        }
        return null;
    }
}
