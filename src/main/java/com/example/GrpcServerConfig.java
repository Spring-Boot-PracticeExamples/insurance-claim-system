package com.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class GrpcServerConfig {

    @Value("${grpc.server.port:9090}")
    private int grpcPort;

    private final Server grpcServer;

    // Marking PolicyServiceImpl as @Lazy to break the cycle
    public GrpcServerConfig(@Lazy PolicyServiceImpl policyServiceImpl) {
        this.grpcServer = ServerBuilder.forPort(grpcPort)
                .addService(policyServiceImpl)
                .build();
    }

    @PostConstruct
    public void startGrpcServer() throws Exception {
        grpcServer.start();
        System.out.println("gRPC server started on port " + grpcPort);
        grpcServer.awaitTermination();
    }
}
