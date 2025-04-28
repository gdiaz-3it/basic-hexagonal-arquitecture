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
            .route("mcsv-lenguajes", r -> r.path("/api/lenguajes/**")
                .uri("http://localhost:8082"))
            .route("mcsv-aplicaciones", r -> r.path("/api/aplicaciones/**")
                .uri("http://localhost:8083"))
            .build();
    }
}
