package com.proyecto1.signatory.service.impl;

import com.proyecto1.signatory.client.TransactionClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto1.signatory.entity.Signatory;
import com.proyecto1.signatory.repository.SignatoryRepository;
import com.proyecto1.signatory.service.SignatoryService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SignatoryServiceImpl implements SignatoryService {
	
	private static final Logger log = LogManager.getLogger(SignatoryServiceImpl.class);

    @Autowired
    SignatoryRepository signatoryRepository;

    @Autowired
    TransactionClient transactionClient;

    @Override
    public Flux<Signatory> findAll() {
        log.info("Method call FindAll - signatory");
        return signatoryRepository.findAll();
    }

    @Override
    public Mono<Signatory> create(Signatory c) {
        log.info("Method call Create - signatory");

        return transactionClient.getAccountWithDetails(c.getTransactionId())
                .filter( x -> x.getProduct().getIndProduct() == 1)
                .filter(z -> z.getCustomer().getTypeCustomer() == 2)
                .hasElement()
                .flatMap( y -> {
                    if(y){
                        return signatoryRepository.save(c);
                    }else{
                        return Mono.error(new RuntimeException("The account entered is not a business bank account"));
                    }
                });
    }

    @Override
    public Mono<Signatory> findById(String id) {
        log.info("Method call findById - signatory");
        return signatoryRepository.findById(id);
    }

    @Override
    public Mono<Signatory> update(Signatory c, String id) {
        log.info("Method call Update - signatory");
        return signatoryRepository.findById(id)
                .map( x -> {
                    x.setName(c.getName());
                    x.setLastName(c.getLastName());
                    x.setDocNumber(c.getDocNumber());
                    return x;
                }).flatMap(signatoryRepository::save);
    }

    @Override
    public Mono<Signatory> delete(String id) {
        log.info("Method call Delete - signatory");
        return signatoryRepository.findById(id).flatMap( x -> signatoryRepository.delete(x).then(Mono.just(new Signatory())));
    }
}
