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


	@Override
	@Transactional
	public void saveCustomer(Customer customer) {

		customerDAO.saveCustomer(customer);
		
	}


	@Override
	@Transactional
	public Customer getCustomer(int id) {
		return customerDAO.getCustomer(id);
	}


	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		
		 customerDAO.deleteCustomer(theId);
		
	}

}