package com.example.insurance.processor;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ClaimProcessorFactory {

    private final Map<String, ClaimProcessor> processors;

    public ClaimProcessorFactory(Map<String, ClaimProcessor> processors) {
        this.processors = processors;
    }

    public ClaimProcessor getProcessor(String type) {
        return switch (type.toUpperCase()) {
            case "HEALTH" -> processors.get("healthClaimProcessor");
            case "AUTO" -> processors.get("autoClaimProcessor");
            case "PROPERTY" -> processors.get("propertyClaimProcessor");
            default -> throw new IllegalArgumentException("Unsupported claim type");
        };
    }
}
