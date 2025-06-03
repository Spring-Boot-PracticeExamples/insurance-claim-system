package com.example.insurance.processor;

import com.example.insurance.model.Claim;
import org.springframework.stereotype.Component;

@Component
public class HealthClaimProcessor implements ClaimProcessor {
    @Override
    public void process(Claim claim) {
        System.out.println("Processing health claim: " + claim.getId());
        // Specific health claim logic
    }
}
