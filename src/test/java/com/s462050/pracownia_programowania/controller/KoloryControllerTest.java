package com.s462050.pracownia_programowania.controller;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;

import javax.annotation.PostConstruct;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class KoloryControllerTest {
    @LocalServerPort
    private int port;

    private String uri;

    @PostConstruct
    public void init() {
        uri = "http://localhost:" + port;
    }

    @Test
    void findAll() {
        RestAssured.get(uri + "/kolory/")
                .then()
                .statusCode(200);
    }

    @Test
    void findKolor() {
    }

    @Test
    void addKolor() {
    }

    @Test
    void deleteKolor() {
    }

    @Test
    void updateKolor() {
    }

    @Test
    void exportData() {
    }

    @Test
    void importData() {
    }
}