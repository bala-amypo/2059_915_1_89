package com.example.demo.util;

import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Category;
import com.example.demo.model.Invoice;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class InvoiceCategorizationEngine {

    // ✅ THIS METHOD SIGNATURE MUST MATCH TESTS EXACTLY
    public Category determineCategory(
            Invoice invoice,
            List<CategorizationRule> rules
    ) {
        if (invoice == null || rules == null || rules.isEmpty()) {
            return null;
        }

        String description = invoice.getDescription();
        if (description == null) {
            return null;
        }

        return rules.stream()
                .sorted(Comparator.comparing(CategorizationRule::getPriority).reversed())
                .filter(rule -> matches(description, rule))
                .map(CategorizationRule::getCategory)
                .findFirst()
                .orElse(null);
    }

    private boolean matches(String description, CategorizationRule rule) {
        if (rule.getKeyword() == null || rule.getMatchType() == null) {
            return false;
        }

        return switch (rule.getMatchType()) {
            case "EXACT" -> description.equalsIgnoreCase(rule.getKeyword());
            case "CONTAINS" -> description.toLowerCase()
                    .contains(rule.getKeyword().toLowerCase());
            case "REGEX" -> description.matches(rule.getKeyword());
            default -> false;
        };
    }
}
