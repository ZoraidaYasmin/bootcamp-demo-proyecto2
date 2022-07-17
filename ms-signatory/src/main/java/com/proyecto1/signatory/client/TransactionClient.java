package com.proyecto1.signatory.client;

import com.proyecto1.signatory.entity.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class TransactionClient {
    private WebClient client = WebClient.create("http://transaction-service/transaction");

    public Mono<Transaction> getAccountWithDetails(String id){
        return client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/findByIdWithCustomer/{id}")
                        .build(id)
                )
                .retrieve()
                .bodyToMono(Transaction.class);
    };
}
