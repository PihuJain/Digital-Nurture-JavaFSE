package com.cognizant.apigateway.loadbalancer;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Configuration;

// this is the one that actually gets picked up by component scanning. it just wires
// AccountLoadBalancerConfig to the "account-service" client name, name has to match
// the serviceId used in the lb://account-service route (lowercase because
// discovery.locator.lower-case-service-id is on)
@Configuration
@LoadBalancerClient(name = "account-service", configuration = AccountLoadBalancerConfig.class)
public class GatewayLoadBalancerConfig {
}
