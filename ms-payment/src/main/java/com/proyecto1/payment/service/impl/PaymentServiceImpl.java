package com.proyecto1.payment.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.proyecto1.payment.entity.Payment;
import com.proyecto1.payment.entity.Transaction;
import com.proyecto1.payment.repository.PaymentRepository;
import com.proyecto1.payment.service.PaymentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PaymentServiceImpl implements PaymentService {

    private static final Logger log = LogManager.getLogger(PaymentServiceImpl.class);
    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    WebClient.Builder transactionClient;

    @Override
    public Flux<Payment> findAll() {
        log.info("Method call FindAll - payment");
        return paymentRepository.findAll();
    }

    @Override
    public Mono<Payment> create(Payment c) {
        log.info("Method call create - payment");
        return transactionClient.build().get()
                .uri(uriBuilder -> uriBuilder
                        .path("/findByIdWithCustomer/{id}")
                        .build(c.getTransactionId())
                )
                .retrieve()
                .bodyToMono(Transaction.class)
                .filter( x -> x.getProduct().getIndProduct() == 1)
                .hasElement()
                .flatMap( y -> {
                    if(y){
                        return paymentRepository.save(c);
                    }else{
                        return Mono.error(new RuntimeException("The payment you want to make is not a credit product"));
                    }
                });

    }

    @Override
    public Mono<Payment> findById(String id) {
        log.info("Method call findById - payment");
        return paymentRepository.findById(id);
    }

    @Override
    public Mono<Payment> update(Payment c, String id) {
        log.info("Method call update - payment");
        return paymentRepository.findById(id)
                .map( x -> {
                    x.setDate(c.getDate());
                    x.setPaymentAmount(c.getPaymentAmount());
                    x.setDescription(c.getDescription());
                    return x;
                }).flatMap(paymentRepository::save);
    }

    @Override
    public Mono<Payment> delete(String id) {
        log.info("Method call delete - payment");
        return paymentRepository.findById(id).flatMap( x -> paymentRepository.delete(x).then(Mono.just(new Payment())));
    }
}
