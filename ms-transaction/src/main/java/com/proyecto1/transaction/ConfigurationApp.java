package com.proyecto1.transaction;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ConfigurationApp {
	
	@Value("${config.customer.endpoint}")
	String url;
	
	@Value("${config.product.endpoint}")
	String urlProduct;
	
	@Value("${config.deposit.endpoint}")
	String urlDeposit;
	
	@Value("${config.payment.endpoint}")
	String urlPayment;
	
	@Value("${config.purchase.endpoint}")
	String urlPurchase;
	
	@Value("${config.signatory.endpoint}")
	String urlSignatory;
	
	@Value("${config.withdrawal.endpoint}")
	String urlWithdrawal;

    @Bean(name = "customer")
    @LoadBalanced
    WebClient.Builder registerWebClient() {
        return WebClient.builder().baseUrl(url);
    }

    @Bean(name = "product")
    @LoadBalanced
    WebClient.Builder registerWebClientProduct() {
        return WebClient.builder().baseUrl(urlProduct);
    }
    
    @Bean(name = "deposit")
    @LoadBalanced
    WebClient.Builder registerWebClientDeposit() {
        return WebClient.builder().baseUrl(urlDeposit);
    }
    
    @Bean(name = "payment")
    @LoadBalanced
    WebClient.Builder registerWebClientPayment() {
        return WebClient.builder().baseUrl(urlPayment);
    }
    
    @Bean(name = "purchase")
    @LoadBalanced
    WebClient.Builder registerWebClientPurchase() {
        return WebClient.builder().baseUrl(urlPurchase);
    }
    
    @Bean(name = "signatory")
    @LoadBalanced
    WebClient.Builder registerWebClientSignatory() {
        return WebClient.builder().baseUrl(urlSignatory);
    }
    
    @Bean(name = "withdrawal")
    @LoadBalanced
    WebClient.Builder registerWebClientWithdrawal() {
        return WebClient.builder().baseUrl(urlWithdrawal);
    }
}
