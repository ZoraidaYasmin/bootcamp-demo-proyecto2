package com.proyecto1.purchase;

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

    @Bean()
    @LoadBalanced
    WebClient.Builder registerWebTransaction() {
        return WebClient.builder().baseUrl(url);
    }
}
