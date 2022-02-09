package com.example.producer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/fraud")
public class FraudController {
    @PostMapping("/check")
    public Map<String, String> checkFraud(@RequestBody Map<String, String> body) {
        Integer amount = Integer.valueOf(body.get("amount"));
        Map<String, String> returnBody = new HashMap<>();
        if(amount < 1000000000) {
            returnBody.put("fraud", "false");
            return returnBody;
        }
        returnBody.put("fraud", "true");
        return returnBody;
    }
}