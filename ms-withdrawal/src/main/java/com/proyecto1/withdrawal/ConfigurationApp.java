package com.proyecto1.withdrawal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ConfigurationApp {
	
	@Value("${config.transaction.endpoint}")
	String url;

    @Bean()
    @LoadBalanced
    WebClient.Builder registerWebTransaction() {
        return WebClient.builder().baseUrl(url);
    }
}
