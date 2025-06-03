package com.example.insurance.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Claim {
    private String id;
    private String type; // HEALTH, AUTO, PROPERTY
    private String description;
    private double amount;
}
