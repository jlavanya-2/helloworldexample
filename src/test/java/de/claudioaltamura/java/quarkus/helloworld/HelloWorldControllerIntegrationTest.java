package de.claudioaltamura.java.quarkus.helloworld;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class HelloWorldControllerIntegrationTest {

  @Test
  public void helloworld() {
    given().when().get("/hello").then().statusCode(200).body(is("hello world!"));
  }
}
