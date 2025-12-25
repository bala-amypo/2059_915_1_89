package com.example.demo.util;

import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Invoice;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class InvoiceCategorizationEngine {

    // ✅ EXACT SIGNATURE EXPECTED BY TESTS
    public String determineCategory(
            Invoice invoice,
            List<CategorizationRule> rules
    ) {
        if (invoice == null || rules == null || rules.isEmpty()) {
            return null;
        }

        return rules.stream()
                .sorted(Comparator.comparing(CategorizationRule::getPriority).reversed())
                .filter(rule -> matches(invoice.getDescription(), rule))
                .map(CategorizationRule::getCategory) // returns String
                .findFirst()
                .orElse(null);
    }

    private boolean matches(String description, CategorizationRule rule) {
        if (description == null || rule.getKeyword() == null) return false;

        return switch (rule.getMatchType()) {
            case "EXACT" -> description.equals(rule.getKeyword());
            case "CONTAINS" -> description.toLowerCase().contains(rule.getKeyword().toLowerCase());
            case "REGEX" -> description.matches(rule.getKeyword());
            default -> false;
        };
    }
}
