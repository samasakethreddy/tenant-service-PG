package com.tenants.tenants_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TenantResponse {

	private int tenantId;
	private String tenantName;
	private String ownerId;
	private int tenantAge;
	private int roomId;
	private String aadharId;
	private String email;
	private String phoneNumber;
	private LocalDate joinDate;
}
