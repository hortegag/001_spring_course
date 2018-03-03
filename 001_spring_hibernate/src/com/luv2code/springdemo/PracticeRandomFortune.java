package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeRandomFortune {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		CrossFitCoach coach = context.getBean("myCrossFitCoach",CrossFitCoach.class);
		
		System.out.println(coach.getDailyFortune());
		
		context.close();
		
		
		
	}

}
