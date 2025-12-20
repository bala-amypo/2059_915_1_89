package com.example.demo.service;

import com.example.demo.model.CategorizationRule;

import java.util.List;

public interface CategorizationRuleService {

    // Create rule
    CategorizationRule createRule(CategorizationRule rule);

    // Get rules matching invoice description
    List<CategorizationRule> findMatchingRules(String description);
}
