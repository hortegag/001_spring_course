package com.home.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.home.springdemo.dao.CustomerDAO;
import com.home.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	// need to inject the customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	
	
	//@RequestMapping("list")
	// GetMapping allow to accept only get request
	// PostMapping allow to accept only post request
	
	@GetMapping("/list")
	public String listCustomer(Model model){
		
		// get customers from the dao
		List<Customer> customers = customerDAO.getCustomers();
		
		// add the customer to the model
		model.addAttribute("customers",customers);
		
		return "list-customers";
	}
	

}
