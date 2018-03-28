package com.home.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.home.aopdemo.dao.AccountDAO;

public class AfterThrowingDemo {

	public static void main(String[] args) {
		
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
	
		try {
			boolean generateException=true;
			List<Account> accounts = accountDAO.findAccounts(generateException);
			//
			System.out.println("------------------Ending afterreturning demo--------------");
			
			System.out.println(accounts);

		} catch (Exception e) {
			System.out.println("--------------Prnt the exceptio-----------------n");
			e.printStackTrace();
		}	
		
		
		// close the context
		context.close();

	}

}
