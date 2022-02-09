package com.example.consumer.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "FraudRepository", url = "http://localhost:8080")
public interface FraudRepository {
    @PostMapping("/fraud/check")
    public Map<String, String> checkApplication(@RequestBody Map<String, Integer> amount);
}