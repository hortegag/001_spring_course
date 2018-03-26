package com.home.springdemo.dao;

import java.util.List;

import com.home.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int theId);
	
    public List<Customer> searchCustomers(String theSearchName);


}
