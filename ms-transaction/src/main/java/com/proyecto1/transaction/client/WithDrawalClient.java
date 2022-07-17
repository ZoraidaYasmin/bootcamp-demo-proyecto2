package com.proyecto1.transaction.client;


import com.proyecto1.transaction.entity.Withdrawal;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class WithDrawalClient {
    private WebClient client = WebClient.create("http://localhost:9009/withdrawal");

    public Flux<Withdrawal> getWithDrawal(){
        return client.get()
                .uri("/findAll")
                .retrieve()
                .bodyToFlux(Withdrawal.class);
    }
}
