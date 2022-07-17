package com.proyecto1.withdrawal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class WithdrawalApplication {

	public static void main(String[] args) {
		SpringApplication.run(WithdrawalApplication.class, args);
	}

}
