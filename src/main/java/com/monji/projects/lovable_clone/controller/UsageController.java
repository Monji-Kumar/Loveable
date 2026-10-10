package com.monji.projects.lovable_clone.controller;

import com.monji.projects.lovable_clone.dto.plan.PlanLimitsResponse;
import com.monji.projects.lovable_clone.dto.usage.UsageTodayResponse;
import com.monji.projects.lovable_clone.service.usageservice.UsageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/usage")
@RequiredArgsConstructor
@Slf4j
public class UsageController {

    private final UsageService usageService;

    @GetMapping(value = "/today")
    public ResponseEntity<UsageTodayResponse> getTodayUsage() {
        Long userId = 1L;
        return ResponseEntity.ok(usageService.getTodayUsageOfUser(userId));
    }

    @GetMapping(value = "/limits")
    public ResponseEntity<PlanLimitsResponse> getPlanLimits() {
        Long userId = 1L;
        return ResponseEntity.ok(usageService.getCurrentSubscriptionLimitsOfUser(userId));
    }
}
