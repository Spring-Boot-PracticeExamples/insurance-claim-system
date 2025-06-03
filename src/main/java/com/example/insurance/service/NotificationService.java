package com.example.insurance.service;

import com.example.insurance.model.Claim;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void notifyClaimant(Claim claim) {
        System.out.println("Notification sent for claim id: " + claim.getId());
    }
}
