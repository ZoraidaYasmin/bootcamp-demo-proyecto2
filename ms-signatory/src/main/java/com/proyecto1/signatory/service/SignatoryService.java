package com.proyecto1.signatory.service;

import com.proyecto1.signatory.entity.Signatory;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SignatoryService {

    Flux<Signatory> findAll();

    Mono<Signatory> create(Signatory c);

    Mono<Signatory> findById(String id);

    Mono<Signatory> update(Signatory c, String id);

    Mono<Signatory> delete(String id);
}
