package com.yogeshdofficial.catalogue_service.web.controllers;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import io.restassured.http.ContentType;
import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import com.yogeshdofficial.catalogue_service.AbstractIT;
import com.yogeshdofficial.catalogue_service.domain.product.ProductDto;

@Sql("/test-data.sql")
class ProductControllerTest extends AbstractIT {

  @Test
  void shouldReturnProducts() {
    given().contentType(ContentType.JSON)
        .when()
        .get("/api/products/?size=10&page=0")
        .then()
        .statusCode(200)
        .body("data", hasSize(10))
        .body("pageNumber", is(0))
        .body("hasNext", is(true))
        .body("hasPrevious", is(false));
  }

  @Test
  void shouldGetProductByCode() {
    ProductDto product = given().contentType(ContentType.JSON)
        .when()
        .get("/api/products/{code}", "P100")
        .then()
        .statusCode(200)
        .assertThat()
        .extract()
        .body()
        .as(ProductDto.class);

    assertThat(product.getCode()).isEqualTo("P100");
    assertThat(product.getName()).isEqualTo("The Hunger Games");
    assertThat(product.getDescription()).isEqualTo("Winning will make you famous. Losing means certain death...");
    assertThat(product.getPrice()).isEqualTo(new BigDecimal("34.0"));
  }

  @Test
  void shouldReturnNotFoundWhenProductCodeNotExists() {
    String code = "invalid_product_code";
    given().contentType(ContentType.JSON)
        .when()
        .get("/api/products/{code}", code)
        .then()
        .statusCode(404)
        .body("status", is(404))
        .body("title", is("Product Not Found"))
        .body("detail", is("Product with code " + code + " not found"));
  }
}