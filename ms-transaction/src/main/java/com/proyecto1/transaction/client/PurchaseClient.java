package com.proyecto1.transaction.client;

import com.proyecto1.transaction.entity.Purchase;
import com.proyecto1.transaction.entity.Withdrawal;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class PurchaseClient {
    private WebClient client = WebClient.create("http://purchase-service/purchase");

    public Flux<Purchase> getPurchase(){
        return client.get()
                .uri("/findAll")
                .retrieve()
                .bodyToFlux(Purchase.class);
    }
}
