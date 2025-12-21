package com.example.demo.controller;

import com.example.demo.model.CategorizationRule;
import com.example.demo.service.impl.CategorizationRuleServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
@CrossOrigin
public class CategorizationRuleController {

    private final CategorizationRuleServiceImpl service;

    public CategorizationRuleController(CategorizationRuleServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public CategorizationRule create(@RequestBody CategorizationRule rule) {
        return service.createRule(rule);
    }

    @GetMapping
    public List<CategorizationRule> getAll() {
        return service.getAllRules();
    }
}
