package com.pociot.hcb.account.service;

import com.pociot.hcb.account.domain.Account;
import com.pociot.hcb.account.domain.User;
import reactor.core.publisher.Mono;

public interface AccountService {
  Mono<Account> findByName(String username);

  Mono<Account> create(User user);

  void saveChanges(String name, Account update);
}
