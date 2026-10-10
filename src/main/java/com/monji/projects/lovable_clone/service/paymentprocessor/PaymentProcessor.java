package com.monji.projects.lovable_clone.service.paymentprocessor;

import com.monji.projects.lovable_clone.dto.subscription.CheckoutRequest;
import com.monji.projects.lovable_clone.dto.subscription.CheckoutResponse;
import com.monji.projects.lovable_clone.dto.subscription.PortalResponse;
import com.stripe.model.StripeObject;

import java.util.Map;

public interface PaymentProcessor {
    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request);

    PortalResponse openCustomerPortal();

    void handleWebhookEvent(String type, StripeObject stripeObject, Map<String, String> metadata);
}
