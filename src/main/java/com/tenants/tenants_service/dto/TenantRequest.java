package com.tenants.tenants_service.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

//{
//		"tenantName": "John Doe",
//		"tenantAge": 25,
//		"roomId": 101,
//		"aadharId": 123456789012,
//		"email": "johndoe@example.com",
//		"phoneNumber": "9876543210",
//		"joinDate": "2024-03-02"
//		}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TenantRequest {

	@NotBlank(message = "Tenant name cannot be empty")
	private String tenantName;

	@Min(value = 18, message = "Tenant must be at least 18 years old")
	private int tenantAge;

	@Min(value = 1, message = "Room ID must be a positive number")
	private int roomId;

	@NotNull(message = "Aadhar ID is required")
	@Min(value = 100000000000L, message = "Invalid Aadhar ID")
	private int aadharId;

	@Email(message = "Invalid email format")
	@NotBlank(message = "Email cannot be empty")
	private String email;

	@Pattern(regexp = "^[0-9]{10,15}$", message = "Phone number must be between 10-15 digits")
	@NotBlank(message = "Phone number cannot be empty")
	private String phoneNumber;

	@NotNull(message = "Join date is required")
	private LocalDate joinDate;
}
