package com.example.insurance.service;


import com.example.insurance.model.Claim;
import org.springframework.stereotype.Service;

@Service
public class ClaimValidator {
    public boolean validate(Claim claim) {
        if (claim == null) return false;
        return claim.getAmount() > 0 && claim.getDescription() != null && !claim.getDescription().isEmpty();
    }
}
