package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import oracle.jrockit.jfr.tools.ConCatRepository;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context
		= new ClassPathXmlApplicationContext("beanScopeApplicationContext.xml");
		
		
		
		// retrieve bean from spring container
		
		Coach coach = context.getBean("myCoach",Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach",Coach.class);
		
		
		boolean result = (coach == alphaCoach);
		
		System.out.println("Pointing to the same object: "+result);
		
		System.out.println("Memory location for coach: " +coach );
		
		System.out.println("Memory location for alphaCoach: " +alphaCoach );

		
		context.close();
		
		
		
		
		

	}

}
