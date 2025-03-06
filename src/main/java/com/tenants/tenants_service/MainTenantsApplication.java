package com.tenants.tenants_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
public class MainTenantsApplication {

	public static void main(String[] args) {
		System.out.println("Tenant micro-service started...");
		SpringApplication.run(MainTenantsApplication.class, args);
	}
}