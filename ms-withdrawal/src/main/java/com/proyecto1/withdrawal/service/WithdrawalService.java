package com.proyecto1.withdrawal.service;

import com.proyecto1.withdrawal.entity.Withdrawal;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WithdrawalService {

    Flux<Withdrawal> findAll();

    Mono<Withdrawal> create(Withdrawal c);

    Mono<Withdrawal> findById(String id);

    Mono<Withdrawal> update(Withdrawal c, String id);

    Mono<Withdrawal> delete(String id);
}
