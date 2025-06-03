package com.example.insurance.repository;

import java.util.HashMap;
import java.util.Map;
import com.example.insurance.model.Claim;
import org.springframework.stereotype.Repository;

@Repository
public class ClaimRepository {
    private final Map<String, Claim> db = new HashMap<>();

    public void save(Claim claim) {
        db.put(claim.getId(), claim);
    }

    public Claim findById(String id) {
        return db.get(id);
    }
}
