package com.pociot.hcb.account;

import com.pociot.hcb.account.AccountApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountApplicationTests {

  @Test
  public void contextLoads() {
    AccountApplication.main(new String[] {});
  }
}
