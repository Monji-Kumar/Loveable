package com.monji.projects.lovable_clone.service.usageservice;

import com.monji.projects.lovable_clone.dto.usage.PlanLimitsResponse;
import com.monji.projects.lovable_clone.dto.usage.UsageTodayResponse;

public interface UsageService {
    UsageTodayResponse getTodayUsageOfUser(Long userId);

    PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId);
}
