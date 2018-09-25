package com.pociot.accounts;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class MyController {

  @CrossOrigin(origins = {
      "https://accounting-kpociot.herokuapp.com",
      "http://localhost:3000"
  })
  @GetMapping("hello")
  public Mono<String> getHelloWorld() {
    return Mono.just("Hello World!");
  }
}
