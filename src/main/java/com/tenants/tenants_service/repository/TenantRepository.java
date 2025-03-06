package com.tenants.tenants_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tenants.tenants_service.model.Tenant;

import java.util.List;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Integer> {

	@Modifying
    @Transactional
    @Query("UPDATE Tenant t SET t.roomId = :roomId WHERE t.tenantId = :id")
    void changeRoom(@Param("id") Integer id, @Param("roomId") Integer roomId);

    List<Tenant> findByRoomId(Integer roomId);

}
