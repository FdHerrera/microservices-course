package com.fdherrera.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator router(RouteLocatorBuilder routerBuilder) {
        return routerBuilder.routes()
                .route(endpoint ->
                        endpoint
                                .path("/api/v1/customer/**")
                                .uri("lb://CUSTOMER"))
                .build();
    }

}
