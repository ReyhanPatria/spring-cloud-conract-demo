# spring-cloud-conract-demo
This is a demo project on the use of Spring Cloud Contract. This project contains 2 application, the consumer and the producer of the contract. 

# Project Setup
Both the producer and the consumer is built using Spring Boot version 2.5.9 and Java 8. The Spring Cloud Contract dependency and plugin version is following the the Spring Cloud 3.0.5 release train.

# Contracts
A contract as defined in [Spring Cloud Contract documentation](https://docs.spring.io/spring-cloud-contract/docs/3.0.5/reference/html/getting-started.html#getting-started-what-is-a-contract), is an agreement on how the API or message communication should look. In other words it is the agreed upon message shape that the procucer will produce and the consumer will consume.

There are two approaches in implementing the use of cotnracts in your projects. A producer driven approach and a consumer driven approach.

# Producer Driven Approach
In Spring Cloud Contract the contract is published by the producer of the contract. The contracts define the response that'll be sent from the producers endpoints. So a simple approach for implementing contracts in your projects is for the producer to issue contracts on how its endpoints will behave, then the consuming application can use the contracts directly.

This approach is suited if you, as a consumer, don't have access to the producer application itself. As the consumer you can have the certainty of how endpoints will behave as it is issued by the producer, and as the producer help he consumer to use your services as intended. But a limitation to this is if any endpoints have complex logic and many possible response, it takes a lot of effort on the producer to issue the many contracts needed to comply to all possible usecase, and as the consumer you are limited to the contracts the producers issued.

The consumer driven approach section will explain in more detail on how the consumer can affect the contracts being issued.
