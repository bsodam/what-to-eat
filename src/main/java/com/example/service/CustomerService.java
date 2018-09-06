package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Customer;
import com.example.domain.User;
import com.example.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> findAll() {
		return customerRepository.findAllOrderByName();
	}
	
	public Customer findOne(Integer id) {
		return customerRepository.findOne(id);
	}
	
	public Customer create(Customer customer, User user) {
		customer.setUser(user);
		return customerRepository.save(customer);
	}
	
	public Customer update(Customer customer, User user) {
		customer.setUser(user);
		return customerRepository.save(customer);
	}
	
	public void delete(Integer id) {
		customerRepository.delete(id);
	}
}
