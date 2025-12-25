package com.example.demo.util;

import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Category;
import com.example.demo.model.Invoice;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class InvoiceCategorizationEngine {

    public Category determineCategory(Invoice invoice,
                                      List<CategorizationRule> rules) {

        if (invoice == null || invoice.getDescription() == null ||
            rules == null || rules.isEmpty()) {
            return null;
        }

        return rules.stream()
                .filter(rule -> rule.getKeyword() != null && rule.getMatchType() != null)
                .sorted(Comparator.comparing(
                        CategorizationRule::getPriority,
                        Comparator.nullsLast(Integer::compareTo)
                ).reversed())
                .filter(rule -> matches(invoice.getDescription(), rule))
                .map(CategorizationRule::getCategory)
                .findFirst()
                .orElse(null);
    }

    private boolean matches(String description, CategorizationRule rule) {

        return switch (rule.getMatchType()) {
            case "EXACT" -> description.equalsIgnoreCase(rule.getKeyword());
            case "CONTAINS" -> description.toLowerCase()
                    .contains(rule.getKeyword().toLowerCase());
            case "REGEX" -> description.matches(rule.getKeyword());
            default -> false;
        };
    }
}
