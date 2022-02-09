package com.example.producer;

import com.example.producer.controller.FraudController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {
    public FraudController fraudController = new FraudController();

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(fraudController);
    }
}