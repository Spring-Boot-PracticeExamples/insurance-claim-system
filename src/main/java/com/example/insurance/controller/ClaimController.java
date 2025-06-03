package com.example.insurance.controller;

import com.example.insurance.model.Claim;
import com.example.insurance.service.ClaimService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {
    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping
    public ResponseEntity<String> submitClaim(@RequestBody Claim claim) {
        claimService.submitClaim(claim);
        return ResponseEntity.ok("Claim submitted successfully");
    }
}
