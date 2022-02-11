# spring-cloud-conract-demo
This is a demo project on the use of Spring Cloud Contract. This project contains 2 applications, the consumer and the producer of the contract. 

# Project Setup
Both the producer and the consumer is built using Spring Boot version 2.5.9 and Java 8. The Spring Cloud Contract dependency and plugin version is following the the Spring Cloud 3.0.5 release train.

To use the project you'll need to install the producer project first using `mvn clean install` or `mvn clean install -DskipTests`, then it'll install the contract stubs `.jar` into your maven repository. By not skipping the tests, the producer project will run the contracts through a base test class to verify compliance with the actual implementation.

After installing the producer project then we can run the tests in the consumer project by running the `mvn clean test` command.

# Contracts
A contract as defined in [Spring Cloud Contract documentation](https://docs.spring.io/spring-cloud-contract/docs/3.0.5/reference/html/getting-started.html#getting-started-what-is-a-contract), is an agreement on how the API or message communication should look. In other words it is the agreed upon message shape that the procucer will produce and the consumer will consume.

There are two approaches in implementing the use of cotnracts in your projects. A producer driven approach and a consumer driven approach.

# How to write contracts
The Spring Cloud Contract project facilitates writing contracts in multiple formats, the main format that's supported is Groovy. You can write contracts then immedieately publish it, but the standard is to test the contract you've written so as to make sure it complies with the implementation itself. Spring Cloud Contract provide contract testing as a plugin for Maven which you'll need to add to your project to use in addition to the Spring Cloud Contract dependecy itself.

# Producer Driven Approach
In Spring Cloud Contract the contract is published by the producer of the contract. The contracts define the response that'll be sent from the producers endpoints. So a simple approach for implementing contracts in your projects is for the producer to issue contracts on how its endpoints will behave, then the consuming application can use the contracts directly.

This approach is suited if you, as a consumer, don't have access to the producer application itself. As the consumer you can have the certainty of how endpoints will behave as it is issued by the producer, and as the producer help he consumer to use your services as intended. But a limitation to this is if any endpoints have complex logic and many possible response, it takes a lot of effort on the producer to issue the many contracts needed to comply to all possible usecase, and as the consumer you are limited to the contracts the producers issued.

The consumer driven approach section will explain in more detail on how the consumer can affect the contracts being issued.

# Consumer Driven Approach
A consumer driven approach needs the consumer to be able to access the producer project, or at least the consumer to be able to issue contact pull requests to the prodcuer application. Because in a consumer driven approach the ones making the contracts will be the consumer, to more effectively cover the consumer needs and not swamp the producer to make contracts to cover all possible usecase.

The flow of a consumer driven approach is first the consumer make a test on its application, then the consumer team forks the producers application and make contracts based on their needs and create a pull request to publish those contracts, then the producer team will review the pull request and run it through tests to make sure the contracts comply to the actual implementatin, if it complies then the producer then merge the pull request then publish the contracts for use by the consumer and other consumers as well.
