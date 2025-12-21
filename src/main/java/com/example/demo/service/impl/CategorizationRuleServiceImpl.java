package com.example.demo.service.impl;

import com.example.demo.model.CategorizationRule;
import com.example.demo.repository.CategorizationRuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorizationRuleServiceImpl {

    private final CategorizationRuleRepository ruleRepository;

    public CategorizationRuleServiceImpl(CategorizationRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    public CategorizationRule createRule(CategorizationRule rule) {
        // 🚨 SAFETY: avoid null crash
        if (rule.getKeyword() == null || rule.getKeyword().isBlank()) {
            throw new IllegalArgumentException("Keyword is required");
        }
        return ruleRepository.save(rule);
    }

    // ✅ REQUIRED for GET /api/rules
    public List<CategorizationRule> getAllRules() {
        return ruleRepository.findAll();
    }
}
