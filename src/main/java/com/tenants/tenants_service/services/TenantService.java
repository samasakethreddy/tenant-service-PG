package com.tenants.tenants_service.services;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenants.tenants_service.dto.TenantRequest;
import com.tenants.tenants_service.dto.TenantResponse;
import com.tenants.tenants_service.model.Tenant;
import com.tenants.tenants_service.repository.TenantRepository;

@Service
public class TenantService {

	@Autowired
	private TenantRepository tenantRepository;

	public Tenant saveTenant(TenantRequest tenantRequest) {

		Tenant tenant = Tenant.builder()
				.tenantName(tenantRequest.getTenantName())
				.tenantAge(tenantRequest.getTenantAge())
				.roomId(tenantRequest.getRoomId())
				.aadharId(tenantRequest.getAadharId())
				.email(tenantRequest.getEmail())
				.phoneNumber(tenantRequest.getPhoneNumber())
				.joinDate(tenantRequest.getJoinDate())
				.build();

		tenantRepository.save(tenant);

		System.out.println("Tenant saved successfully...");

		return tenant;
	}

	public List<TenantResponse> getTenants() {
		List<Tenant> tenants = tenantRepository.findAll();
		return tenants.stream().map(this::mapToResponse).toList();
	}

	public TenantResponse getTenantById(Integer id) {
		return tenantRepository.findById(id)
				.map(this::mapToResponse)
				.orElseThrow(() -> new RuntimeException("Tenant not found with ID: " + id));
	}

	@Transactional
	public TenantResponse changeTenantRoomId(Integer id, Integer roomId) {
		Optional<Tenant> tenantOptional = tenantRepository.findById(id);

		if (tenantOptional.isPresent()) {
			tenantRepository.changeRoom(id, roomId);
			return getTenantById(id);
		} else {
			throw new RuntimeException("Tenant not found with ID: " + id);
		}
	}

	public List<TenantResponse> findByRoomId(Integer roomId) {
		return tenantRepository.findByRoomId(roomId)
				.stream().map(this::mapToResponse).toList();
	}

	private TenantResponse mapToResponse(Tenant tenant) {
		return TenantResponse.builder()
				.tenantId(tenant.getTenantId())
				.tenantName(tenant.getTenantName())
				.tenantAge(tenant.getTenantAge())
				.roomId(tenant.getRoomId())
				.aadharId(tenant.getAadharId())
				.email(tenant.getEmail())
				.phoneNumber(tenant.getPhoneNumber())
				.joinDate(tenant.getJoinDate())
				.build();
	}
}
