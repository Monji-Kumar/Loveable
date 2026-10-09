package com.monji.projects.lovable_clone.dto.plan;

public record PlanResponse(
        Long id,
        String name,
        Integer maxProjects,
        Integer maxTokensPerDay,
        Integer maxPreviews, //max number of previews allowed per plan
        Boolean unlimitedAi, //unlimited access to LLM, ignore maxTokensPerDay if true
        Boolean active
) {
}
