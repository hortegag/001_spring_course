package com.home.springdemo.service;

import java.util.List;

import com.home.springdemo.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);


}
