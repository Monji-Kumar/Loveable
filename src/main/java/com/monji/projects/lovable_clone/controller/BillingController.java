package com.monji.projects.lovable_clone.controller;

import com.monji.projects.lovable_clone.dto.plan.PlanResponse;
import com.monji.projects.lovable_clone.dto.subscription.CheckoutRequest;
import com.monji.projects.lovable_clone.dto.subscription.CheckoutResponse;
import com.monji.projects.lovable_clone.dto.subscription.PortalResponse;
import com.monji.projects.lovable_clone.dto.subscription.SubscriptionResponse;
import com.monji.projects.lovable_clone.service.planservice.PlanService;
import com.monji.projects.lovable_clone.service.subscriptionservice.SubscriptionService;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.model.Event;
import com.stripe.model.EventDataObjectDeserializer;
import com.stripe.model.Review;
import com.stripe.model.StripeObject;
import com.stripe.model.checkout.Session;
import com.stripe.net.Webhook;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BillingController {

    private final SubscriptionService subscriptionService;
    private final PlanService planService;
    private final PaymentProcessor paymentProcessor;

    @Value("${stripe.webhook.secret}")
    private String stripeWebhookSecret;

    @GetMapping(value = "/api/plans")
    public ResponseEntity<List<PlanResponse>> getAllPlans() {
        return ResponseEntity.ok(planService.getAllActivePlans());
    }

    @GetMapping(value = "/api/my-subscription")
    public ResponseEntity<SubscriptionResponse> getMySubscription() {
        Long userId = 1L;
        return ResponseEntity.ok(subscriptionService.getCurrentSubscription(userId));
    }

    @PostMapping(value = "/api/payments/checkout")
    public ResponseEntity<CheckoutResponse> createCheckoutResponse(@RequestBody CheckoutRequest checkoutRequest) {
        Long userId = 1L;
        return ResponseEntity.ok(paymentProcessor.createCheckoutSessionUrl(request));
    }

    @PostMapping(value = "/api/payments/portal")
    public ResponseEntity<PortalResponse> openCustomerPortal() {
        Long userId = 1L;
        return ResponseEntity.ok(paymentProcessor.openCustomerPortal(userId));
    }

    //WebHook
    @PostMapping(value = "/webhooks/payment")
    public ResponseEntity<String> handlePaymentWebhook(@RequestBody String payload, @RequestHeader("Stripe-Signature") String sigHeader) {
        try{
            Event event = Webhook.constructEvent(payload, sigHeader, stripeWebhookSecret);

            EventDataObjectDeserializer deserializer = event.getDataObjectDeserializer();
            StripeObject stripeObject = null;

            if(deserializer.getObject().isPresent()) {
                stripeObject = deserializer.getObject().get();
            } else {
                //Fallback: Deserialize from raw JSON
                try {
                    stripeObject = deserializer.deserializeUnsafe();
                    if(stripeObject == null) {
                        log.warn("Failed to deserialize webhook object for event: {}", event.getType());
                        return ResponseEntity.ok().build();
                    }
                } catch (Exception e) {
                    log.error("Failed to deserialize webhook object for event: {}", event.getType(), e);
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Deserialization Failed");
                }
            }

            //Now extract metadata only if it's a Checkout Session
            Map<String, String> metaData = new HashMap<>();
            if(stripeObject instanceof Session session) {
                metaData = session.getMetadata();
            }

            //Pass to processor
            paymentProcessor.handleWebhookContent(event.getType(), stripeObject, metaData);
            return ResponseEntity.ok().build();
        } catch (SignatureVerificationException e) {
            throw new RuntimeException(e);
        }
    }
}
