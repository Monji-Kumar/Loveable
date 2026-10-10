package com.monji.projects.lovable_clone.repository.plan;

import com.monji.projects.lovable_clone.entity.plan.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    Optional<Plan> findByStripePriceId(String id);
}
