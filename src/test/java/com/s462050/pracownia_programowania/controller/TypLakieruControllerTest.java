package com.s462050.pracownia_programowania.controller;

import com.s462050.pracownia_programowania.model.TypLakieru;
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
class TypLakieruControllerTest {
    @LocalServerPort
    private int port;

    private String uri;

    @PostConstruct
    public void init() {
        uri = "http://localhost:" + port;
    }

    @Test
    void findAll() {
        RestAssured.get(uri + "/typLakieru/")
                .then()
                .statusCode(200);
    }

    @Test
    void findTypLakier() {
        given()
                .pathParam("id", 1)
                .get(uri + "/typLakieru/{id}")
                .prettyPeek()
                .then()
                .statusCode(200);
    }

    @Test
    void addTypLakier() {
        TypLakieru typLakieru = new TypLakieru();
        typLakieru.setLakier("Metalik");
        TypLakieru nowyTypLakier = given()
                .when()
                .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                .body(typLakieru)
                .post(uri + "/typLakieru/")
                .then()
                .statusCode(201)
                .extract().body().as(TypLakieru.class);
        assertNotNull(nowyTypLakier);
        assertNotNull(nowyTypLakier.getID());
    }

    @Test
    void deleteTypLakier() {
        given()
                .pathParam("id", 1)
                .delete(uri + "/typLakieru/{id}")
                .prettyPeek()
                .then()
                .statusCode(200);

        given()
                .pathParam("id", 1)
                .delete(uri + "/typLakieru/{id}")
                .prettyPeek()
                .then()
                .statusCode(404);
    }
}