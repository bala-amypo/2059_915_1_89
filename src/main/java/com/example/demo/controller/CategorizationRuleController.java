package com.example.demo.controller;

import com.example.demo.model.CategorizationRule;
import com.example.demo.service.impl.CategorizationRuleServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rules")
@CrossOrigin(origins = "https://9429.pro604cr.amypo.ai", allowCredentials = "true")
public class CategorizationRuleController {

    private final CategorizationRuleServiceImpl ruleService;

    public CategorizationRuleController(CategorizationRuleServiceImpl ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    public CategorizationRule createRule(@RequestBody CategorizationRule rule) {
        return ruleService.createRule(rule);
    }
}
