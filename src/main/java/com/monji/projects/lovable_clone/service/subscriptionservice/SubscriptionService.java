package com.monji.projects.lovable_clone.service.subscriptionservice;

import com.monji.projects.lovable_clone.dto.subscription.CheckoutRequest;
import com.monji.projects.lovable_clone.dto.subscription.CheckoutResponse;
import com.monji.projects.lovable_clone.dto.subscription.PortalResponse;
import com.monji.projects.lovable_clone.dto.subscription.SubscriptionResponse;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription(Long userId);

    CheckoutResponse createCheckoutSessionUrl(Long userId, CheckoutRequest checkoutRequest);

    PortalResponse openCustomerPortal(Long userId);
}
