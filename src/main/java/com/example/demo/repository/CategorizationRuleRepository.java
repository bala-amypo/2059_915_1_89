package com.example.demo.repository;

import com.example.demo.model.CategorizationRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorizationRuleRepository extends JpaRepository<CategorizationRule, Long> {

    // HQL-based keyword search (Tests 59, 60)
    @Query("""
           SELECT r FROM CategorizationRule r
           WHERE LOWER(:description) LIKE LOWER(CONCAT('%', r.keyword, '%'))
           ORDER BY r.priority DESC
           """)
    List<CategorizationRule> findMatchingRulesByDescription(String description);
}
