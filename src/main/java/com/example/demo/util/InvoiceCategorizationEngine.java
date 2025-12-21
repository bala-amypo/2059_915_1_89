package com.example.demo.util;

import com.example.demo.model.Category;
import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Invoice;

import java.util.Comparator;
import java.util.List;

public class InvoiceCategorizationEngine {

    /**
     * Determines the best matching category for an invoice
     * based on provided categorization rules.
     *
     * Rules are matched by:
     *  - EXACT
     *  - CONTAINS
     *  - REGEX
     *
     * Highest priority rule wins.
     */
    public Category determineCategory(Invoice invoice,
                                      List<CategorizationRule> rules) {

        // Edge case: no rules
        if (rules == null || rules.isEmpty()) {
            return null;
        }

        return rules.stream()
                // highest priority first
                .sorted(Comparator.comparingInt(
                        CategorizationRule::getPriority).reversed())
                // apply matching logic
                .filter(rule -> matches(invoice.getDescription(), rule))
                // return matched category
                .map(CategorizationRule::getCategory)
                .findFirst()
                .orElse(null);
    }

    /**
     * Matching logic based on rule type.
     */
    private boolean matches(String description,
                            CategorizationRule rule) {

        if (description == null || rule.getKeyword() == null) {
            return false;
        }

        return switch (rule.getMatchType()) {

            case "EXACT" ->
                    description.equals(rule.getKeyword());

            case "CONTAINS" ->
                    description.toLowerCase()
                            .contains(rule.getKeyword().toLowerCase());

            case "REGEX" ->
                    description.matches(rule.getKeyword());

            default -> false;
        };
    }
}
