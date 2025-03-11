package com.tenants.tenants_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
public class MainTenantsApplication {
	public static void main(String[] args) {
		System.out.println("Tenant micro-service started...");
		SpringApplication.run(MainTenantsApplication.class, args);
	}
}