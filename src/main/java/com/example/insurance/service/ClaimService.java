package com.example.insurance.service;

import com.example.insurance.model.Claim;
import com.example.insurance.processor.ClaimProcessor;
import com.example.insurance.processor.ClaimProcessorFactory;
import com.example.insurance.repository.ClaimRepository;
import org.springframework.stereotype.Service;

@Service
public class ClaimService {
    private final ClaimValidator validator;
    private final ClaimRepository repository;
    private final NotificationService notifier;
    private final ClaimProcessorFactory processorFactory;

    public ClaimService(ClaimValidator validator, ClaimRepository repository,
                        NotificationService notifier, ClaimProcessorFactory processorFactory) {
        this.validator = validator;
        this.repository = repository;
        this.notifier = notifier;
        this.processorFactory = processorFactory;
    }

    public void submitClaim(Claim claim) {
        if (!validator.validate(claim)) {
            throw new IllegalArgumentException("Invalid claim data");
        }
        repository.save(claim);
        notifier.notifyClaimant(claim);
        ClaimProcessor processor = processorFactory.getProcessor(claim.getType());
        processor.process(claim);
    }
}
