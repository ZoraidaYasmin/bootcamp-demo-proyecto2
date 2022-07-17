package com.proyecto1.transaction.service;

import com.proyecto1.transaction.entity.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {

    Flux<Transaction> findAll();

    Mono<Transaction> save(Transaction t);

    Mono<Transaction> findById(String id);

    Mono<Transaction> update(Transaction t, String id);

    Mono<Transaction> delete(String id);

    Mono<Transaction> findByIdWithCustomer(String id);
    
    Flux<Transaction> findAllWithDetail();

    //Flux<Transaction> findAllData(String id);
}
