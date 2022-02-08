package com.example.consumer.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "FraudRepository", url = "https://localhost:8080")
public interface FraudRepository {
    @PostMapping("/fraud/check")
    public Boolean checkApplication(@RequestBody Integer amount);
}