package com.tenants.tenants_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tenant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tenantId;

	@NotBlank(message = "Tenant name cannot be empty")
	private String tenantName;

	@Min(value = 18, message = "Tenant must be at least 18 years old")
	private int tenantAge;

	private int roomId;

	private String ownerId;

	@Column(unique = true, nullable = false)
	@NotNull(message = "Aadhar ID is required")
	private String aadharId;

	@Email(message = "Invalid email format")
	@Column(unique = true, nullable = false)
	private String email;

	@Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be between 10-15 digits")
	private String phoneNumber;

	@Column(nullable = false)
	@NotNull(message = "Join date is required")
	private LocalDate joinDate;
}
