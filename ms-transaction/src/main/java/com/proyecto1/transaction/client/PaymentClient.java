package com.proyecto1.transaction.client;


import com.proyecto1.transaction.entity.Payment;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class PaymentClient {
    private WebClient client = WebClient.create("http://payment-service/payment");

    public Flux<Payment> getPayment(){
        return client.get()
                .uri("/findAll")
                .retrieve()
                .bodyToFlux(Payment.class);
    }
}
