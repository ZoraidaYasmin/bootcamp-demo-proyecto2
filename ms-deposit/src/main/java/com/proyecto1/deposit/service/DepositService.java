package com.proyecto1.deposit.service;

import com.proyecto1.deposit.entity.Deposit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DepositService {

    Flux<Deposit> findAll();

    Mono<Deposit> create(Deposit c);

    Mono<Deposit> findById(String id);

    Mono<Deposit> update(Deposit c, String id);

    Mono<Deposit> delete(String id);
}
