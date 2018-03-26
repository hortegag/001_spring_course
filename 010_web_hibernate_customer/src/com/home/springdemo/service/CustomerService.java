package com.home.springdemo.service;

import java.util.List;

import com.home.springdemo.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int theId);
	
    public List<Customer> searchCustomers(String theSearchName);

}
