package com.monji.projects.lovable_clone.dto.plan;

public record PlanLimitsResponse(
        String planName,
        Integer maxTokensPerDay,
        Integer maxProjects,
        boolean unlimitedAi
) {
}
