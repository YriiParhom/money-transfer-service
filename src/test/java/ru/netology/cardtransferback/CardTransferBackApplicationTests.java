package ru.netology.cardtransferback;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CardTransferBackApplicationTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Container
    private final GenericContainer<?> transfer = new GenericContainer<>("money-transfer:latest")
            .withExposedPorts(5500);


    @Test
    void contextLoads() {
        Integer transferPort = transfer.getMappedPort(5500);

        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("http://localhost:" + transferPort,
                String.class);

        System.out.println(responseEntity);
    }

}
