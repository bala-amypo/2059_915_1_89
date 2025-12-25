package com.example.demo.util;

import com.example.demo.model.*;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component   // ⭐ VERY IMPORTANT
public class InvoiceCategorizationEngine {

    public Category determineCategory(Invoice invoice,
                                      List<CategorizationRule> rules) {

        if (invoice == null || rules == null || rules.isEmpty()) {
            return null;
        }

        return rules.stream()
                .sorted(Comparator.comparing(CategorizationRule::getPriority).reversed())
                .filter(rule -> match(invoice.getDescription(), rule))
                .map(CategorizationRule::getCategory)
                .findFirst()
                .orElse(null);
    }

    private boolean match(String description, CategorizationRule rule) {
        if (description == null || rule.getKeyword() == null) return false;

        return switch (rule.getMatchType()) {
            case "EXACT" -> description.equals(rule.getKeyword());
            case "CONTAINS" -> description.toLowerCase()
                    .contains(rule.getKeyword().toLowerCase());
            case "REGEX" -> description.matches(rule.getKeyword());
            default -> false;
        };
    }
}
