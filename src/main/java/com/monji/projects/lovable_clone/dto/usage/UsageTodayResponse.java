package com.monji.projects.lovable_clone.dto.usage;

public record UsageTodayResponse(
        int tokensUsed,
        int tokensLimit,
        int previewsRunning,
        int previewsLimit
) {
}
