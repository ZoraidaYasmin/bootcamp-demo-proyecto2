package com.proyecto1.transaction.client;

import com.proyecto1.transaction.entity.Signatory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
@Component
public class SignatoryClient {
    private WebClient client = WebClient.create("http://localhost:9008/signatory");

    public Flux<Signatory> getSignatory(){
        return client.get()
                .uri("/findAll")
                .retrieve()
                .bodyToFlux(Signatory.class);
    }
}
