package com.example.demo.util;

import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Invoice;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class InvoiceCategorizationEngine {

    public String determineCategory(
            Invoice invoice,
            List<CategorizationRule> rules
    ) {
        if (invoice == null || rules == null || rules.isEmpty()) {
            return null;
        }

        return rules.stream()
                .sorted(Comparator.comparing(CategorizationRule::getPriority).reversed())
                .filter(rule ->
                        invoice.getDescription() != null &&
                        rule.getKeyword() != null &&
                        invoice.getDescription().toLowerCase()
                                .contains(rule.getKeyword().toLowerCase())
                )
                .map(CategorizationRule::getCategoryName)
                .findFirst()
                .orElse(null);
    }
}
