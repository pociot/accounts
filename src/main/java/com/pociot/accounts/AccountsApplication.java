package com.pociot.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class AccountsApplication {

  public static void main(String[] args) {
    SpringApplication.run(AccountsApplication.class, args);
  }

  @Bean
  public RouterFunction<ServerResponse> route(MyController myController) {
    return RouterFunctions
        .route(RequestPredicates
            .GET("/hello")
            .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), myController::getHelloWorld);
  }

  @Component
  public class MyController {

    public Mono<ServerResponse> getHelloWorld(ServerRequest request) {
      return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
          .body(BodyInserters.fromObject("Hello World!"));
    }
  }
}
