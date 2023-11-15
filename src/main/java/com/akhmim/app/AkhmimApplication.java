package com.akhmim.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.akhmim.entities")
@EnableJpaRepositories(basePackages = "com.akhmim.repositories")
@ComponentScan(basePackages = { "com.akhmim.services", "com.akhmim.controllers" })
public class AkhmimApplication {

	public static void main(String[] args) {
		SpringApplication.run(AkhmimApplication.class, args);
	}

}
