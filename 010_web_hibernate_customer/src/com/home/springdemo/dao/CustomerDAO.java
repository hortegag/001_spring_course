package com.home.springdemo.dao;

import java.util.List;

import com.home.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();
}
