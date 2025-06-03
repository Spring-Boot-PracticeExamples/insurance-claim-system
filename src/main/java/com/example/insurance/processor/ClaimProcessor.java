package com.example.insurance.processor;

import com.example.insurance.model.Claim;

public interface ClaimProcessor {
    void process(Claim claim);
}
