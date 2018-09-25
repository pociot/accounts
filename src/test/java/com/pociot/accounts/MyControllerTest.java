package com.pociot.accounts;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.reactive.server.WebTestClient;

public class MyControllerTest {

  private static boolean setupCompleted = false;

  private WebTestClient webTestClient;

  @Before
  public void setUp() {
    if(!setupCompleted) {
      webTestClient = WebTestClient.bindToController(MyController.class)
          .build();
      setupCompleted = true;
    }
  }

  @Test
  public void getHelloWorld() {
    webTestClient.get().uri("/hello")
        .exchange()
        .expectStatus().isOk()
        .expectBody(String.class).isEqualTo("Hello World!");
  }
}