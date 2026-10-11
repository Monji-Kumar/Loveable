package com.monji.projects.lovable_clone.mapper;

import com.monji.projects.lovable_clone.dto.plan.PlanLimitsResponse;
import com.monji.projects.lovable_clone.dto.subscription.SubscriptionResponse;
import com.monji.projects.lovable_clone.entity.plan.Plan;
import com.monji.projects.lovable_clone.entity.subscription.Subscription;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    @Mapping(target = "PlanLimitsResponse.planName", source = "plan")
    SubscriptionResponse toSubscriptionResponse(Subscription subscription);

    PlanLimitsResponse toPlanResponse(Plan plan);
}
