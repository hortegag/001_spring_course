package com.home.springdemo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.omg.CORBA.Current;
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
		Query<Customer> theQuery = currentSession.createQuery("from Customer"
			                                                  +  " order by lastName", Customer.class);
		
		// get the result list from the query
		List<Customer> customers = theQuery.getResultList();
		
		// return the resultss
		return customers;
		
	}

	@Override
	public void saveCustomer(Customer customer) {
		
		
		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// if the id is null it will insert the record
		// if the id has a value it will update the record
		session.saveOrUpdate(customer);
		// save the customer 
		
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = session.get(Customer.class, id);
		
		return customer;

	}

	@Override
	public void deleteCustomer(int theId) {

		Session session = sessionFactory.getCurrentSession();
		
		
		Query theQuery = session.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
	
		
	}

	
	
}
