package com.home.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.home.aopdemo.dao.AccountDAO;
import com.home.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		
		
		// get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
	
		// call the business mehtod
		accountDAO.addAccount();
		
		System.out.println("Second call");
		accountDAO.addAccount();
		
		
		System.out.println("call addtest");
		accountDAO.addTestAccount();
		
		
		MembershipDAO membershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
		
		membershipDAO.addAccount();
				
		System.out.println("add test member accout");
		membershipDAO.addTesMemberAccount();
				
				
		// close the context
		context.close();

	}

}
