package com.example.insurance.processor;

import com.example.insurance.model.Claim;
import org.springframework.stereotype.Component;

@Component
public class PropertyClaimProcessor implements ClaimProcessor {
    @Override
    public void process(Claim claim) {
        System.out.println("Processing property claim: " + claim.getId());
        // Specific property claim logic
    }
}
