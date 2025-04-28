package com.service3it.mcsv_auth.infraestructure.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("mscv-trinitianos", r -> r.path("/api/trinitianos/**")
                .uri("http://localhost:8081"))
            .build();
    }
}
