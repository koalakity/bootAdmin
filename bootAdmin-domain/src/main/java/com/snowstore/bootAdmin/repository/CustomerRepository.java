package com.snowstore.bootAdmin.repository;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

import com.snowstore.bootAdmin.domain.Customer;


@Repository
public interface CustomerRepository extends DataTablesRepository<Customer, Long>{
	
}
