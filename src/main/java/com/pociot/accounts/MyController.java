package com.pociot.accounts;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class MyController {

  @CrossOrigin(origins = "https://accounting-kpociot.herokuapp.com")
  @GetMapping("hello")
  public Mono<String> getHelloWorld() {
    return Mono.just("Hello World!");
  }
}
