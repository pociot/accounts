package com.pociot.hcb.account.client;

import com.pociot.hcb.account.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="hcb-auth-service")
public interface AuthServiceClient {
  @PostMapping(value = "/auth/users", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  void createUser(User user);
}
