package com.example.consumer;

import com.example.consumer.service.LoanService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class LoanTests {
    @Autowired
    public LoanService loanService;

    @Test
    public void shouldSucceedFraudCheck() {
        // given:
        Integer loanAmount = 1000000;

        // when:
        Boolean result = loanService.apply(loanAmount);

        // then:
        assertTrue(result);
    }

    @Test
    public void shouldFailFraudCheck() {
        // given:
        Integer loanAmount = 1000000000;

        // when:
        Boolean result = loanService.apply(loanAmount);

        // then:
        assertFalse(result);
    }
}