package com.example;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "insurance_policy")
@Data
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int policyId;

    @Column(name = "policy_number", nullable = false)
    private String policyNumber;

    @Column(name = "holder_name", nullable = false)
    private String holderName;

    @Column(name = "coverage_amount", nullable = false)
    private double coverageAmount;

    @Column(name = "start_date")
    private java.sql.Date startDate;

    @Column(name = "end_date")
    private java.sql.Date endDate;
}
