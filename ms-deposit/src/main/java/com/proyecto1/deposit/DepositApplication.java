package com.proyecto1.deposit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DepositApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepositApplication.class, args);
	}

}
