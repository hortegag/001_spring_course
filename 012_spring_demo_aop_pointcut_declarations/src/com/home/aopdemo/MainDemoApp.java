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
		
		Account account = new Account();
		
		System.out.println("adding a new accoutn with a parameter");
		accountDAO.addNewAccount(account);
		
		
		System.out.println("adding a important person account");
		accountDAO.addNewAccount(account,true);
		
		System.out.println("\n\nGet methods");
		accountDAO.getExample();
		System.out.println("\n\nSet Methods");
		accountDAO.setExample();
		
		// close the context
		context.close();

	}

}
