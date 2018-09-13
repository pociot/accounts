package com.pociot.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class AccountsApplication {

  public static void main(String[] args) {
    SpringApplication.run(AccountsApplication.class, args);
  }

  @RestController
  @CrossOrigin
  public class MyController {

    @GetMapping("hello")
    public Mono<String> getHelloWorld() {
      return Mono.just("Hello World!");
    }
  }
}
