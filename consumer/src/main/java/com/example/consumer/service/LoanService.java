package com.example.consumer.service;

import com.example.consumer.repository.FraudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoanService {
    @Autowired
    private FraudRepository fraudRepository;

    public Map<String, String> apply(Integer amount) {
        Map<String, Integer> body = new HashMap<>();
        body.put("amount", amount);
        return fraudRepository.checkApplication(body);
    }
}