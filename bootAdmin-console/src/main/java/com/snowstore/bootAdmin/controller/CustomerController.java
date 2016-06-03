package com.snowstore.bootAdmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.snowstore.bootAdmin.domain.Customer;
import com.snowstore.bootAdmin.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list")
	@ResponseBody
	public DataTablesOutput<Customer> list(DataTablesInput input){
		DataTablesOutput<Customer> output = customerService.findAll(input);
		return output;
	}
}
