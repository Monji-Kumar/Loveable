package com.monji.projects.lovable_clone.controller;

import com.monji.projects.lovable_clone.dto.plan.PlanResponse;
import com.monji.projects.lovable_clone.dto.subscription.CheckoutRequest;
import com.monji.projects.lovable_clone.dto.subscription.CheckoutResponse;
import com.monji.projects.lovable_clone.dto.subscription.PortalResponse;
import com.monji.projects.lovable_clone.dto.subscription.SubscriptionResponse;
import com.monji.projects.lovable_clone.service.PlanService;
import com.monji.projects.lovable_clone.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/api/billing")
public class BillingController {

    private final SubscriptionService subscriptionService;
    private final PlanService planService;

    @GetMapping(value = "/plans")
    public ResponseEntity<List<PlanResponse>> getAllPlans() {
        return ResponseEntity.ok(planService.getAllActivePlans());
    }

    @GetMapping(value = "/my-subscription")
    public ResponseEntity<SubscriptionResponse> getMySubscription() {
        Long userId = 1L;
        return ResponseEntity.ok(subscriptionService.getCurrentSubscription(userId));
    }

    @PostMapping(value = "/stripe/checkout")
    public ResponseEntity<CheckoutResponse> createCheckoutResponse(@RequestBody CheckoutRequest checkoutRequest) {
        Long userId = 1L;
        return ResponseEntity.ok(subscriptionService.createCheckoutSessionUrl(userId, checkoutRequest));
    }

    @PostMapping(value = "/stripe/portal")
    public ResponseEntity<PortalResponse> openCustomerPortal() {
        Long userId = 1L;
        return ResponseEntity.ok(subscriptionService.openCustomerPortal(userId));
    }
}
