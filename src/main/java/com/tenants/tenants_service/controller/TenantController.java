package com.tenants.tenants_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tenants.tenants_service.dto.TenantRequest;
import com.tenants.tenants_service.dto.TenantResponse;
import com.tenants.tenants_service.model.Tenant;
import com.tenants.tenants_service.services.TenantService;

@RestController
@RequestMapping("/api/tenants")
public class TenantController {
    
    @Autowired
    private TenantService tenantService;

    @PostMapping
    Tenant postTenant(@RequestBody TenantRequest tenant) {
    	return tenantService.saveTenant(tenant);
    }

    @GetMapping("/allTenants")
    List<TenantResponse> getAllTenants() {
        return tenantService.getTenants();
    }
    
    @GetMapping("/{id}")
    public TenantResponse getTenant(@PathVariable("id") Integer id) {
        return tenantService.getTenantById(id);
    }
    
    
    @PutMapping("changeRoom/{id}/{roomId}")
    public TenantResponse changeTenantRoomId(@PathVariable("id") Integer id, @PathVariable("roomId") Integer roomId) {
        return tenantService.changeTenantRoomId(id, roomId);
    }

    @GetMapping("/byRoom/{roomId}")
    public List<TenantResponse> findTenantsByRoomId(@PathVariable("roomId") Integer roomId){
        return tenantService.findByRoomId(roomId);
    }

}
