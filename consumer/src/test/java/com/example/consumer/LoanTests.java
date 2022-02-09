package com.example.consumer;

import com.example.consumer.service.LoanService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@AutoConfigureStubRunner(stubsMode = StubsMode.LOCAL, 
        ids = {"com.example:producer:+:stubs:8080"})
public class LoanTests {
    @Autowired
    public LoanService loanService;

    @Test
    public void shouldSucceedFraudCheck() {
        // given:
        Integer loanAmount = 1000000000;

        // when:
        Map<String, String> result = loanService.apply(loanAmount);

        // then:
        assertEquals(result.get("fraud"), "false");
    }

    @Test
    public void shouldFailFraudCheck() {
        // given:
        Integer loanAmount = 1000000000;

        // when:
        Map<String, String> result = loanService.apply(loanAmount);

        // then:
        assertEquals(result.get("fraud"), "true");
    }
}