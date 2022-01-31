package com.s462050.pracownia_programowania.controller;

import com.s462050.pracownia_programowania.model.Samochod;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;

import javax.annotation.PostConstruct;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class SamochodControllerTest {
    @LocalServerPort
    private int port;

    private String uri;

    @PostConstruct
    public void init() {
        uri = "http://localhost:" + port;
    }

    @Test
    void findAll() {
        RestAssured.get(uri + "/samochod/")
                .then()
                .statusCode(200);
    }

    @Test
    void findSamochod1() {
        given()
                .pathParam("id", 1)
                .get(uri + "/samochod/{id}")
                .prettyPeek()
                .then()
                .statusCode(200);
    }

    @Test
    void addSamochod1() {
        Samochod samochod = new Samochod();
        samochod.setModel("Volkswagen");
        samochod.setMarka("Polo");
        samochod.setUzywany(true);
        Samochod nowySamochod1 = given()
                .when()
                .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                .body(samochod)
                .post(uri + "/samochod/")
                .then()
                .statusCode(201)
                .extract().body().as(Samochod.class);
        assertNotNull(nowySamochod1);
        assertNotNull(nowySamochod1.getID());
    }

    @Test
    void deleteSamochod1() {
        given()
                .pathParam("id", 1)
                .delete(uri + "/samochod/{id}")
                .prettyPeek()
                .then()
                .statusCode(200);

        given()
                .pathParam("id", 1)
                .delete(uri + "/samochod/{id}")
                .prettyPeek()
                .then()
                .statusCode(404);
    }
}