package com.eg.swa.ntier.shopping.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eg.swa.ntier.shopping.model.Customer;
import com.eg.swa.ntier.shopping.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Optional<Customer> getCustomerById(Long customerId) {
		return customerRepository.findById(customerId);
	}

}
