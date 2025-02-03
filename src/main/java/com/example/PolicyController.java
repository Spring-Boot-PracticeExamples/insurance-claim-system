package com.example;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private PolicyRepository policyRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/{policyId}")
    public PolicyResponse getPolicy(@PathVariable String policyId) {
        Policy policyResponse=policyRepository.findById(policyId).orElse(null);
        return modelMapper.map(policyResponse, PolicyResponse.class);
    }

    @PostMapping
    public PolicyResponse createPolicy(@RequestBody PolicyRequest policyRequest) {

        Policy policy=new Policy();
        policy.setPolicyId(Integer.parseInt(policyRequest.getPolicyId()));
        policy.setPolicyNumber(policyRequest.getPolicyId());
        policy.setHolderName(policyRequest.getName());
        policy.setStartDate(Date.valueOf(java.time.LocalDate.now()));
        policy.setEndDate(Date.valueOf(java.time.LocalDate.now().plusDays(5)));
        policy.setCoverageAmount(Double.parseDouble(policyRequest.getCoverageAmount()));
        Policy policyResponse=policyRepository.save(policy);
        return modelMapper.map(policyResponse, PolicyResponse.class);
    }

}
