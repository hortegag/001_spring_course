package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import oracle.jrockit.jfr.tools.ConCatRepository;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context
		= new ClassPathXmlApplicationContext("beanLifeCycleApplicationContext.xml");
				
		// retrieve bean from spring container
		
		Coach coach = context.getBean("myCoach",Coach.class);
		
		//Coach alphaCoach = context.getBean("myCoach",Coach.class);
		
		System.out.println(coach.getDailyWorkout());

		
		context.close();
		
		
		
		
		

	}

}
