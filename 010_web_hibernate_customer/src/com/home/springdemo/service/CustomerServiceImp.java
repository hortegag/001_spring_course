package com.home.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.springdemo.dao.CustomerDAO;
import com.home.springdemo.entity.Customer;


@Service
public class CustomerServiceImp implements CustomerService{
	
	// need to inject customer DAO
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers(){
		return customerDAO.getCustomers();
	}

}