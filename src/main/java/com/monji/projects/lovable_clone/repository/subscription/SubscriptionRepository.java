package com.monji.projects.lovable_clone.repository.subscription;

import com.monji.projects.lovable_clone.entity.subscription.Subscription;
import com.monji.projects.lovable_clone.enums.SubscriptionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    /*
     * Get the current active subscription
     * */
    Optional<Subscription> findByUserIdAndStatusIn(Long userId, Set<SubscriptionStatus> statusSet);

    boolean existsByStripeSubscriptionId(String subscriptionId);

    Optional<Subscription> findByStripeSubscriptionId(String gatewaySubscriptionId);
}
