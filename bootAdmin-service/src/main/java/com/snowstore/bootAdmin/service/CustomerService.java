package com.snowstore.bootAdmin.service;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snowstore.bootAdmin.domain.Customer;
import com.snowstore.bootAdmin.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	private CustomerRepository customerRepository;

	public Customer get(Long id) {
		return customerRepository.findOne(id);
	}

	public DataTablesOutput<Customer> findAll(DataTablesInput input) {
		LOGGER.info("用户列表查询.....");
		return customerRepository.findAll(input);
	}
	
	@PostConstruct
	public void init(){
		if(customerRepository.count()>0){
			return;
		}
		for (int i = 0; i < 100; i++) {
			Customer c = new Customer();
			c.setUsername("username"+i);
			c.setEmail("email"+i);
			c.setIdCardName("idCardName"+i);
			c.setPhone("1323213"+i);
			customerRepository.save(c);
		}
	}
}
