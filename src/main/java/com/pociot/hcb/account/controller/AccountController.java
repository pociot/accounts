package com.pociot.hcb.account.controller;

import com.pociot.hcb.account.domain.Account;
import com.pociot.hcb.account.domain.User;
import com.pociot.hcb.account.service.AccountService;
import java.security.Principal;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

  private final AccountService accountService;

  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @GetMapping(path = "/current")
  public Account getCurrentAccount(Principal principal) {
    return accountService.findByName(principal.getName()).block();
  }

//  @PreAuthorize("#oauth2.hasScope('server') or #name.equals('demo')")
  @GetMapping(path = "/{name}")
  public Account getAccountByName(@PathVariable String name) {
    return accountService.findByName(name).block();
  }

  @PostMapping(path = "/")
  public Account createNewAccount(@Valid @RequestBody User user) {
    return accountService.create(user).block();
  }
}
