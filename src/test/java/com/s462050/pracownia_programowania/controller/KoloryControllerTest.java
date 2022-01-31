package com.s462050.pracownia_programowania.controller;

import com.s462050.pracownia_programowania.model.Kolory;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;

import javax.annotation.PostConstruct;

import static io.restassured.RestAssured.given;
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
        Kolory kolory = new Kolory();
        kolory.setNazwaKoloru("Testowy");
        Kolory nowyKolor = given()
                .when()
                .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                .body(kolory)
                .post(uri + "/kolory/")
                .then()
                .statusCode(201)
                .extract().body().as(Kolory.class);
        assertNotNull(nowyKolor);
        assertNotNull(nowyKolor.getID());

    }

    @Test
    void deleteKolor() {
        given()
                .pathParam("id", 2)
                .delete(uri + "/kolory/{id}")
                .prettyPeek()
                .then()
                .statusCode(200);

        given()
                .pathParam("id", 2)
                .delete(uri + "/kolory/{id}")
                .prettyPeek()
                .then()
                .statusCode(404);
    }
}