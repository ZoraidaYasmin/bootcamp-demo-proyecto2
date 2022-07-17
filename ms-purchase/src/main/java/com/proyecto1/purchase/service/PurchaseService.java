package com.proyecto1.purchase.service;

import com.proyecto1.purchase.entity.Purchase;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PurchaseService {

    Flux<Purchase> findAll();

    Mono<Purchase> create(Purchase c);

    Mono<Purchase> findById(String id);
    
    Flux<Purchase> findAllByTransactionId(String id);

    Mono<Purchase> update(Purchase c, String id);

    Mono<Purchase> delete(String id);
}
