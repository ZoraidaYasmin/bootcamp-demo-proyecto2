package com.proyecto1.withdrawal.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.proyecto1.withdrawal.entity.Transaction;
import com.proyecto1.withdrawal.entity.Withdrawal;
import com.proyecto1.withdrawal.repository.WithdrawalRepository;
import com.proyecto1.withdrawal.service.WithdrawalService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WithdrawalServiceImpl implements WithdrawalService {

    private static final Logger log = LogManager.getLogger(WithdrawalServiceImpl.class);

    @Autowired
    WithdrawalRepository withdrawalRepository;

    @Autowired
    WebClient.Builder transactionClient;
    @Override
    public Flux<Withdrawal> findAll() {
        log.info("Method call FindAll - withdrawal");
        return withdrawalRepository.findAll();
    }

    @Override
    public Mono<Withdrawal> create(Withdrawal c) {
        log.info("Method call Create - withdrawal");
        return transactionClient.build().get()
                .uri(uriBuilder -> uriBuilder
                        .path("/findByIdWithCustomer/{id}")
                        .build(c.getTransactionId())
                )
                .retrieve()
                .bodyToMono(Transaction.class)
                .filter( x -> x.getProduct().getIndProduct() == 2)
                .hasElement()
                .flatMap( y -> {
                    if(y){
                        return withdrawalRepository.save(c);
                    }else{
                        return Mono.error(new RuntimeException("The account entered is not a bank account"));
                    }
                });

    }

    @Override
    public Mono<Withdrawal> findById(String id) {
        log.info("Method call FindById - withdrawal");
        return withdrawalRepository.findById(id);
    }

    @Override
    public Mono<Withdrawal> update(Withdrawal c, String id) {
        log.info("Method call Update - withdrawal");
        return withdrawalRepository.findById(id)
                .map( x -> {
                    x.setDate(c.getDate());
                    x.setWithdrawalAmount(c.getWithdrawalAmount());
                    x.setDescription(c.getDescription());
                    return x;
                }).flatMap(withdrawalRepository::save);
    }

    @Override
    public Mono<Withdrawal> delete(String id) {
        log.info("Method call Delete - withdrawal");
        return withdrawalRepository.findById(id).flatMap( x -> withdrawalRepository.delete(x).then(Mono.just(new Withdrawal())));
    }
}
