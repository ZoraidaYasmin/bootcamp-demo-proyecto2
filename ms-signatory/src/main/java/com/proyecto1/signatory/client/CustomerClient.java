package com.proyecto1.signatory.client;

import com.proyecto1.signatory.entity.Customer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class CustomerClient {

    private WebClient client = WebClient.create("http://localhost:9002/customer");

    public Mono<Customer> getCustomer(String id){
        return client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/find/{id}")
                        .build(id)
                )
                .retrieve()
                .bodyToMono(Customer.class);
    };
}
