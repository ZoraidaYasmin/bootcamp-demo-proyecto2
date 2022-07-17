package com.proyecto1.payment.service;

import com.proyecto1.payment.entity.Payment;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PaymentService {

    Flux<Payment> findAll();

    Mono<Payment> create(Payment c);

    Mono<Payment> findById(String id);

    Mono<Payment> update(Payment c, String id);

    Mono<Payment> delete(String id);
}
