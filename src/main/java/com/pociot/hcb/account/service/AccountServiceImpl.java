package com.pociot.hcb.account.service;

import com.pociot.hcb.account.client.AuthServiceClient;
import com.pociot.hcb.account.domain.Account;
import com.pociot.hcb.account.domain.User;
import com.pociot.hcb.account.repository.AccountRepository;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import reactor.core.publisher.Mono;

@Service
public class AccountServiceImpl implements AccountService {

  private Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

  private final AccountRepository accountRepository;

  private final AuthServiceClient authServiceClient;

  public AccountServiceImpl(AccountRepository accountRepository,
      AuthServiceClient authServiceClient) {
    this.accountRepository = accountRepository;
    this.authServiceClient = authServiceClient;
  }

  @Override
  public Mono<Account> findByName(String username) {
    Assert.hasLength(username);
    return accountRepository.findByName(username);
  }

  @Override
  public Mono<Account> create(User user) {
    Account account = new Account();
    account.setName(user.getUsername());
    account.setLastSeen(new Date());
    return accountRepository.findByName(user.getUsername())
        .doOnSuccess(
            value -> {
              if (value != null) {
                throw new IllegalArgumentException("Account already exisits: " + value.getName());
              }
              authServiceClient.createUser(user);
            })
        .doOnError(error -> log
            .error("Error while creating user, {}", error.getCause().getLocalizedMessage()))
        .then(accountRepository.save(account));
  }

  @Override
  public void saveChanges(String name, Account update) {
    log.debug("account changes saved");
  }
}
