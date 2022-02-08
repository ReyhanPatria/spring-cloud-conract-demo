package com.example.consumer.service;

import com.example.consumer.repository.FraudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {
    @Autowired
    private FraudRepository fraudRepository;

    public Boolean apply(Integer amount) {
        return fraudRepository.checkApplication(amount);
    }
}