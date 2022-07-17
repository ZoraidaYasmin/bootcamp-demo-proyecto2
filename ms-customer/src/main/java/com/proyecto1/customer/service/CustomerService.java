package com.proyecto1.customer.service;

import com.proyecto1.customer.entity.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Flux<Customer> findAll();

    Mono<Customer> create(Customer c);

    Mono<Customer> findById(String id);

    Mono<Customer> update(Customer c, String id);

    Mono<Customer> delete(String id);
}
