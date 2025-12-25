package com.example.demo.repository;

import com.example.demo.model.CategorizationRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategorizationRuleRepository
        extends JpaRepository<CategorizationRule, Long> {

    // ⭐ REQUIRED BY TEST
    @Query("SELECT r FROM CategorizationRule r WHERE :description LIKE %r.keyword%")
    List<CategorizationRule> findMatchingRulesByDescription(String description);
}
