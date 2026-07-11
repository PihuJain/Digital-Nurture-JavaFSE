package com.cognizant.apigateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

// GlobalFilter runs on every single request through the gateway, not just one route -
// this is purely for visibility, doesnt change or block anything, just logs and passes
// the exchange straight on to the next filter in the chain
@Component
public class LogFilter implements GlobalFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        LOGGER.info("====> request url {}", exchange.getRequest().getURI());
        return chain.filter(exchange);
    }
}
