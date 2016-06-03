package com.snowstore.bootAdmin.repository;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

import com.snowstore.bootAdmin.domain.AdminUser;

@Repository
public interface AdminUserRepository extends DataTablesRepository<AdminUser, Long> {

	public AdminUser findByUsername(String username);
}
