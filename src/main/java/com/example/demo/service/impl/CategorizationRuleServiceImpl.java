package com.example.demo.service.impl;

import com.example.demo.model.CategorizationRule;
import com.example.demo.repository.CategorizationRuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorizationRuleServiceImpl {

    private final CategorizationRuleRepository repository;

    public CategorizationRuleServiceImpl(CategorizationRuleRepository repository) {
        this.repository = repository;
    }

    public CategorizationRule createRule(CategorizationRule rule) {
        return repository.save(rule);
    }

    public List<CategorizationRule> getAllRules() {
        return repository.findAll();
    }
}
