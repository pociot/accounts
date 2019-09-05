package com.pociot.hcb.account.repository;

import com.pociot.hcb.account.domain.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AccountRepository extends ReactiveMongoRepository<Account, String> {
  Mono<Account> findByName(String name);
}
