package com.monji.projects.lovable_clone.service.usageservice;

import com.monji.projects.lovable_clone.dto.plan.PlanLimitsResponse;
import com.monji.projects.lovable_clone.dto.usage.UsageTodayResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId) {
        return null;
    }
}
