package com.pociot.accounts;

import static org.junit.Assert.*;

import java.util.concurrent.ExecutionException;
import org.junit.Test;

public class MyControllerTest {

  private final MyController myController;

  public MyControllerTest(MyController myController) {
    this.myController = myController;
  }

  @Test
  public void getHelloWorld() {
    try {
      assertEquals("Hello World!", myController.getHelloWorld().toFuture().get());
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }
}