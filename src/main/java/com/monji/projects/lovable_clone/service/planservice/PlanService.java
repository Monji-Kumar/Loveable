package com.monji.projects.lovable_clone.service.planservice;

import com.monji.projects.lovable_clone.dto.plan.PlanResponse;

import java.util.List;

public interface PlanService {
    List<PlanResponse> getAllActivePlans();
}
