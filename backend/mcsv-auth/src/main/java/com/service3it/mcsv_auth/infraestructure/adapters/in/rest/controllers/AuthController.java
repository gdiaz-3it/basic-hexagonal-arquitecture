package com.service3it.mcsv_auth.infraestructure.adapters.in.rest.controllers;

import java.util.Map;
import java.util.HashMap;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @GetMapping("/welcome")
    public Mono<Map<String, Object>> welcome(@AuthenticationPrincipal Jwt Jwt) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Welcome to the Auth Service!");
        String username = Jwt.getClaimAsString("cognito:username");
        if(username != null) {
            response.put("username", username);
        }
        String email = Jwt.getClaimAsString("email");
        if(email != null) {
            response.put("email", email);
        }
        return Mono.just(response);
    }

    @GetMapping("/public")
    public Mono<Map<String, Object>> publicEndpoint() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "This is a public endpoint. No authentication required.");
        return Mono.just(response);
    }  

}
