package com.proyecto1.signatory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@EnableEurekaClient
@Configuration
public class ConfigurationApp {
	
	@Value("${config.transaction.endpoint}")
	String url;
	
	@Value("${config.transaction.endpoint}")
	String urlCustomer;
	
	@Value("${config.transaction.endpoint}")
	String urlProduct;

    @Bean(name = "transaction")
    @LoadBalanced
    WebClient.Builder registerWebTransaction() {
        return WebClient.builder().baseUrl(url);
    }
    
    @Bean(name = "customer")
    @LoadBalanced
    WebClient.Builder registerWebCustomer() {
        return WebClient.builder().baseUrl(urlCustomer);
    }
    
    @Bean(name = "product")
    @LoadBalanced
    WebClient.Builder registerWebProduct() {
        return WebClient.builder().baseUrl(urlProduct);
    }
}
