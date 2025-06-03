package com.example.insurance.processor;

import com.example.insurance.model.Claim;
import org.springframework.stereotype.Component;

@Component
public class AutoClaimProcessor implements ClaimProcessor {
    @Override
    public void process(Claim claim) {
        System.out.println("Processing auto claim: " + claim.getId());
        // Specific auto claim logic
    }
}
