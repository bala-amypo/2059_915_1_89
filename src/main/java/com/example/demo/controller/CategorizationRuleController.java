package com.example.demo.controller;

import com.example.demo.model.CategorizationRule;
import com.example.demo.service.impl.CategorizationRuleServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
@CrossOrigin
public class CategorizationRuleController {

    private final CategorizationRuleServiceImpl ruleService;

    public CategorizationRuleController(CategorizationRuleServiceImpl ruleService) {
        this.ruleService = ruleService;
    }

    // ✅ GET all rules (THIS FIXES YOUR 500)
    @GetMapping
    public List<CategorizationRule> getAllRules() {
        return ruleService.getAllRules();
    }

    // ✅ POST create rule
    @PostMapping
    public CategorizationRule createRule(@RequestBody CategorizationRule rule) {
        return ruleService.createRule(rule);
    }
}
