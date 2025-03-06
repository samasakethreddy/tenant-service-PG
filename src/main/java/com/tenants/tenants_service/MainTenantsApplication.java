package com.tenants.tenants_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainTenantsApplication {

	public static void main(String[] args) {
		System.out.println("Tenant micro-service started...");
		SpringApplication.run(MainTenantsApplication.class, args);
	}
}