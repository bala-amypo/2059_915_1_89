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
        return ruleRepository.save(rule);
    }

    public List<CategorizationRule> getAllRules() {
        return ruleRepository.findAll();
    }
}
