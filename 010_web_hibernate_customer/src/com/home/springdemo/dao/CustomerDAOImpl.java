package com.home.springdemo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.home.springdemo.entity.Customer;

// @Repository with this annotation spring can detect it with component scans and 
// handle the exception translation 
@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	//need to inject the session factory
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		// create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		
		// get the result list from the query
		List<Customer> customers = theQuery.getResultList();
		
		// return the resultss
		return customers;
		
	}

}
