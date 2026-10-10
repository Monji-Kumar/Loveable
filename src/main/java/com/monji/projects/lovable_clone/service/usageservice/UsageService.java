package com.monji.projects.lovable_clone.service.usageservice;

import com.monji.projects.lovable_clone.dto.plan.PlanLimitsResponse;
import com.monji.projects.lovable_clone.dto.usage.UsageTodayResponse;

public interface UsageService {
    void recordTokenUsage(Long userId, int actualTokens);
    void checkDailyTokensUsage();

    UsageTodayResponse getTodayUsageOfUser(Long userId);

    PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId);
}
