package com.proyecto1.signatory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SignatoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SignatoryApplication.class, args);
	}

}
