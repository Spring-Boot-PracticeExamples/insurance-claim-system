package com.example;

import com.insurance.PolicyOuterClass;
import com.insurance.PolicyServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@GRpcService
public class PolicyServiceImpl extends PolicyServiceGrpc.PolicyServiceImplBase {

    @Autowired
    private PolicyRepository policyRepository;

    @Override
    public void getPolicy(PolicyOuterClass.PolicyRequest request, StreamObserver<PolicyOuterClass.PolicyResponse> responseObserver) {
        String policyId = request.getPolicyId();
        Policy policy = policyRepository.findById(policyId).orElse(null);

        if (policy != null) {
            PolicyOuterClass.PolicyResponse response = PolicyOuterClass.PolicyResponse.newBuilder()
                    .setPolicyId(String.valueOf(policy.getPolicyId()))
                     .setHolderName(policy.getHolderName())
                    .setCoverageAmount(policy.getCoverageAmount())
                    .setPolicyNumber(policy.getPolicyNumber())
                    .setStartDate(String.valueOf(policy.getStartDate()))
                    .setEndDate(String.valueOf(policy.getEndDate()))
                    .build();

            responseObserver.onNext(response);
        }
        responseObserver.onCompleted();
    }

    public void createPolicy(Policy request, StreamObserver<PolicyOuterClass.PolicyResponse> responseObserver) {
        Policy policy = new Policy();
        policy.setPolicyId(request.getPolicyId());
        policy.setHolderName(request.getHolderName());
        policy.setCoverageAmount(request.getCoverageAmount());
        policy.setEndDate(request.getEndDate());
        policy.setStartDate(request.getStartDate());
        policy.setPolicyNumber(request.getPolicyNumber());
        policyRepository.save(policy);

        PolicyOuterClass.PolicyResponse response = PolicyOuterClass.PolicyResponse.newBuilder()
                .setPolicyId(String.valueOf(policy.getPolicyId()))
                .setHolderName(policy.getHolderName())
                .setCoverageAmount(policy.getCoverageAmount())
                .setEndDate(String.valueOf(policy.getEndDate()))
                .setStartDate(String.valueOf(policy.getStartDate()))
                .setPolicyNumber(policy.getPolicyNumber())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
