package com.monji.projects.lovable_clone.dto.subscription;

import com.monji.projects.lovable_clone.dto.plan.PlanResponse;

import java.time.Instant;

public record SubscriptionResponse(
        PlanResponse plan,
        String status,
        Instant periodEnd,
        Long tokensUsedThisCycle
) {
}
