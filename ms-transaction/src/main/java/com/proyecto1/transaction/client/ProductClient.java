package com.proyecto1.transaction.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.proyecto1.transaction.entity.Product;

import reactor.core.publisher.Mono;

@Component
public class ProductClient {
	
	private WebClient product = WebClient.create("http://localhost:9003/product");

    public Mono<Product> getProduct(String id){
    	return product.get()
                .uri("/find/"+id)
                /*.uri(uriBuilder -> uriBuilder
                        .path("/find/{id}")
                        .build(id))*/

                .retrieve()
                .bodyToMono(Product.class);
    }
}
