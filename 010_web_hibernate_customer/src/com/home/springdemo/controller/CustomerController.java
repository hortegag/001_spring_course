package com.home.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.home.springdemo.entity.Customer;
import com.home.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	// need to inject the customer dao
	@Autowired
	private CustomerService customerService;
	
	
	
	//@RequestMapping("list")
	// GetMapping allow to accept only get request
	// PostMapping allow to accept only post request
	
	@GetMapping("/list")
	public String listCustomer(Model model){
		
		// get customers from the service
		List<Customer> customers = customerService.getCustomers();
		
		// add the customer to the model
		model.addAttribute("customers",customers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model){
		
		Customer customer = new Customer();
		model.addAttribute("customer",customer);
		
		
		
		
		return "customer-form";
	}
	
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer){
		
		//save the customer using service
		
		customerService.saveCustomer(customer);
		
		
		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model){
		
		// get the customer from the database
		Customer customer = customerService.getCustomer(id);
		
		
		// set customer as model attribute to preproulate the form
		model.addAttribute("customer",customer);
	
		
		return "customer-form";
	}
	
	

}
