package com.proyecto1.transaction.client;

import com.proyecto1.transaction.entity.Customer;
import com.proyecto1.transaction.entity.Deposit;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class DepositClient {
    private WebClient client = WebClient.create("http://localhost:9005/deposit");

    public Flux<Deposit> getDeposit(){
        return client.get()
                .uri("/findAll")
                .retrieve()
                .bodyToFlux(Deposit.class);
    }
}
