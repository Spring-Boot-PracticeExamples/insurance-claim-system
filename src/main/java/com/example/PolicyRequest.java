package com.example;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PolicyRequest {
    private String policyId;
    private String policyNumber;
    private String name;
    private String coverageAmount;
    private java.sql.Date startDate;
    private java.sql.Date endDate;
}

