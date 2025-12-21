package com.example.demo.service.impl;

import com.example.demo.model.CategorizationRule;
import com.example.demo.repository.CategorizationRuleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategorizationRuleServiceImpl {

    private final CategorizationRuleRepository ruleRepository;

    public CategorizationRuleServiceImpl(CategorizationRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    public CategorizationRule createRule(CategorizationRule rule) {

        if (rule.getKeyword() == null || rule.getKeyword().isBlank()) {
            throw new RuntimeException("Keyword cannot be null");
        }

        return ruleRepository.save(rule);
    }
}
