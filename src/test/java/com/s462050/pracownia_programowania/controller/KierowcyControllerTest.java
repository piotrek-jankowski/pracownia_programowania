package com.s462050.pracownia_programowania.controller;

import com.s462050.pracownia_programowania.model.Kierowcy;
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
class KierowcyControllerTest {
    @LocalServerPort
    private int port;

    private String uri;

    @PostConstruct
    public void init() {
        uri = "http://localhost:" + port;
    }

    @Test
    void findAll() {
        RestAssured.get(uri + "/kierowcy/")
                .then()
                .statusCode(200);
    }

    @Test
    void findKierowcy() {
        given()
                .pathParam("id", 1)
                .get(uri + "/kierowcy/{id}")
                .prettyPeek()
                .then()
                .statusCode(200);
    }

    @Test
    void addKierowcy() {
        Kierowcy kierowcy = new Kierowcy();
        kierowcy.setNazwaKierowcy("Testowy");
        Kierowcy nowyKierowcy = given()
                .when()
                .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                .body(kierowcy)
                .post(uri + "/kierowcy/")
                .then()
                .statusCode(201)
                .extract().body().as(Kierowcy.class);
        assertNotNull(nowyKierowcy);
        assertNotNull(nowyKierowcy.getID());
    }

    @Test
    void deleteKierowcy() {
        given()
                .pathParam("id", 1)
                .delete(uri + "/kierowcy/{id}")
                .prettyPeek()
                .then()
                .statusCode(200);

        given()
                .pathParam("id", 1)
                .delete(uri + "/kierowcy/{id}")
                .prettyPeek()
                .then()
                .statusCode(404);
    }
}