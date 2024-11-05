package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MessageController {

    @Value("${message:Hello default}")
    private String message;

    @Value("${spring.application.name:simple-app}")
    private String appName;

    @GetMapping("/")
    public String getMessage() {
        return String.format("App: %s, Message: %s", appName, message);
    }

    @GetMapping("/health")
    public String health() {
        return "UP";
    }
}