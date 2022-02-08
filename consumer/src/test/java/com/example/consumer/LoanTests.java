package com.example.consumer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoanTests {
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
}